package cn.malin;

import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class TestJDSearchLoadLazy2 {
	public static void main(String[] args) throws InterruptedException, IOException{
		PrintStream ps1 = new PrintStream("log1.txt");
		PrintStream ps2 = new PrintStream("log2.txt");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
		
		System.out.println(df.format(new Date()));
		driver.get("http://search.jd.com/Search?keyword=huawei");
		System.out.println(df.format(new Date()));
		
		// ���ϵȴ�ʱ�䣬��ȡ������ҳ��Դ�ļ���ͬ
		Thread.sleep(8000);
	
		System.setOut(ps1);
		System.out.println(driver.getPageSource());
		WebElement e = driver.findElement(By.partialLinkText("˵˵��ʹ�������ĸ���"));
		System.out.println(e.getLocation());
		System.out.println(e.isDisplayed());
		// �ƶ���ҳ��Ԫ�أ���ʱ��λʧ��
		new Actions(driver).moveToElement(e).perform();
		
		System.setOut(ps2);
		System.out.println(driver.getPageSource());
		WebElement k = driver.findElement(By.partialLinkText("˵˵��ʹ�������ĸ���"));
		System.out.println(k.getLocation());
		// �ƶ�����ͬ��ҳ��Ԫ�أ���ʱ��λ��ȷ
		new Actions(driver).moveToElement(k).perform();
	}
	
}
