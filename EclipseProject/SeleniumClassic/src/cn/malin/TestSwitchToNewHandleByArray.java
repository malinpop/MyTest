package cn.malin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSwitchToNewHandleByArray {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.baidu.com/");
		System.out.println(driver.getWindowHandle());
		
		driver.findElement(By.linkText("关于百度")).click();
		System.out.println(driver.getWindowHandle());
		
		driver.findElement(By.linkText("百度介绍")).click();
		System.out.println(driver.getWindowHandle());
		
		driver.findElement(By.linkText("百度之路")).click();
		
		// 弹出一个新的窗口
		driver.findElement(By.linkText("百度logo")).click();
		// 定义一个空字符数组
		String handles[] = new String[driver.getWindowHandles().size()];
		
		// 获取当前Driver（FirefoxDriver）打开所有的窗口句柄
		// 当前一共有两个窗口，一个是关于百度，一个是新打开的百度logo 
		driver.getWindowHandles().toArray(handles);
		
		//Thread.sleep(5000);
		
		// 如果这么写，会将第一个窗口打开到百度logo，而不是定位到第二个窗口
		//driver.get("http://logo.baidu.com/");
		
		// 将driver指定到新打开的窗口
		driver.switchTo().window(handles[1]);
		
		driver.findElement(By.linkText("介绍")).click();
		System.out.println(driver.getWindowHandle());
	}
}
