package cn.malin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSwitchToNewHandleByArray {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.baidu.com/");
		System.out.println(driver.getWindowHandle());
		
		driver.findElement(By.linkText("���ڰٶ�")).click();
		System.out.println(driver.getWindowHandle());
		
		driver.findElement(By.linkText("�ٶȽ���")).click();
		System.out.println(driver.getWindowHandle());
		
		driver.findElement(By.linkText("�ٶ�֮·")).click();
		
		// ����һ���µĴ���
		driver.findElement(By.linkText("�ٶ�logo")).click();
		// ����һ�����ַ�����
		String handles[] = new String[driver.getWindowHandles().size()];
		
		// ��ȡ��ǰDriver��FirefoxDriver�������еĴ��ھ��
		// ��ǰһ�����������ڣ�һ���ǹ��ڰٶȣ�һ�����´򿪵İٶ�logo 
		driver.getWindowHandles().toArray(handles);
		
		//Thread.sleep(5000);
		
		// �����ôд���Ὣ��һ�����ڴ򿪵��ٶ�logo�������Ƕ�λ���ڶ�������
		//driver.get("http://logo.baidu.com/");
		
		// ��driverָ�����´򿪵Ĵ���
		driver.switchTo().window(handles[1]);
		
		driver.findElement(By.linkText("����")).click();
		System.out.println(driver.getWindowHandle());
	}
}
