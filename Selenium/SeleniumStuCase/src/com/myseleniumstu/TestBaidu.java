package com.myseleniumstu;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestBaidu {

	private WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.get("https://www.baidu.com/");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() {
		// 判断当前的页面标题
		Assert.assertEquals(driver.getTitle(), "百度一下，你就知道");
		
		// 判断搜索框是否显示
		Assert.assertTrue(driver.findElement(By.id("kw")).isDisplayed());
	}

}
