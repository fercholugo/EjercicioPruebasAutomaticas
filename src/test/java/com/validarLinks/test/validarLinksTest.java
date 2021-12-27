package com.validarLinks.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class validarLinksTest {
	
	WebDriver driver;
	validarLinksPagina pagina;
	

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		pagina = new validarLinksPagina(driver);
		driver.get("http://automationpractice.com/index.php");
		
	}

	@Test
	public void TestValidarLinks() {
		pagina.validarLinks();		
	}

	@After
	public void tearDown() throws Exception {
		driver.close();
	}

}
