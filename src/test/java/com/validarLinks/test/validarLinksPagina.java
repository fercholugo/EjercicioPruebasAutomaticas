package com.validarLinks.test;

import static org.junit.Assert.assertNotNull;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import net.bytebuddy.build.Plugin.Engine.Source.Empty;

public class validarLinksPagina {
	private WebDriver driver;
	
	public validarLinksPagina(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean validarLinks() {
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		String url = "";
		List<String> linksInvalidos = new ArrayList<String>();
		List<String> linksValidos = new ArrayList<String>();
		
		HttpURLConnection httpConection = null;
		int responseCode = 200;
		Iterator<WebElement> it = links.iterator();
		
		while (it.hasNext()) {
			url = it.next().getAttribute("href");			
			try {
				httpConection = (HttpURLConnection)(new URL(url).openConnection());
				httpConection.setRequestMethod("HEAD");
				httpConection.connect();
				responseCode = httpConection.getResponseCode();
				
				if (responseCode>400) {
					System.out.println("ERROR LINK INVALIDO " + url);
					linksInvalidos.add(url);
					 
				}
				else {
					System.out.println("LINK VALIDO " + url);
					linksValidos.add(url);
				}
				
				
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();		
			}
			
		}
		
		System.out.println("LINKS VALIDOS ---------------------------" + linksValidos.size() + "-----------------------------------");
		System.out.println("LINKS INVALIDOS -------------------------" + linksInvalidos.size() + "---------------------------------");
		if (linksInvalidos.size()>0) {
			System.out.println("*****ERROR -----------------LINKS INVALIDOS");
			for (int i = 0; i < linksInvalidos.size(); i++) {
				System.out.println(linksInvalidos.get(i));
			}
			return false;
			
		}
		else {
			return true;
		}
						
	}
	
}













