package cn.malin;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSwitchToNewHandleByTitle {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.baidu.com/");
		
		driver.findElement(By.linkText("���ڰٶ�")).click();
		driver.findElement(By.linkText("�ٶȽ���")).click();
		driver.findElement(By.linkText("�ٶ�֮·")).click();
		driver.findElement(By.linkText("�ٶ�logo")).click();
		
		String mainWindowHandle = driver.getWindowHandle();
		Set <String> allWindowHandles = driver.getWindowHandles();
		for(String theWindowHandle: allWindowHandles){
			if (theWindowHandle.equals(mainWindowHandle))
				continue;
		//	if 
		}

	}

}
