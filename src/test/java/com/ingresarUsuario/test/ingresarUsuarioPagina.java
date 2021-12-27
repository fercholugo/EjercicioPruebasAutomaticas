package com.ingresarUsuario.test;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ingresarUsuarioPagina {

	private WebDriver driver;
	By login = By.className("login");
	By email = By.id("email");
	By passwd = By.id("passwd");
	By submitLogin = By.id("SubmitLogin");
	LocalDate todaysDate = LocalDate.now();
	
	public ingresarUsuarioPagina(WebDriver driver){
		this.driver = driver;
	}
	
	public void screenShot() throws Throwable {
		File screenfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(screenfile, new File("IngresarUsuarioTest fecha: " + todaysDate + ".png"));
	}
	
	public void ingresarUsuario() {
		driver.findElement(login).click();
		driver.findElement(By.id("email")).sendKeys("ferchogoku@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("12345");
		driver.findElement(By.id("SubmitLogin")).click();		
		System.out.println("El test ingresarUsuario ha finalizado correctamente");
	}
}
