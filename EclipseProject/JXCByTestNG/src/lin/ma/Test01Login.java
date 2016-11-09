package lin.ma;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Test01Login {
  private WebDriver driver;
  
  @BeforeMethod
  public void beforeMethod() {
	  driver = new FirefoxDriver();
	  driver.get("http://localhost/jxc/index.asp");
	  
  }

  @AfterMethod
  public void afterMethod() {
	  Reporter.log("��ʼִ��afterMethod()");
	  driver.quit();
  }
  
  
  @Test(priority=20)
  public void validNameAndPwd() {
	  Reporter.log("��ʼִ�в��Է�����validNameAndPwd()");
	  //System.out.println("��ʼִ�в��Է�����validNameAndPwd()");
	  driver.findElement(By.name("username")).sendKeys("admin");
	  driver.findElement(By.name("pwd")).sendKeys("admin");
	  driver.findElement(By.xpath("//input[@tabindex='5' and @name='enter']")).click();
	  Assert.assertEquals(driver.getTitle(), "�춦���������ϵͳ - ��̨����ϵͳ");
  }
  
  @Test(priority=1)
  public void invalidName() {
	  Reporter.log("��ʼִ�в��Է�����invalidName()");
	  //System.out.println("��ʼִ�в��Է�����invalidName()");
	  driver.findElement(By.name("username")).sendKeys("adminaaa");
	  driver.findElement(By.name("pwd")).sendKeys("admin");
	  driver.findElement(By.xpath("//input[@tabindex='5' and @name='enter']")).click();
	  Assert.assertEquals(driver.switchTo().alert().getText(), "��¼���ƻ��������");
	  driver.switchTo().alert().accept();
  }
  
  @Test(priority=2)
  public void invalidPWD() {
	  Reporter.log("��ʼִ�в��Է�����invalidPWD()");
	  //System.out.println("��ʼִ�в��Է�����invalidName()");
	  driver.findElement(By.name("username")).sendKeys("admin");
	  driver.findElement(By.name("pwd")).sendKeys("admin111");
	  driver.findElement(By.xpath("//input[@tabindex='5' and @name='enter']")).click();
	  Assert.assertEquals(driver.switchTo().alert().getText(), "��¼���ƻ��������");
	  driver.switchTo().alert().accept();
  }
}
