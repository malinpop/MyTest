package jd.pageobjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JDProductListPage {
	
	private WebDriver driver;
	
	public WebDriver getDriver() {
		return driver;
	}

	@FindBy(xpath="//div[@id='J_goodsList']/ul/li/div/div/a/em")
	private List<WebElement> listProduct;
	
	public JDProductListPage(WebDriver driver){
		this.driver = driver;
		driver.manage().window().maximize();
		PageFactory.initElements(driver,this);
	}
	
	public void clickOneProduct() throws Exception{
		
		while(true){
			System.out.println("PageObject取得的产品列表数量为："+listProduct.size());
			// 随机找到一个产品，定位于该产品文字描述超链部分 - 进入该产品详细信息页面用
			WebElement selProduct = JDBasePage.getRandomFromList(listProduct);
			System.out.println("选择购买的产品为：" + selProduct.getText());	

				// 判断该产品是否有“加入购物车”链接，没有则有可能是缺货或者预订商品，要重新选择
				String isCartPath = "parent::a/parent::div/parent::div/div[@class='p-operate']/a[contains(@class,'addcart')]";
				WebElement isCart = selProduct.findElement(By.xpath(isCartPath));
				String theText = isCart.getText();
				System.out.println("是否可以加入购物车：" +theText );
				if ("加入购物车".equals(theText)){
					// 定位到该产品图片显示部分 - 窗口滚动显示到图片位置用
					String selPicPath = "parent::a/parent::div/parent::div/div[@class='p-img']";
					WebElement selPicture = selProduct.findElement(By.xpath(selPicPath));
					if (selProduct.isDisplayed() && selProduct.isEnabled()){
						new Actions(driver).moveToElement(selPicture).perform();
						Thread.sleep(5000);
						selProduct.click();
					} else
						throw new Exception("无法定位到被随机选择的产品");
					break;	
				}else
					continue;
		}
	}

}
