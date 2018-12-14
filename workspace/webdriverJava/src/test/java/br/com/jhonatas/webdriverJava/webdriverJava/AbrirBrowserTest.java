package br.com.jhonatas.webdriverJava.webdriverJava;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import suporte.Web;

public class AbrirBrowserTest {
	private WebDriver navegador;
	
	@Test
	public void abrirBrowser(){
		navegador = new Web().createChrome();
	}
}
