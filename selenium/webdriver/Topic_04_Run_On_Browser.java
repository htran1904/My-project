package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_04_Run_On_Browser {
	WebDriver driver;
	//projectPath: biến sd hàm getProperty gọi đường dẫn 
	String projectPath = System.getProperty("user.dir");
	
	@BeforeClass
	public void beforeClass() {
		System.out.println(projectPath);
	}

	@Test
	public void TC_01_FirefoxDriver() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browerDriver\\geckodriver.exe");
		//D:\automation\Selenium WebDriver\browerDriver
		//thư viện: FirefoxDriver
		driver = new FirefoxDriver();
		
		driver.get("https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/");
		driver.quit();
	}
	
	@Test
	public void TC_02_ChromeDriver() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browerDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/");
		driver.quit();
	}
	

	@Test
	public void TC_03_EdgeDriver() {
		
		System.setProperty("webdriver.edge.driver", projectPath + "\\browerDriver\\msedgedriver.exe");
		driver = new EdgeDriver();
		
		driver.get("https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/");
		driver.quit();
	}

	
}