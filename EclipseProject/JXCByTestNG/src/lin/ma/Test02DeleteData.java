package lin.ma;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class Test02DeleteData {
  WebDriver driver;
  String MainHandle;
  
  @BeforeMethod
  public void beforeMethod() {
	  driver = new FirefoxDriver();
	  driver.get("http://localhost/jxc/index.asp");
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

  public void login(){
	  driver.findElement(By.name("username")).sendKeys("admin");
	  driver.findElement(By.name("pwd")).sendKeys("admin");
	  driver.findElement(By.xpath("//input[@tabindex='5' and @name='enter']")).click();
	  MainHandle = driver.getWindowHandle();
  }
  
  public void toLeftMenu(String MenuName , String pageName){
	  String toMenuPath = "//img[@src='images/menu_" + MenuName + ".gif']";
	  String toPagePath = "//td[contains(@onclick,"  +"'"  +  pageName   +"')]";
	  
	  driver.switchTo().window(MainHandle);
	  driver.switchTo().frame("left");
	  driver.findElement(By.xpath(toMenuPath)).click();
	  driver.findElement(By.xpath(toPagePath)).click();
  }
  
  public void toRightMenu(){
	  driver.switchTo().window(MainHandle);
	  driver.switchTo().frame("right");
  }
  
  public void deleteAll() throws InterruptedException{
	  toRightMenu();
	  driver.findElement(By.id("chkall")).click();
	  driver.findElement(By.xpath("//input[@value='删 除']")).click();
	  Thread.sleep(500);
	  driver.switchTo().alert().accept();
  }
  
  public void delBuyRecords() throws InterruptedException{
	  toLeftMenu("a","buy.asp");
	  toRightMenu();
	  
	  // 判断查询按钮是否显示
	  WebDriverWait wait = new WebDriverWait(driver, 5);
	  wait.until( new ExpectedCondition<WebElement> (){
		@Override
		public WebElement apply(WebDriver arg0) {
			return driver.findElement(By.xpath("//input[@value=' 查询 '] "));
		}
	  });
	  
	  while (!driver.getPageSource().contains("没有找到记录")){
		  String jsScript = "var theDate = document.getElementsByName('startdate');" 
		        +  "theDate[0].setAttribute('value','2000/1/1');";
	      JavascriptExecutor js = (JavascriptExecutor) driver;
	      js.executeScript(jsScript);
		  driver.findElement(By.xpath("//input[@value=' 查询 ']")).click();
		  deleteAll();
		  Thread.sleep(2000);
	  }
  }
  
  public void delDanWei() throws InterruptedException{
	  toLeftMenu("f","danwei.asp");
	  deleteAll();
  }
  
  public void delBigClass() throws InterruptedException{
	  toLeftMenu("f","bigclass.asp");
	  deleteAll();
  }
  

  
  @Test
  public void DeleteData(){
	  login();
	  try {
		delBuyRecords();
		delDanWei();
		delBigClass();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	  
	  
  }
}
