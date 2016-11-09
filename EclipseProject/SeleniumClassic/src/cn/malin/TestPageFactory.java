package cn.malin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

class BaiDuPageFactory{
	@FindBy(id="kw")
	public WebElement keyWords;
	@FindBy(id="su")
	public WebElement searchButton;
	
	public BaiDuPageFactory(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
}

public class TestPageFactory {
	public static void main(String args[]){
		WebDriver driver = new FirefoxDriver();
		String url = "http://www.baidu.com/";
		driver.get(url);
		
		BaiDuPageFactory bdpf = new BaiDuPageFactory(driver);
		bdpf.keyWords.clear();
		bdpf.keyWords.sendKeys("AK47");
		bdpf.searchButton.click();		
	}
}
