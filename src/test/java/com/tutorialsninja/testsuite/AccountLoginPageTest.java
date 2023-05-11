package com.tutorialsninja.testsuite;

import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.pages.MyAccountLoginPage;
import com.tutorialsninja.pages.MyAccountPage;
import com.tutorialsninja.pages.MyAccountRegisterPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(CustomListeners.class)
public class AccountLoginPageTest extends BaseTest {
    MyAccountPage myAccountPage ;
    MyAccountRegisterPage accountRegisterPage ;
    MyAccountLoginPage accountLoginPage;
    SoftAssert softAssert;
    @BeforeMethod(alwaysRun = true)
    public void inIT(){

       myAccountPage = new MyAccountPage();
       accountRegisterPage = new MyAccountRegisterPage();
       accountLoginPage = new MyAccountLoginPage();

    }

    @Test(groups = {"sanity","regeression"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully() throws InterruptedException{
        Thread.sleep(2000);
        //2.1 Click on My Account Link.
        myAccountPage.clickOnMyAccountTab();
        // 2.2 Call the method “selectMyAccountOptions” method and pass the parameter "Login"
        myAccountPage.selectMyAccountOptions("Login");
        //2.3 Verify the text “Returning Customer”
      softAssert(myAccountPage.getReturningCustomerText(), "Returning Customer", "Returning Customer Text not displayed");
    }
    @Test(groups = {"smoke","regeression"})
    public void  verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException{
        //4.1 Click on My Account Link
        myAccountPage.clickOnMyAccountTab();
        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter "login"
        myAccountPage.selectMyAccountOptions("Login");
        //4.3 Enter Email address
        accountLoginPage.enterEmailAddress("kp1309@gmail.com");
        //4.5 Enter Password
        accountLoginPage.enterValidPassword("Tango456");
        //4.6 Click on Login button
        accountLoginPage.clickOnLoginButton();
        //4.7 Verify text “My Account”
        softAssert(accountLoginPage.getMyAccountText(),"My Account","My Account has not displayed");
        Thread.sleep(2000);
        //4.8 Click on My Account Link.
        myAccountPage.clickOnMyAccountTabAgain();
        Thread.sleep(4000);
        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter "Logout"
        myAccountPage.clickLogout();
        // 4.10 Verify the text “Account Logout”
        softAssert(accountRegisterPage.getAccountLogoutText(),"Account Logout","Account logout has not displayed");
        //4.11 Click on Continue button
        accountRegisterPage.clickOnContinueButtonAgain();
    }
}
