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
			System.out.println("����5���ӣ���ҳ���ر���ֹ");
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("document.execCommand('stop');");
		} 
	}


	public void quitJD(){
		driver.quit(); 
	}
	
	// ��ȡ���򿪵Ĵ��ھ��
	public static String getLastHandle(WebDriver driver){
		Object[] obj = driver.getWindowHandles().toArray();
		int x  = obj.length;
		return obj[x-1].toString();
	}
	
	// ���б��л�ȡ�����
	public static WebElement getRandomFromList(List<WebElement> list){
		int size = list.size();
		int random = (int)(Math.random() * size);
		
		System.out.println("��ѯ��ò�Ʒ����:  "+ size);
		System.out.println("��Ʒ��Ӧ�������:  " + random);
		
		return list.get(random);
	}
	
	// �����ͣ
	public static void mouseHover(WebDriver driver, WebElement e) throws InterruptedException{
		Actions act = new Actions(driver);
		
		// ���ڹ��������ѡ�����Ʒ��
		/* �����Ʒλ�ó�����ǰ��Ļ��ʾλ�ã�ֻ����ͨ��JS��ʽ����������Ʒ����
		 * ���� WebDriver �ṩ�� moveToElement �������������ͣ
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
			// �����ͣ������Ʒ��
			act.moveToElement(e).perform();
		}catch(Exception x){
			System.out.println("û�ж�λ���ò�Ʒ��");
		}
	}
	
	
	// ������ʾ
	public static void highlightElement(WebDriver driver,WebElement e){
		String that =   "element=arguments[0];"
				      + "oldStyle=element.getAttribute('style');"
			          + "element.setAttribute('style', oldStyle + ';background:blue;border:2px solid yellow;');"
                      + "//setTimeout(function(){element.setAttribute('style',oldStyle)},1000);";
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript(that,e);
	}
}
