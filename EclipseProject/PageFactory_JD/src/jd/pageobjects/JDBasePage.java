package jd.pageobjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JDBasePage {

	private WebDriver driver;
	private String url = "http://www.jd.com/";

	public WebDriver getDriver() {
		return driver;
	}

	public JDBasePage(){
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	public void openHomePage(){
		try {
			driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
			driver.get(url);
			
		} catch (TimeoutException e) {
			System.out.println("超出5秒钟，首页加载被终止");
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("document.execCommand('stop');");
		} 
	}


	public void quitJD(){
		driver.quit(); 
	}
	
	// 获取最后打开的窗口句柄
	public static String getLastHandle(WebDriver driver){
		Object[] obj = driver.getWindowHandles().toArray();
		int x  = obj.length;
		return obj[x-1].toString();
	}
	
	// 从列表中获取随机项
	public static WebElement getRandomFromList(List<WebElement> list){
		int size = list.size();
		int random = (int)(Math.random() * size);
		
		System.out.println("查询获得产品总数:  "+ size);
		System.out.println("产品对应随机数字:  " + random);
		
		return list.get(random);
	}
	
	// 鼠标悬停
	public static void mouseHover(WebDriver driver, WebElement e) throws InterruptedException{
		Actions act = new Actions(driver);
		
		// 窗口滚动到随机选择的商品处
		/* 如果商品位置超出当前屏幕显示位置，只能先通过JS方式滚动到该商品处，
		 * 再用 WebDriver 提供的 moveToElement 方法进行鼠标悬停
		 */
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true);", e);
		Thread.sleep(3000);
		
		try{
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(new ExpectedCondition<Boolean>(){
				@Override
				public Boolean apply(WebDriver arg0) {
					// TODO Auto-generated method stub
					return (e.isDisplayed() && e.isEnabled());
				}
			});
			// 鼠标悬停到该商品处
			act.moveToElement(e).perform();
		}catch(Exception x){
			System.out.println("没有定位到该产品！");
		}
	}
	
	
	// 高亮显示
	public static void highlightElement(WebDriver driver,WebElement e){
		String that =   "element=arguments[0];"
				      + "oldStyle=element.getAttribute('style');"
			          + "element.setAttribute('style', oldStyle + ';background:blue;border:2px solid yellow;');"
                      + "//setTimeout(function(){element.setAttribute('style',oldStyle)},1000);";
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript(that,e);
	}
}
