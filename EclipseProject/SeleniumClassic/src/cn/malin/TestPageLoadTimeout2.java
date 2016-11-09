package cn.malin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestPageLoadTimeout2 {
	
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		// 此1秒设置超时生效
		driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.SECONDS);
		try {
			driver.get("http://www.163.com");
		} catch (Exception e) {
			System.out.println("aaa");
		}
		
		System.out.println("bbbbbbbbbbbbb");
		// 此30秒设置超时也可以生效
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.findElement(By.linkText("财经")).click();
	}

}
