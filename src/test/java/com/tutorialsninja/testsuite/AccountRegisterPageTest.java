package com.tutorialsninja.testsuite;

import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.pages.MyAccountPage;
import com.tutorialsninja.pages.MyAccountRegisterPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.UUID;

@Listeners(CustomListeners.class)
public class AccountRegisterPageTest extends BaseTest {

    MyAccountPage myAccountPage ;
    MyAccountRegisterPage accountRegisterPage ;
    @BeforeMethod(alwaysRun = true)
    public void inIT(){

        myAccountPage = new MyAccountPage();
        accountRegisterPage = new MyAccountRegisterPage();


    }

    @Test(groups = {"sanity","regeression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        //1.1 Click on My Account Link.
        myAccountPage.clickOnMyAccountTab();
        // 1.2 Call the method “selectMyAccountOptions” method and pass the parameter Register
        myAccountPage.selectMyAccountOptions("Register");
        //1.3 Verify the text “Register Account”
        Assert.assertEquals(myAccountPage.getRegisterAccountText(), "Register Account", "Register Account not displayed");
    }

    @Test(groups = {"smoke","regeression"})
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException{
        //3.1 Click on My Account Link.
        myAccountPage.clickOnMyAccountTab();
        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter Register
        myAccountPage.clickOnRegister();
        //3.3 Enter First Name
        accountRegisterPage.enterFirstName("Shubh");
        //3.4 Enter Last Name
        accountRegisterPage.enterLastName("Parikh");
        //3.5 Enter Email
        String email= "random-" + UUID.randomUUID().toString() + "@example.com";
        accountRegisterPage.enterEmail(email);
        //3.6 Enter Telephone
        accountRegisterPage.enterTelephone("079124841492");
        //3.7 Enter Password
        accountRegisterPage.enterPassword("Charlie789");
        //3.8 Enter Password Confirm
        accountRegisterPage.enterConfirmPassword("Charlie789");
        //3.9 Select Subscribe Yes radio button
        accountRegisterPage.selectSubscribeYesRadioButton();
        //3.10 Click on Privacy Policy check box
        accountRegisterPage.clickPrivacyPolicyCheckbox();
        //3.11 Click on Continue button
        accountRegisterPage.clickOnContinueButton();
        //3.12 Verify the message “Your Account Has Been Created!”
        Assert.assertEquals(accountRegisterPage.getAccountHasBeenCreatedText(), "Your Account Has Been Created!", "Cannot create account");
        // 3.13 Click on Continue button
        accountRegisterPage.clickOnContinueButtonAgain();
        //3.14 Clickr on My Account Link.
        accountRegisterPage.clickOnMyAccountLink();
        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter "Logout"
        myAccountPage.selectMyAccountOptions("Logout");
        //3.16 Verify the text “Account Logout”
        Assert.assertEquals(accountRegisterPage.getAccountLogoutText(), "Account Logout", "Cannot logout");
        Thread.sleep(2000);
        //3.17 Click on Continue button
        accountRegisterPage.clickOnContinueButtonAgain();
    }
}
