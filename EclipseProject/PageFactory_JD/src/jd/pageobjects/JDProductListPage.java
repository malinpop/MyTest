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
			System.out.println("PageObjectȡ�õĲ�Ʒ�б�����Ϊ��"+listProduct.size());
			// ����ҵ�һ����Ʒ����λ�ڸò�Ʒ���������������� - ����ò�Ʒ��ϸ��Ϣҳ����
			WebElement selProduct = JDBasePage.getRandomFromList(listProduct);
			System.out.println("ѡ����Ĳ�ƷΪ��" + selProduct.getText());	

				// �жϸò�Ʒ�Ƿ��С����빺�ﳵ�����ӣ�û�����п�����ȱ������Ԥ����Ʒ��Ҫ����ѡ��
				String isCartPath = "parent::a/parent::div/parent::div/div[@class='p-operate']/a[contains(@class,'addcart')]";
				WebElement isCart = selProduct.findElement(By.xpath(isCartPath));
				String theText = isCart.getText();
				System.out.println("�Ƿ���Լ��빺�ﳵ��" +theText );
				if ("���빺�ﳵ".equals(theText)){
					// ��λ���ò�ƷͼƬ��ʾ���� - ���ڹ�����ʾ��ͼƬλ����
					String selPicPath = "parent::a/parent::div/parent::div/div[@class='p-img']";
					WebElement selPicture = selProduct.findElement(By.xpath(selPicPath));
					if (selProduct.isDisplayed() && selProduct.isEnabled()){
						new Actions(driver).moveToElement(selPicture).perform();
						Thread.sleep(5000);
						selProduct.click();
					} else
						throw new Exception("�޷���λ�������ѡ��Ĳ�Ʒ");
					break;	
				}else
					continue;
		}
	}

}
