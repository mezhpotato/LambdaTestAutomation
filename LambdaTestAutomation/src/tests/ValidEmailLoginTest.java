package tests;

import common.BaseCode;

public class ValidEmailLoginTest extends BaseCode {

	public static void main(String[] args) {
		//Input Parameters
		String url = "https://accounts.lambdatest.com/dashboard";
		String email = "mezhpotato@gmail.com";
		String password = "password12345";
		String nameOfUser = "Lenard Magpantay";
		
		//Open chrome browser and login to url https://accounts.lambdatest.com/dashboard
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
	 	//Verify Remember Me checkbox 
		verifyPageElementDisplayed("//label[contains(@class,'i_agree_t')]/samp[contains(@class,'customcheckbox')]");
	 	//Verify Forgot Password link
		verifyPageElementDisplayed("//a[text()='Forgot Password?']");
	 	//Verify Sign up link
		verifyPageElementDisplayed("//a[text()='Sign up']");
		//Enter email
		inputValue("//input[@id='email']",email);
		//Enter Password
		inputValue("//input[@id='password']",password);
		//click Login button
		click("//button[@id='login-button']");	
		pause(5);
		//Validate you land on the dashboard page
		verifyPageElementDisplayed("//a[text()='Dashboard']"); //Dashboard menu
		verifyPageElementDisplayed("//span[text()='Hello']"); //Message for User
		verifyTextInPageElement("//span[@id='user-name']",nameOfUser); //Name of user		
		//Verify the current URL	
		verifyCurrentURL(url);
		
		//Logout in the application
		pause(8);
		clickJS("//div[@class='nav__item lt-dropdown profile__dropdown']");	
	    click("//a[@id='app__logout']");
		//Close browser
		closeBrowser();
	}

}
