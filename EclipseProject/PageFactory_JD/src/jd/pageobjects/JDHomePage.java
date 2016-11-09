package jd.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JDHomePage{

	private WebDriver driver;
	
	public WebDriver getDriver() {
		return driver;
	}

	@FindBy(id = "key")
	private WebElement searchBox;
	
	@FindBy(xpath = "//button[@class='button' and contains(@onclick,'false')]")
	private WebElement searchBtn;
	
	public JDHomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		if( !searchBox.isDisplayed() && searchBox.isEnabled())
			throw  new IllegalStateException("��ǰҳ�治�Ǿ�����ҳ");
	}
	
	
	public void searchProduct() throws Exception {
		
			if (searchBox.isEnabled() && searchBox.isDisplayed()){
				try{
					driver.manage().timeouts().pageLoadTimeout(8, TimeUnit.SECONDS);
					searchBox.sendKeys("huawei");
					searchBtn.click();
				} catch(TimeoutException e){
					System.out.println("����5���ӣ�����ҳ����ر�ֹͣ");
					JavascriptExecutor js = (JavascriptExecutor)driver;
					js.executeScript("document.execCommand('stop');");
			    }	
			}else
				throw new Exception("û���ҵ�������ť");
	}
	
	
	

}
