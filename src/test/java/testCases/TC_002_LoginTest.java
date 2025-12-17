package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass
{

	@Test(groups= {"Sanity","Master"}) //Step8 groups added
	public void verify_login()
	{
		logger.info("**** Starting TC_002_LoginTest  ****");
		try
		{
		//Home page
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin(); //Login link under MyAccount
		
		//Login page
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin(); //Login button
		
		//My Account Page
		MyAccountPage macc=new MyAccountPage(driver);
				
		boolean targetPage=macc.isMyAccountPageExists();
		
		Assert.assertTrue(targetPage);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("**** Finished TC_002_LoginTest  ****");
	}
}
