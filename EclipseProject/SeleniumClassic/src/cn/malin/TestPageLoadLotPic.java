package cn.malin;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class TestPageLoadLotPic {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.SECONDS);
		try{
			driver.get("http://localhost/testweb/PageLoadTest/JS_LoadLotPic.html");
		}catch(TimeoutException e){
			System.out.println("out le");
		}
		
		
		List<WebElement> imgList = driver.findElements(By.tagName("img"));
		int listSize = imgList.size();
		int rand = (int)(Math.random() * listSize);
		WebElement randImg = imgList.get(rand);
		
		System.out.println(listSize);
		System.out.println(rand);
		System.out.println(randImg.isDisplayed());
		
		Actions act = new Actions(driver);
		act.moveToElement(randImg).perform();
		
/*		WebElement u = driver.findElement(By.id("p8"));
		System.out.println(u.isDisplayed());
		System.out.println(u.isEnabled());
		Actions act = new Actions(driver);
		act.moveToElement(u).perform();*/

	}

}
