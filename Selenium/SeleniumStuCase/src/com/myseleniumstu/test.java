package com.myseleniumstu;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class test {
	public static void main(String[] args) throws InterruptedException{
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
		try{
			WebDriverWait wait = new WebDriverWait(driver, 1);
			wait.until(new ExpectedCondition<Object>() {

				@Override
				public Object apply(WebDriver arg0) {
					driver.get("http://www.sohu.com");
					// http://search.jd.com/Search?keyword=xiaopingguo
					return null;
				}
			});
			
		}catch(Exception e){
			System.out.println("加载时间过时！");
			System.out.println(e.getClass().toString());
			Actions act = new Actions(driver);
			act.sendKeys(Keys.ESCAPE).perform();
		}
		
/*		
		Thread.sleep(3000);
		new Actions(driver).keyDown(Keys.ESCAPE).keyUp(Keys.ESCAPE).perform();;
	
		WebElement e = driver.findElement(By.partialLinkText("说说我使用搜索"));
		System.out.println(e.getLocation());
		System.out.println(e.isDisplayed());
		new Actions(driver).moveToElement(e).perform();
		
		WebElement k = driver.findElement(By.partialLinkText("说说我使用搜索"));
		System.out.println(k.getLocation());
		new Actions(driver).moveToElement(k).perform();*/
		
		//Thread.sleep(3000);
		

	}
	
}
