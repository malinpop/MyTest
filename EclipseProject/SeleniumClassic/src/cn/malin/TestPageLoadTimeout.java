package cn.malin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.os.WindowsUtils;

public class TestPageLoadTimeout {

	public static void main(String[] args){
		WebDriver driver = new FirefoxDriver();
		
		try {
			// �˴����ó�ʱ�ɹ�
			driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.SECONDS);
			driver.get("http://www.163.com");
		} catch (Exception e) {
			System.out.println("163 Catch TimeOut !!");
		} finally {
			try{
				// �˴����ó�ʱʧ�ܣ��Ծɰ�1�����жϳ�ʱ
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




