package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import dataFiles.DataFile;

public class SamplePage {
	
	// Rough work - trial code

			WebDriver driver;
		//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			DataFile dataTOmethod = new DataFile();
			Logger print = Logger.getLogger("devpinoyLogger");
			
			@FindBy(xpath = "//div[@class='desktop-header__container']//div[@class='desktop-header__actions']//div[@class='desktop-header__search']//form[@class='search js-test-activation-trigger']//div[@class='search__container']//input[@id='search-autocomplete']")
			public WebElement SearchBox;
			
			@FindBy(xpath = "//div[@class='desktop-header__container']//div[@class='desktop-header__actions']//div[@class='desktop-header__search']//form[@class='search js-test-activation-trigger']//div[@class='search__container']//button[@class='search__search-icon']")
			public WebElement SearchIcon;
			
			@FindBy(xpath= "//body/div[@id='__next']/div[@id='page-content']/div[@class='jsx-4102896525 kib-container products main-content plp-products kib-grid__item kib-grid__item--order-last@min-xl kib-grid__item--span-4@min-xs kib-grid__item--span-8@md kib-grid__item--span-9@lg kib-grid__item--span-10@xl']/div[@class='kib-container--full']/div[@class='kib-grid']/div[@class='ProductListingGrid_overlayWrapper__A5GZ8']/div[@class='ProductListingGrid_gridContainer__FNS4h js-tracked-product-list']/div[1]/div[1]")
			public WebElement Product;
			
			@FindBy(xpath= "//button[@class='_3BL1ltpM1IQogaoWgNunxf _2rqbHofZus5Vfq7z65ULJf kib-button-default kib-button-default--full kib-button-default--transactional']")
			public WebElement AddToCart;
			
			@FindBy(xpath= "//span[contains(text(),'Continue with Quantity of 1')]")
			public WebElement Quantity;
			
			@FindBy(xpath= "//span[contains(text(),'Proceed to Checkout')]")
			public WebElement CheckOut;
			
			@FindBy(id = "username")
			public WebElement Email;
			
			@FindBy(id= "password")
			public WebElement Password;
			
			@FindBy(xpath= "//input[@id='form-login--submit-button']")
			public WebElement SignIn;
			
			@FindBy(xpath= "//h5[@class='cw-notification__title']")
			public WebElement MissingactualError;
			
			@FindBy(xpath= "//h5[@class='cw-notification__title']")
			public WebElement GlobalactualError;
			
			public void openBrowser() throws IOException
			{	
				FileInputStream file = new FileInputStream("C:\\testing\\prop.properties");
				Properties propfile = new Properties();
				propfile.load(file);

				String browser = propfile.getProperty("browser");

				if(browser.equals("firefox"))
				{
					System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
					driver = new FirefoxDriver();
				} 
				else if (browser.equals("chrome"))
				{
					System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
					driver = new ChromeDriver();
				} 
				else
				{
					System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\Safaridriver.exe");
					driver = new SafariDriver();
				}
				PageFactory.initElements(driver, this); //driver calls and find the element
			}
			
			public void openWebsite()
			{
				driver.get("https://www.chewy.com");		
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
			}
			
			public void closeBrowser()
			{
				driver.close();	
			}
			
			public void SearchItem() throws InterruptedException
			{				
				//search in search box
				//driver.findElement(By.xpath("//div[@class='desktop-header__container']//div[@class='desktop-header__actions']//div[@class='desktop-header__search']//form[@class='search js-test-activation-trigger']//div[@class='search__container']//input[@id='search-autocomplete']")).sendKeys("Tylosin Tartrate Compounded");
				
				SearchBox.sendKeys("Tylosin Tartrate Compounded");
				
				//click on search icon 
				//driver.findElement(By.xpath("//div[@class='desktop-header__container']//div[@class='desktop-header__actions']//div[@class='desktop-header__search']//form[@class='search js-test-activation-trigger']//div[@class='search__container']//button[@class='search__search-icon']")).click();			
				SearchIcon.click();
			}
			
			public void SelectItem() throws InterruptedException
			{
				
				//click on product we need 
				//driver.findElement(By.xpath("//body/div[@id='__next']/div[@id='page-content']/div[@class='jsx-4102896525 kib-container products main-content plp-products kib-grid__item kib-grid__item--order-last@min-xl kib-grid__item--span-4@min-xs kib-grid__item--span-8@md kib-grid__item--span-9@lg kib-grid__item--span-10@xl']/div[@class='kib-container--full']/div[@class='kib-grid']/div[@class='ProductListingGrid_overlayWrapper__A5GZ8']/div[@class='ProductListingGrid_gridContainer__FNS4h js-tracked-product-list']/div[1]/div[1]")).click();
				
				Product.click();
				
				Thread.sleep(2000);
				//Add product to Cart
				//driver.findElement(By.xpath("//button[@class='_3BL1ltpM1IQogaoWgNunxf _2rqbHofZus5Vfq7z65ULJf kib-button-default kib-button-default--full kib-button-default--transactional']")).click();
		
				AddToCart.click();
				
				//Confirm quantity 
				//driver.findElement(By.xpath("//span[contains(text(),'Continue with Quantity of 1')]")).click();
				
				Quantity.click();
				
				//going to checkout 
				//driver.findElement(By.xpath("//span[contains(text(),'Proceed to Checkout')]")).click();
				CheckOut.click();
			}
			
			public void login(String email, String password ) throws InterruptedException
			{			
				//open Login Page
				driver.get("https://www.chewy.com/app/login");		
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
				
				//enter email and password 
				//driver.findElement(By.id("username")).sendKeys(email);
				//driver.findElement(By.id("password")).sendKeys(password);
				
				Email.sendKeys(email);
				Password.sendKeys(password);
				
				//click on SignIN
				//driver.findElement(By.xpath("//input[@id='form-login--submit-button']")).click();
				SignIn.click();
				Thread.sleep(2000);
			}
			
			public String globalError()
			{			
				String globalexpectedError = "Oops! Your email or password was incorrect. Please try again.";
				//String globalactualError = driver.findElement(By.xpath("//h5[@class='cw-notification__title']")).getText();
				String globalactualError = GlobalactualError.getText();
				System.out.println(globalactualError);
				return globalactualError;
			}
			
			public String missingEmailError()
			{
				String missingexpectedError = "Oops! Please fix the errors below.";
				//String missingactualError = driver.findElement(By.xpath("//h5[@class='cw-notification__title']")).getText();
				String missingactualError = MissingactualError.getText();
				System.out.println(missingactualError);
				return missingactualError;
			}		
			
			public void LogTracking()
			{
				Logger print = Logger.getLogger("devpinoyLogger");
				print.debug("Hello Mansi");
				print.debug("Email used to login: " + dataTOmethod.IncorrectEmail);
				print.debug("Password used to login: " + dataTOmethod.IncorrectPassword);
				print.debug("Email used to login: " + dataTOmethod.NoEmail);
				print.debug("Password used to login: " + dataTOmethod.IncorrectPassword);
			}
}


/*
package utilityFiles;

import java.io.File;
import java.sql.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	
	static ExtentReports reports;

	public static ExtentReports getReports()
	{
		if(reports == null)
		{
			Date date = new Date(0);
			String foldername = date.toString().replaceAll(":", "-");
			File file = new File(System.getProperty("user.dir") + "//Reports//");
			file.mkdir();
			
			reports = new ExtentReports();
			ExtentReports report = new ExtentReports();
			ExtentSparkReporter sparkreporter = new ExtentSparkReporter(foldername + file);

			sparkreporter.config().setReportName("Regression Testing Report");
			sparkreporter.config().setDocumentTitle("Final Report");
			sparkreporter.config().setTheme(Theme.STANDARD);
			sparkreporter.config().setEncoding("utf-8");

			report.attachReporter(sparkreporter);
		}
		return reports;
	}
}
*/