package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_03_Xpath_css {
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
	public void TC_01_Empty_Data() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtFirstname-error']")).getText(),"Vui lòng nhập họ tên");
		Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtEmail-error']")).getText(),"Vui lòng nhập email");
		Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCEmail-error']")).getText(),"Vui lòng nhập lại địa chỉ email");
		Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtPassword-error']")).getText(),"Vui lòng nhập mật khẩu");
		Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCPassword-error']")).getText(),"Vui lòng nhập lại mật khẩu");
		Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtPhone-error']")).getText(),"Vui lòng nhập số điện thoại.");
	}

	@Test
	public void TC_02_Invalid_Email() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		driver.findElement(By.xpath("//input[@id='txtFirstname']")).sendKeys("huyentran");
		driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("huyentran");
		driver.findElement(By.xpath("//input[@id='txtCEmail']")).sendKeys("huyentran");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("012345678");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtEmail-error']")).getText(),"Vui lòng nhập email hợp lệ");
		Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCEmail-error']")).getText(),"Vui lòng nhập email hợp lệ");
	}

	@Test
	public void TC_03_Incorrect_Email() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		driver.findElement(By.xpath("//input[@id='txtFirstname']")).sendKeys("huyentran");
		driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("htran1904@gmail.com");
		driver.findElement(By.xpath("//input[@id='txtCEmail']")).sendKeys("huyentran");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("0123456789");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtEmail-error']")).getText(),"Vui lòng nhập email hợp lệ");
		Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCEmail-error']")).getText(),"Email nhập lại không đúng");
	}
	
	@Test
	public void TC_04_Invalid_Password() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		driver.findElement(By.xpath("//input[@id='txtFirstname']")).sendKeys("huyentran");
		driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("htran1904@gmail.com");
		driver.findElement(By.xpath("//input[@id='txtCEmail']")).sendKeys("htran1904@gmail.com");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("123");
		driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("123");
		driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("0123456789");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtPassword-error']")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");
		Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCPassword-error']")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");
	}
	@Test
	public void TC_05_Incorrect_Password() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		driver.findElement(By.xpath("//input[@id='txtFirstname']")).sendKeys("huyentran");
		driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("htran1904@gmail.com");
		driver.findElement(By.xpath("//input[@id='txtCEmail']")).sendKeys("htran1904@gmail.com");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("1234567");
		driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("0123456789");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtPassword-error']")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");
		Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCPassword-error']")).getText(),"Mật khẩu bạn nhập không khớp");
	}
	@Test
	public void TC_06_Invalid_Phone() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		//Action 1
		driver.findElement(By.xpath("//input[@id='txtFirstname']")).sendKeys("huyentran");
		driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("asdf1904@gmail.com");
		driver.findElement(By.xpath("//input[@id='txtCEmail']")).sendKeys("asdf1904@gmail.com");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("012345678");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtPhone-error']")).getText(),"Số điện thoại phải từ 10-11 số.");
		
		//Action 2
		driver.findElement(By.xpath("//input[@id='txtPhone']")).clear();
		driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("0123456789012");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtPhone-error']")).getText(),"Số điện thoại phải từ 10-11 số.");
		
		//Action 3
		driver.findElement(By.xpath("//input[@id='txtPhone']")).clear();
		driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("01124455667");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtPhone-error']")).getText(),"Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019 - 088 - 03 - 05 - 07 - 08");
		}
	
	
	
	
	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
}