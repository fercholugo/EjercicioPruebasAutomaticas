package com.ingresarUsuario.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.validarLinks.test.validarLinksPagina;

public class ingresarUsuarioTest {
	
	WebDriver driver;
	ingresarUsuarioPagina usuarioPagina;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		usuarioPagina = new ingresarUsuarioPagina(driver);
		driver.get("http://automationpractice.com/index.php");
	}
	
	@Test
	public void test() throws Exception {
		usuarioPagina.ingresarUsuario();
	}
	
	
	@After
	public void tearDown() throws Exception {
		driver.close();
	}

}
