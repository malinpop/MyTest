package cn.malin;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CaseiFrameSwitchByTab {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://localhost/testweb/MainWin.html");
		Actions act = new Actions(driver);
		
		WebElement a = driver.findElement(By.id("iEditInMain1"));
		highlightElement(driver,a);
		Thread.sleep(1000);
		a.sendKeys("AAAA");
		
		driver.switchTo().activeElement();
		act.sendKeys(Keys.TAB).perform();
		WebElement b = driver.switchTo().activeElement();
		highlightElement(driver, b);
		Thread.sleep(1000);
		b.sendKeys("BBBB");
		
		Thread.sleep(1000);
		// �л�����ǰ�����ڵ�iFrame
		act.sendKeys(Keys.TAB).perform();
		// �л���iFrame�еı༭��
		act.sendKeys(Keys.TAB).perform();
		// �ҵ�����ڸ����ڵ�Ԫ��
		WebElement c = driver.switchTo().activeElement();
		// ���ݸ�Ԫ�ؽ�driver�л���iFrame
		driver.switchTo().frame(c);
		// ��iFrame�ж�λҪ�����Ԫ��
		WebElement c1= driver.findElement(By.id("iEditInFrame1"));
		// ������ʾ
		highlightElement(driver,c1);
		c1.sendKeys("CCCCCC");
		
		
		driver.switchTo().parentFrame();
		Thread.sleep(1000);
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys(Keys.TAB).perform();
		WebElement d = driver.switchTo().activeElement();
		driver.switchTo().frame(d);
		WebElement d1 = driver.findElement(By.id("iEditInFrame2"));
		highlightElement(driver, d1);
		d1.sendKeys("DDDDD");
		
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys(Keys.TAB).perform();
		WebElement e = driver.switchTo().activeElement();
		driver.switchTo().frame(e);
		WebElement e1 = driver.findElement(By.id("iEditInFrame21"));
		highlightElement(driver, e1);
		e1.sendKeys("EEEEE");
		
		driver.switchTo().parentFrame().switchTo().parentFrame();
		Thread.sleep(1000);
		// �˴�����ʹ��C������ʹ��C1
		// C��ʱ�������Main���ڶ�λ�ģ����洰�ھ����λ����Main����
		// C1�Ǵ��ھ���л���iFrame��λ��Ԫ�أ������Frame�Ķ�λ
		driver.switchTo().frame(c);
		driver.findElement(By.id("iEditInFrame1")).sendKeys("999999");
		
		//driver.quit();
	}
	

	public static void highlightElement(WebDriver driver,WebElement e){
		String that =   "element=arguments[0];"
				      + "oldStyle=element.getAttribute('style');"
			          + "element.setAttribute('style', oldStyle + ';background:blue;border:2px solid yellow;');"
                      + "setTimeout(function(){element.setAttribute('style',oldStyle)},1000);";
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript(that,e);
	}

}










