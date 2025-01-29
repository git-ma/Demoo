package test;

import java.io.IOException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.MethodPage;

public class AddToCartTest {

		MethodPage methodpage = new MethodPage(); // created object of method page to use functions in this test
		
		@BeforeMethod
		public void beforeMethod() throws IOException 
		{			
			methodpage.openBrowser(); //open browser
		}
		
		@AfterMethod
		public void afterMethod() 
		{				
			methodpage.closeBrowser(); //close browser once task is completed
		}

		@Test
		public void AddtoCart() throws InterruptedException
		{
			methodpage.openWebsite();
			methodpage.SearchItem();
			methodpage.SelectItem();
		} 		
}
