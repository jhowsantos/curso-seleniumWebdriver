package suporte;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Web {
	public static WebDriver createChrome(){
		// Abrindo o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jhow\\drivers\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
     // Navegando para a página do Taskit
        navegador.get("http://www.juliodelima.com.br/taskit");
        
        return navegador;
	}
}
