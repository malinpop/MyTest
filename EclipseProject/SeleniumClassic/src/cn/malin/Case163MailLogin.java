package cn.malin;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Case163MailLogin {
	
	public static WebElement byUntil(WebDriver driver,By by){
	    WebDriverWait wait = new WebDriverWait(driver,15);
	    return wait.until( new ExpectedCondition<WebElement>(){
		@Override
		public WebElement apply(WebDriver driver) {
			return driver.findElement(by);
			}
	    });
	}

	public static void main(String[] args) throws Exception{
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.baidu.com/");
		
		driver.findElement(By.id("kw")).click();
	    driver.findElement(By.id("kw")).clear();
	    driver.findElement(By.id("kw")).sendKeys("163邮箱");
	    byUntil(driver,By.id("su")).click();
	    
	    Thread.sleep(1000);
	    
	    byUntil(driver,By.xpath("//input[@id='op_email3_username']")).sendKeys("ma_linpop@163.com");
	    driver.findElement(By.xpath("//input[@class='op_email3_password']")).sendKeys("Esther&Jonah");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//td[@style='vertical-align:top;padding-left:0;']"))
	          .findElement(By.linkText("登录")).click();
	    
		Thread.sleep(1000);
		
	    Set <String> setWinHandlesDriver = driver.getWindowHandles();
	    System.out.println("当前窗口句柄数量： "+ setWinHandlesDriver.size());
	    String[] strWinhandlesDriver = new String[setWinHandlesDriver.size()];
	    setWinHandlesDriver.toArray(strWinhandlesDriver);
	    driver.switchTo().window(strWinhandlesDriver[1]);
	    // 点击发送按钮时要从正文iframe返回
	    String old = driver.getWindowHandle();

	    driver.findElement(By.xpath("//span[@title='收件箱']")).click();
	    Thread.sleep(1000);
	    
	    // 点击“写信”
	    driver.findElement(By.xpath("//li[contains(@class,'ra0 mD0')]")).click();
	    Thread.sleep(1000);
	    
	    byUntil(driver,By.xpath("//input[@class='nui-editableAddr-ipt']")).sendKeys("malin@lamco.com.cn");
	    driver.findElement(By.xpath("//input[@class='nui-ipt-input' and @maxlength='256']")).sendKeys("Test");
    
	    Thread.sleep(1000);
	    
	    Actions act = new Actions(driver);
	    act.sendKeys(Keys.TAB).perform();
	    driver.switchTo().activeElement().sendKeys("ABCDEFG");
	    
	    Thread.sleep(1000);
	    
	    driver.switchTo().window(old);
	    driver.findElement(By.xpath("//div[contains(@id,'_mail_button') and @tabindex='2']")).click();	
	    
	    Thread.sleep(1000);
	    
	    driver.findElement(By.linkText("退出")).click();
	    Thread.sleep(3000);
	    driver.quit();
	    
//	    String strScript = " iframes = document.getElementsByTagName('iframe');"
//	    		+ " for(i=0;i<iframes.length;i++){"
//	    		+ " if (iframes[i].getAttribute('class').indexOf('APP-editor-iframe')!=-1"
//	    		+ "    && iframes[i].getAttribute('style').indexOf('position:absolute')!=-1){"
//	    		+ "  window.ind = i;"
//	    		+ "  break;"
//	    		+ " }}";
//	    System.out.println("==================" + strScript);
//	    ((JavascriptExecutor)driver).executeScript(strScript);
//	    long index = (long) ((JavascriptExecutor)driver).executeScript("return window.ind");
//	    System.out.println("==================" + index);
//	    

	}
}
