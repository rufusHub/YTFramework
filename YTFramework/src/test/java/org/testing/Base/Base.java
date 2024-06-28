package org.testing.Base;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class Base {
	
	public ChromeDriver driver = new ChromeDriver();
	public Actions action = new Actions(driver);
	public Properties pr;

	@BeforeMethod
	public void init() throws IOException {
		File f = new File("../YTFramework/objectRepository.properties");
		FileReader fr = new FileReader(f);
		pr = new Properties();
		pr.load(fr);		
	}
	
	@BeforeMethod(dependsOnMethods="init")
	public void launchUrlMax() {
		driver.get("https://www.youtube.com");
		driver.manage().window().maximize();
	}
	
	@BeforeMethod(dependsOnMethods="launchUrlMax")
	public void login() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.linkText(pr.getProperty("SignInButton"))).click();
		Thread.sleep(2000);
		driver.findElement(By.id(pr.getProperty("EmailOrPhone"))).sendKeys("cracksula@gmail.com");		
		Thread.sleep(2000);
		driver.findElement(By.xpath(pr.getProperty("ClickNext"))).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(pr.getProperty("Password"))).sendKeys("crackSULA20#$");
		Thread.sleep(2000);
		driver.findElement(By.xpath(pr.getProperty("ClickNext"))).click();
		Thread.sleep(4000);		
	}
	
	@AfterMethod
	public void logout() throws InterruptedException {
		driver.findElement(By.id("avatar-btn")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(pr.getProperty("SignOutButton"))).click();
	}
		
	@AfterMethod(dependsOnMethods="logout")
	public void browserClose() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
	
}
