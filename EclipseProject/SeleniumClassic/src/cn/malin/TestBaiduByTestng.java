package cn.malin;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class TestBaiduByTestng {
	private WebDriver driver;
    private String baseUrl;
    
  @Test
  public void f() {
	  driver.get(baseUrl);
	    driver.findElement(By.id("kw")).click();
	    driver.findElement(By.id("kw")).clear();
	    driver.findElement(By.id("kw")).sendKeys("AK47");
	    driver.findElement(By.id("su")).click();
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  driver = new FirefoxDriver();
	    baseUrl = "https://www.baidu.com/";
  }

  @AfterMethod
  public void afterMethod() {
	 // driver.quit();
  }

}
