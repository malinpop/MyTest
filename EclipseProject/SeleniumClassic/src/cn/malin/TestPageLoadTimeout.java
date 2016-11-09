package cn.malin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.os.WindowsUtils;

public class TestPageLoadTimeout {

	public static void main(String[] args){
		WebDriver driver = new FirefoxDriver();
		
		try {
			// 此处设置超时成功
			driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.SECONDS);
			driver.get("http://www.163.com");
		} catch (Exception e) {
			System.out.println("163 Catch TimeOut !!");
		} finally {
			try{
				// 此处设置超时失败，仍旧按1秒中判断超时
				driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
				driver.get("http://www.sohu.com");
			} catch (Exception e){
				System.out.println("sohu Catch TimeOut !!");
			} finally{
				WindowsUtils.tryToKillByName("firefox.exe");
			}
		}
	}
}




