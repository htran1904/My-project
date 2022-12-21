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
	//<input data-color-mode="light" data-light-theme="light" data-dark-theme="dark" class="form-control 
	//f4-mktg width-full rounded-md-right-0" style="height: 3rem" placeholder="Email address" type="email" 
	//name="user_email" id="user_email" autocomplete="off" spellcheck="false">
	@Test
	public void TC_01_ID() {
		//mở trang Register
		driver.get("https://github.com/");
		//thao tác lên Element = cách find id và action lên nó = cách sendKey
		driver.findElement(By.id("user_email")).sendKeys("htran190@gmail.com");
		driver.findElement(By.id("user_email")).submit();
		//driver.navigate().back();
		//driver.navigate().forward();
	//	driver.close()
		
	}

	@Test
	public void TC_02_Class() {
		//trỏ về màn hình ban đầu 
		//<svg height="32" aria-hidden="true" viewBox="0 0 16 16" version="1.1" width="32" data-view-component="true" class="octicon octicon-mark-github color-fg-on-emphasis">
	   // <path fill-rule="evenodd" d="M8 0C3.58 0 0 3.58 0 8c0 3.54 2.29 6.53 5.47 7.59.4.07.55-.17.55-.38 0-.19-.01-.82-.01-1.49-2.01.37-2.53-.49-2.69-.94-.09-.23-.48-.94-.82-1.13-.28-.15-.68-.52-.01-.53.63-.01 1.08.58 1.23.82.72 1.21 1.87.87 2.33.66.07-.52.28-.87.51-1.07-1.78-.2-3.64-.89-3.64-3.95 0-.87.31-1.59.82-2.15-.08-.2-.36-1.02.08-2.12 0 0 .67-.21 2.2.82.64-.18 1.32-.27 2-.27.68 0 1.36.09 2 .27 1.53-1.04 2.2-.82 2.2-.82.44 1.1.16 1.92.08 2.12.51.56.82 1.27.82 2.15 0 3.07-1.87 3.75-3.65 3.95.29.25.54.73.54 1.48 0 1.07-.01 1.93-.01 2.2 0 .21.15.46.55.38A8.013 8.013 0 0016 8c0-4.42-3.58-8-8-8z"></path>
	   // </svg>
	//	driver.get("https://github.com/");
		driver.navigate().back();
		
		//driver.findElement(By.xpath("//a[@aria-label='Homepage']")).click();
		//driver.findElement(By.className("form-control")).submit();
		//driver.get("https://github.com/");
		//<input type="text" class="form-control js-site-search-focus header-search-input jump-to-field js-jump-to-field" data-hotkey="s,/" name="q" 
		//data-test-selector="nav-search-input" placeholder="Search GitHub" data-unscoped-placeholder="Search GitHub" data-scoped-placeholder="Search" autocapitalize="off" role="combobox" aria-haspopup="listbox" aria-expanded="false" aria-autocomplete="list" aria-controls="jump-to-results" aria-label="Search GitHub" data-jump-to-suggestions-path="/_graphql/GetSuggestedNavigationDestinations" spellcheck="false" autocomplete="off">
	//	driver.findElement(By.className("form-control")).click();
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
		//driver.navigate().back();
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
		//driver.navigate().back();
	}
	@Test
	public void TC_07_LinkText() {
		driver.findElement(By.xpath("//input[@data-val-required='Yêu cầu email.']")).sendKeys("htran@gmail.com");
		driver.findElement(By.xpath("//input[@name='ConfirmEmail']")).sendKeys("htran@gmail.com");
		//driver.navigate().back();
	}
	@Test
	public void TC_08_Namet() {
		driver.findElement(By.name("Username")).sendKeys("huyentran");
	}
}