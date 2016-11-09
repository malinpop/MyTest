package jd.pageobjects;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JDProductDetailPage {
	
	private WebDriver driver;
	
	@FindBy(linkText="���빺�ﳵ")
	private WebElement btAddToCart;
	
	public JDProductDetailPage(WebDriver driver){
		this.driver = driver;
		
		// ��֣�������仰driver���ᱣ���´򿪵Ĵ��ھ������ֻ�������б�ҳ���һ�����ھ��
		// ������仰��driver�лᱣ���������ھ������ָ�����µĴ�������ſ�
		driver.getWindowHandle();
		
		driver.switchTo().window(JDBasePage.getLastHandle(driver));
		driver.manage().window().maximize();
		System.out.println(driver.getWindowHandle());

		System.out.println("��ǰ��Ʒҳ�棺"+ driver.getCurrentUrl());
		PageFactory.initElements(driver, this);
	}

	
	public void addToCart() throws Exception{
		driver.manage().window().maximize();
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,70)");
		
		Thread.sleep(2000);
		
		if (btAddToCart.isDisplayed() && btAddToCart.isEnabled()){
			btAddToCart.click();
		} else
			throw new Exception("�޷������Ʒ");
	}
	


	public WebDriver getDriver() {
		return driver;
	}

}
