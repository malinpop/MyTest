package cn.malin;


import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;


public class TestBaiDuLoginByFluentWait {
	private WebDriver driver;
    private String baseUrl;
    private final String PD="Esther&Jonah";


	  @Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://www.baidu.com/";
	    //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testA() throws Exception {
	    driver.get(baseUrl + "/");
	    driver.findElement(By.id("kw")).click();
	    driver.findElement(By.id("kw")).clear();
	    driver.findElement(By.id("kw")).sendKeys("ak47");
	    driver.findElement(By.id("su")).click();
	    
	    // �������¼����������
	    driver.findElement(By.linkText("��¼")).click();
	    // ��λ��������¼��div����
	    driver.switchTo().defaultContent();
	    
	    // ���õȴ�ʱ��
	    FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	    		.withTimeout(10, TimeUnit.MILLISECONDS)
	    		.pollingEvery(2, TimeUnit.MILLISECONDS)
	            .ignoring(NoSuchElementException.class);
	    
	    // ֱ���õ���λԪ��
	    WebElement username =   wait.until(
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
	    
	  }

	  @After
	  public void tearDown() throws Exception {
	    //driver.quit();
	  }

}
