package jd.pageobjects;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JDProductDetailPage {
	
	private WebDriver driver;
	
	@FindBy(linkText="加入购物车")
	private WebElement btAddToCart;
	
	public JDProductDetailPage(WebDriver driver){
		this.driver = driver;
		
		// 奇怪，不加这句话driver不会保存新打开的窗口句柄，而只保留了列表页面的一个窗口句柄
		// 加上这句话后driver中会保存两个窗口句柄，再指向最新的创建句柄才可
		driver.getWindowHandle();
		
		driver.switchTo().window(JDBasePage.getLastHandle(driver));
		driver.manage().window().maximize();
		System.out.println(driver.getWindowHandle());

		System.out.println("当前商品页面："+ driver.getCurrentUrl());
		PageFactory.initElements(driver, this);
	}

	
	public void addToCart() throws Exception{
		driver.manage().window().maximize();
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,70)");
		
		Thread.sleep(2000);
		
		if (btAddToCart.isDisplayed() && btAddToCart.isEnabled()){
			btAddToCart.click();
		} else
			throw new Exception("无法点击产品");
	}
	


	public WebDriver getDriver() {
		return driver;
	}

}
