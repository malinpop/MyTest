package cn.malin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestPageLoad {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://localhost/testweb/PageLoadTest/JS_LoadSlow.html");
		
		driver.findElement(By.id("i1")).sendKeys("aaaaa");
		
		driver.findElement(By.id("m11")).click();
		
		driver.findElement(By.linkText("go")).click();
		
		driver.findElement(By.id("i2")).sendKeys("bbbbb");
	}

}
