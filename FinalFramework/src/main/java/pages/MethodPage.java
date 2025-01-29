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

public class MethodPage {

		WebDriver driver;
		DataFile dataTOmethod = new DataFile();
		
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
		
		@FindBy(id = "username") // finding element by provided attribute
		public WebElement Email; // declaring web element 
		
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
			FileInputStream file = new FileInputStream("C:\\testing\\prop.properties"); //property file path
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
				System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\chromedriver.exe");
				driver = new ChromeDriver();
			} 
			else
			{
				System.setProperty("webdriver.safari.driver", "C:\\SeleniumJars\\safaridriver.exe");
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
			SearchBox.sendKeys("Tylosin Tartrate Compounded"); //search in search box		
			SearchIcon.click(); //click on search icon 
		}
		
		public void SelectItem() throws InterruptedException
		{				 	
			Product.click(); //click on product we need			
			Thread.sleep(2000);
			
			AddToCart.click();	//Add product to Cart		
			Thread.sleep(2000);
						
			Quantity.click();	//Confirm quantity 		
			Thread.sleep(2000);
						
			CheckOut.click();//going to checkout 
		}
		
		public void login(String email, String password ) throws InterruptedException
		{
			driver.get("https://www.chewy.com/app/login");		 //open Login Page
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
			
			//enter email and password 			
			Email.sendKeys(email);
			Password.sendKeys(password);
							
			SignIn.click(); //click on SignIN
			Thread.sleep(2000);
		}
		
		public String globalError()
		{			
			String globalactualError = GlobalactualError.getText();
			System.out.println(globalactualError);
			return globalactualError;
		}
		
		public String missingEmailError()
		{
			String missingactualError = MissingactualError.getText();
			System.out.println(missingactualError);
			return missingactualError;
		}		
		
		public void LogTracking()
		{
			Logger print = Logger.getLogger("devpinoyLogger"); //display information into log file 
			print.debug("Hello Mansi");
			print.debug("Email used to login: " + dataTOmethod.IncorrectEmail);
			print.debug("Password used to login: " + dataTOmethod.IncorrectPassword);
			print.debug("Email used to login: " + dataTOmethod.NoEmail);
			print.debug("Password used to login: " + dataTOmethod.IncorrectPassword);
		}
}