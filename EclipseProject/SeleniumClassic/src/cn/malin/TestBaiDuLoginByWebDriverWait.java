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
	    
	    // 点击“登录”超级链接
	    driver.findElement(By.linkText("登录")).click();
	    // 定位到弹出登录的div窗口
	    driver.switchTo().defaultContent();
	    
	    // 设置等待时间
	    WebDriverWait wait = new WebDriverWait(driver,10);
	    
	    // 直到得到定位元素
	    WebElement username = (WebElement)wait.until(
	    	new com.google.common.base.Function<WebDriver,WebElement>(){
	        	@Override
	    	    public WebElement apply(WebDriver driver){
	    		    return driver.findElement(By.id("TANGRAM__PSP_8__userName"));
	    	}
	    });
	    
	    // 输入用户名
	    username.clear();
	    username.sendKeys("ma_linpop@163.com");

	    // 输入密码
	    driver.findElement(By.id("TANGRAM__PSP_8__password")).sendKeys(PD);
	    driver.findElement(By.id("TANGRAM__PSP_8__submit")).click();

	   // 点击提交
	   driver.findElement(By.id("TANGRAM__PSP_8__submit")).click();
	   
	   //driver.quit();

	}

}
