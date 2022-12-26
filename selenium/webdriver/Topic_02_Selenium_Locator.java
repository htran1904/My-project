package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Selenium_Locator {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	@BeforeClass
	public void beforeClass() {
		System.out.println(projectPath);
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browerDriver\\geckodriver.exe");
		//D:\automation\Selenium WebDriver\browerDriver
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void TC_01_ID() {
		//mở trang Register
		driver.get("https://github.com/");
		//thao tác lên Element = cách find id và action lên nó = cách sendKey
		driver.findElement(By.id("user_email")).sendKeys("htran190@gmail.com");
		driver.findElement(By.id("user_email")).submit();
	}

	@Test
	public void TC_02_Class() {
		//trỏ về màn hình ban đầu 
		driver.navigate().back();
		driver.findElement(By.cssSelector("input[name='q']")).sendKeys("abs");
		driver.findElement(By.className("form-control")).submit();
	}

	@Test
	public void TC_03_TagName() {
		System.out.println(driver.findElements(By.tagName("button")).size());
	}
	
	@Test
	public void TC_04_LinkText() {
		driver.findElement(By.linkText("Training")).click();
	}
	@Test
	public void TC_05_PartialLinkText() {
		driver.findElement(By.partialLinkText("ReadME Project")).click();
		driver.navigate().back();
	}
	@Test
	public void TC_06_css() {
		//trở về màn hình ban đầu
		driver.get("https://www.nopcommerce.com/vi/register?returnUrl=%2Fvi");
		driver.findElement(By.cssSelector("input[id='FirstName']")).sendKeys("huyen");
		driver.findElement(By.cssSelector("input[name='LastName']")).sendKeys("tran");
	
	}
	@Test
	public void TC_07_LinkText() {
		driver.findElement(By.xpath("//input[@data-val-required='Yêu cầu email.']")).sendKeys("htran@gmail.com");
		driver.findElement(By.xpath("//input[@name='ConfirmEmail']")).sendKeys("htran@gmail.com");
	}
	@Test
	public void TC_08_Namet() {
		driver.findElement(By.name("Username")).sendKeys("huyentran");
	}
}