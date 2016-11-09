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
		// 切换到当前窗口内的iFrame
		act.sendKeys(Keys.TAB).perform();
		// 切换到iFrame中的编辑框
		act.sendKeys(Keys.TAB).perform();
		// 找到相对于父窗口的元素
		WebElement c = driver.switchTo().activeElement();
		// 根据该元素将driver切换进iFrame
		driver.switchTo().frame(c);
		// 从iFrame中定位要键入的元素
		WebElement c1= driver.findElement(By.id("iEditInFrame1"));
		// 高亮显示
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
		// 此处必须使用C，不能使用C1
		// C当时是相对于Main窗口定位的，上面窗口句柄定位到了Main窗口
		// C1是窗口句柄切换到iFrame后定位的元素，相对于Frame的定位
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










