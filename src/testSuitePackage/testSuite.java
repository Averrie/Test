package testSuitePackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testSuite {
	
	protected WebDriver driver;
	
	@BeforeTest
	public void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
		driver = new ChromeDriver();
		String baseUrl = "http://www.wolframcloud.com";
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test(priority = 0, description = "Launches the wolframcloud website")
	public void launchSite() {
  		Assert.assertEquals(driver.getTitle(), "Wolfram Cloud");
	}
	
	@Test(priority = 1, description = "Click Wolfram Development Platform")
	public void wolframDevelopmentPlatform() {
		driver.get("http://www.wolframcloud.com/app/productsPage");
		driver.findElement(By.id("wdp-tile")).click();
		Assert.assertEquals(driver.getTitle(), "Sign In - Wolfram Development Platform");
	}
	
	@Test(priority = 2, description = "create a new Wolfram ID")
	public void createAccount() {
		driver.findElement(By.id("createAccount")).click();
		try {
			driver.findElement(By.id("firstname"));
		} catch (NoSuchElementException e) {
			// the page isn't rendered correctly
		}
		double randomEmail = Math.random()*100000;
		driver.findElement(By.id("email")).sendKeys(randomEmail + "@gmail.com");
		driver.findElement(By.id("firstname")).sendKeys("Xingrui");
		driver.findElement(By.id("lastname")).sendKeys("Huang");
		driver.findElement(By.id("password")).sendKeys("WolframAlpha");
		driver.findElement(By.id("password2")).sendKeys("WolframAlpha");
		driver.findElement(By.id("signIn")).click();

		WebElement newNotebookBtn = (new WebDriverWait(driver, 20))
		  .until(ExpectedConditions.presenceOfElementLocated(By.id("newNotebookBtn")));
		
		Assert.assertEquals(driver.getTitle(), "Home - Wolfram Development Platform");
	}
	
	@Test(priority = 3, description = "click the down-arrow button next to new button")
	public void dropDownMenu() {
		List dropDownItems = driver.findElements(By.className("nfItem"));
		Assert.assertEquals(dropDownItems.size(), 9);
	}
	
	@Test(priority = 4, description = "Create a .nb notebook")
	public void createNotebook() {
		driver.findElement(By.id("newNotebookBtn")).click();
		
		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); 
		}
		
		Assert.assertEquals(driver.getTitle(), "(unnamed) - Wolfram Development Platform");
	}
	
	@Test(priority = 5, description = "Assert file extension")
	public void assertFileExtension() {
		driver.findElement(By.id("renameButton")).click();
		Assert.assertEquals(driver.findElement(By.id("toolbarRenameInputField")).getAttribute("value"), ".nb");
	}
	
	@AfterTest
	public void shutDown() {
	    driver.quit();
	}
}
