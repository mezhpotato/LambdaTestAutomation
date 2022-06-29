package tests;

import common.BaseCode;

public class ValidGoogleLoginTest extends BaseCode {

	public static void main(String[] args) {
		// Input Parameters
		String url = "https://accounts.lambdatest.com/dashboard";
		String user = "lenar";
		String email = "mezhpotatous";
		String password = "newyork12345!";
		String nameOfUser = "Lenard Magpantay";

		// Open chrome browser and login to url
		// https://accounts.lambdatest.com/dashboard
		openBrowserAndURL_Google(url, user);
//		openBrowserAndURL(url);
		// Verify Google login button
		verifyPageElementDisplayed("//*[text()='Log in with Google']/..");
		// Verify GitHub login button
		verifyPageElementDisplayed("//*[text()='Log in with Github']/..");
		// Verify Email field
		verifyPageElementDisplayed("//input[@id='email']");
		// Verify Password field
		verifyPageElementDisplayed("//input[@id='password']");
		// Verify Login button
		verifyPageElementDisplayed("//button[@id='login-button']");
		// Verify Remember Me checkbox
		verifyPageElementDisplayed("//label[contains(@class,'i_agree_t')]/samp[contains(@class,'customcheckbox')]");
		// Verify Forgot Password link
		verifyPageElementDisplayed("//a[text()='Forgot Password?']");
		// Verify Sign up link
		verifyPageElementDisplayed("//a[text()='Sign up']");

		// Login to GitHub
		// click GitHub Login button
		click("//*[text()='Log in with Google']/..");
		// Enter email
		inputValue("//input[@type='email']", email);
		//click Next
		click("(//span[@jsname='V67aGc'])[2]"); //Automation is blocked due to Google Security Sign-in. No work around implemented at the moment.
		// Enter Password
		inputValue("//input[@type='password']", password);
		// click Login button
		click("(//span[@jsname='V67aGc'])[2]");
		pause(10);
		// Validate you land on the dashboard page
		verifyPageElementDisplayed("//a[text()='Dashboard']"); // Dashboard menu
		verifyPageElementDisplayed("//span[text()='Hello']"); // Message for User
		verifyTextInPageElement("//span[@id='user-name']", nameOfUser); // Name of user
		// Verify the current URL
		verifyCurrentURL(url);

		// Logout in the application
		pause(8);
		clickJS("//div[@class='nav__item lt-dropdown profile__dropdown']");
		click("//a[@id='app__logout']");
		// Close browser
		closeBrowser();

	}

}
