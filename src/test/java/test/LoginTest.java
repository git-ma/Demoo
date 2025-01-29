package test;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import dataFiles.DataFile;
import pages.MethodPage;

public class LoginTest {

	MethodPage methodpage = new MethodPage(); // created object of method page to use functions in this test
	DataFile datafile = new DataFile(); // created object of data file to access data
	
	@BeforeMethod
	public void beforeMethod() throws IOException 
	{
		methodpage.openBrowser(); //open browser
	}
	
	@AfterMethod
	public void afterMethod() 
	{
		methodpage.closeBrowser(); //close browser once task is completed.
	}
	
	@AfterClass
	public void afterclass()
	{
		methodpage.LogTracking(); //keep track of login and save used credentials.
	}

	@Test
	public void IncorrectCredentials() throws InterruptedException 
	{
		methodpage.login(datafile.IncorrectEmail, datafile.IncorrectPassword);
		
		//compares actual error with expected error
		Assert.assertEquals(methodpage.globalError(), datafile.GlobalexpectedError); 
	} 
	
	@Test
	public void loginwithNOEmail() throws InterruptedException 
	{
		methodpage.login(datafile.NoEmail, datafile.IncorrectPassword);
		
		//compares actual error with expected error
		Assert.assertEquals(methodpage.missingEmailError(), datafile.MissingexpectedError);
	}  	
}
