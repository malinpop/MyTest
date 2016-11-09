package cn.malin;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class TestJDSearchLoadLazy {
	public static void main(String[] args) throws InterruptedException, IOException{
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();

		driver.get("http://search.jd.com/Search?keyword=huawei");
		
		WebElement e = driver.findElement(By.partialLinkText("说说我使用搜索"));
		new Actions(driver).moveToElement(e).perform();
		
		WebElement k = driver.findElement(By.partialLinkText("说说我使用搜索"));
		new Actions(driver).moveToElement(k).perform();
	}
	
}
