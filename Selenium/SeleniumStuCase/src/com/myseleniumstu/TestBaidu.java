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
		// �жϵ�ǰ��ҳ�����
		Assert.assertEquals(driver.getTitle(), "�ٶ�һ�£����֪��");
		
		// �ж��������Ƿ���ʾ
		Assert.assertTrue(driver.findElement(By.id("kw")).isDisplayed());
	}

}
