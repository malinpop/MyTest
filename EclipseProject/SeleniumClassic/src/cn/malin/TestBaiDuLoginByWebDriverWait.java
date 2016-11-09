package cn.malin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestBaiDuLoginByWebDriverWait {

	private static final String PD="Esther&Jonah";
	
	public static void main(String[] args) {
	    
	    WebDriver driver = new FirefoxDriver();
	    String baseUrl = "http://www.baidu.com/";
	    driver.get(baseUrl);
	    
	    // �������¼����������
	    driver.findElement(By.linkText("��¼")).click();
	    // ��λ��������¼��div����
	    driver.switchTo().defaultContent();
	    
	    // ���õȴ�ʱ��
	    WebDriverWait wait = new WebDriverWait(driver,10);
	    
	    // ֱ���õ���λԪ��
	    WebElement username = (WebElement)wait.until(
	    	new com.google.common.base.Function<WebDriver,WebElement>(){
	        	@Override
	    	    public WebElement apply(WebDriver driver){
	    		    return driver.findElement(By.id("TANGRAM__PSP_8__userName"));
	    	}
	    });
	    
	    // �����û���
	    username.clear();
	    username.sendKeys("ma_linpop@163.com");

	    // ��������
	    driver.findElement(By.id("TANGRAM__PSP_8__password")).sendKeys(PD);
	    driver.findElement(By.id("TANGRAM__PSP_8__submit")).click();

	   // ����ύ
	   driver.findElement(By.id("TANGRAM__PSP_8__submit")).click();
	   
	   //driver.quit();

	}

}
