package tests;

import common.BaseCode;

public class InvalidEmailLoginTest extends BaseCode {
	
	public static void main(String[] args) {

		//Input Parameters
		String url = "https://accounts.lambdatest.com/dashboard";
		String invalidEmail = "abc.com";
		String email = "abc@email.com";
		String password = "pass123456789";
		
		//Open Chrome browser and login to url https://accounts.lambdatest.com/dashboard
		openBrowserAndURL(url);
		//Verify Google login button
		verifyPageElementDisplayed("//*[text()='Log in with Google']/..");
	      //Verify GitHub login button
		verifyPageElementDisplayed("//*[text()='Log in with Github']/..");
		 //Verify Email field
		verifyPageElementDisplayed("//input[@id='email']");
		 //Verify Password field
		verifyPageElementDisplayed("//input[@id='password']");
		 //Verify Login button
		verifyPageElementDisplayed("//button[@id='login-button']");
	 	//Verify Remember Me checkbox verifyPageElementDisplayed("//label[contains(@class,'i_agree_t')]/samp[contains(@class,'customcheckbox')]");
	 	//Verify Forgot Password link
		verifyPageElementDisplayed("//a[text()='Forgot Password?']");
	 	//Verify Sign up link
		verifyPageElementDisplayed("//a[text()='Sign up']");

		//No Input in the email field
		//click Login button
		click("//button[@id='login-button']");
		verifyTextInPageElement("//p[@data-testid='errors-email']","Please enter your email");

		//Incorrect Input in the email field
		inputValue("//input[@id='email']",invalidEmail);
		//click password field
		click("//input[@id='password']");
		verifyTextInPageElement("//p[@data-testid='errors-email']","Invalid email address");
		
		//Enter correct Email value
		inputValue("//input[@id='email']",email);	
		//No Input in the Password field
		//click password field
		click("//input[@id='password']");
		verifyTextInPageElement("//p[@data-testid='errors-password']","Please enter your password");
		
		//Enter incorrect password
		inputValue("//input[@id='password']",password);
		//Additional code to remove the unnecessary error in the password field
		pause(3);
		click("//span[text()='OR']");
		click("//button[@id='login-button']");	
		//Additional code end here
		
		//click("//input[@id='password']");		
		verifyTextInPageElement("//p[@data-testid='errors-email']","Please enter a correct username and password. Note that the password is case-sensitive");	
				
		//Close browser
		closeBrowser();
		
	}
}
