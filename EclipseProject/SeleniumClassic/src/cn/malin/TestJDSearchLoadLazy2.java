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
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		
		System.out.println(df.format(new Date()));
		driver.get("http://search.jd.com/Search?keyword=huawei");
		System.out.println(df.format(new Date()));
		
		// 加上等待时间，获取的两个页面源文件相同
		Thread.sleep(8000);
	
		System.setOut(ps1);
		System.out.println(driver.getPageSource());
		WebElement e = driver.findElement(By.partialLinkText("说说我使用搜索的感受"));
		System.out.println(e.getLocation());
		System.out.println(e.isDisplayed());
		// 移动到页面元素，此时定位失败
		new Actions(driver).moveToElement(e).perform();
		
		System.setOut(ps2);
		System.out.println(driver.getPageSource());
		WebElement k = driver.findElement(By.partialLinkText("说说我使用搜索的感受"));
		System.out.println(k.getLocation());
		// 移动到相同的页面元素，此时定位正确
		new Actions(driver).moveToElement(k).perform();
	}
	
}
