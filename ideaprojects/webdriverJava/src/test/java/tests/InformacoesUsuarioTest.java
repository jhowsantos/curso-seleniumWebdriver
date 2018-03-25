package tests;

import static org.junit.Assert.*;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import suporte.Generator;
import suporte.Screenshot;
import suporte.Web;

import java.util.concurrent.TimeUnit;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "InformacoesUsuariosTest.csv")
public class InformacoesUsuarioTest {
    private WebDriver navegador;

     @Rule
     public TestName test = new TestName();

    @Before
    public void setUp(){
        navegador = Web.createChrome();

        // Clicar no link que possui o texto "Sign in"
        WebElement linkSignIn = navegador.findElement(By.linkText("Sign in")); // ou navegador.findElement(By.linkText("SIgn in")).click();
        linkSignIn.click();

        // Identificando o formulario de login
        WebElement formularioSignBox = navegador.findElement(By.id("signinbox"));

        // Digitar no campo de name "login" que esta dentro do formulario de id "signinbox" o texto "julio0001"
        formularioSignBox.findElement(By.name("login")).sendKeys("julio0001");

        // Digitar no campo de name "password" que esta dentro do formulario de id "signinbox" o texto "123456"
        formularioSignBox.findElement(By.name("password")).sendKeys("123456");

        // Clicar no link com o texto "SIGN IN"
        navegador.findElement(By.linkText("SIGN IN")).click();

        // Clicar em um link que possui a class "me"
        navegador.findElement(By.className("me")).click();

        // Clicar em um link que possui o texto "MORE DATA ABOUT YOU"
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
    }

    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(@Param(name="tipo")String tipo, @Param(name="contato")String contato, @Param(name="mensagemEsperada")String mensagemEsperada) {

        // Clicar no botão atraves do seu XPATH //button[@data-target="addmoredata"]
        navegador.findElement(By.xpath("//button[@data-target='addmoredata']")).click();

        // Identificar a popup onde esta o formulario de id addmoredata
        WebElement popupAddMoreData = navegador.findElement(By.id("addmoredata"));

        // Na combo de name "type" escolher a opção "Phone"
        WebElement campoType = popupAddMoreData.findElement(By.name("type"));
        new Select(campoType).selectByVisibleText(tipo);

        // No campo de name "contact" digitar "+5511988887777"
        popupAddMoreData.findElement(By.name("contact")).sendKeys(contato);

        // Clicar no link de text "SAVE" que esta no popup
        popupAddMoreData.findElement(By.linkText("SAVE")).click();

        // Na mensagem de id "toast-container" validar que o texto é "Your contact has been added!"
        WebElement mensagemPopup = navegador.findElement(By.id("toast-container"));
        String mensagem = mensagemPopup.getText();
        assertEquals(mensagemEsperada, mensagem);


        /** Validar que dentro do elemento com class "me" está o texto "Hi, Julio"
        WebElement me = navegador.findElement(By.className("me"));
        String textoNoElementoMe = me.getText();

        assertEquals("Hi, Julio", textoNoElementoMe); */

    }

    @Test
    public void removerUmContatoDeUmUsuario(){
        // Clicar no elemento pelo seu xpath //span[text()="+5511952454312"]/following-siblings::a
        navegador.findElement(By.xpath("//span[text()=\"+5511988776666\"]/following-sibling::a")).click();

        // Confirmar a janela javascript
        navegador.switchTo().alert().accept();

        // Validar que a mensagem apresentada foi "Rest in peace, dear phone!"
        WebElement mensagemPopup = navegador.findElement(By.id("toast-container"));
        String mensagem = mensagemPopup.getText();
        assertEquals("Rest in peace, dear phone!", mensagem);

        String screenshotArquivo = "C:\\Users\\Jhow\\IdeaProjects\\testReport\\" + Generator.dataHoraParaArquivo() + test.getMethodName() +".png";
        Screenshot.tirar(navegador, screenshotArquivo);

        // Aguardar até 10 segundos para que a janela desapareça
        WebDriverWait aguardar = new WebDriverWait(navegador, 10);
        aguardar.until(ExpectedConditions.stalenessOf(mensagemPopup));

        // Clicar no link com o texto "Logout"
        navegador.findElement(By.linkText("Logout")).click();
    }

    @After
    public void tearDown(){
        //Fechar o navegador
        navegador.quit();
    }
}
