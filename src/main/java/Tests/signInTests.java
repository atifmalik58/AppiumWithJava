package Tests;

import baseTest.AppFactory;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.signInPage;
import pages.homePage;
import utilities.configReader;

import java.net.MalformedURLException;

public class signInTests {

    configReader config;
    signInPage signIn;
    homePage home;
    AppFactory factory;

    @BeforeMethod
    public void setup() throws MalformedURLException {

        config = new configReader();
        factory = new AppFactory();
        factory.initializer();
        signIn = new signInPage();
        home = new homePage();

    }

    @Test
    @Epic("Booking.com - Final Assignment")
    @Feature("Sign In")
    @Description("To verify user can Sign in with email")
    @Story("User should be able to Login into the application with valid Email and Password")
    @Severity(SeverityLevel.CRITICAL)
    public void loginUser(){

        String email = config.getEmail();
        String password = config.getPassword();
        signIn.clickOnLoginWithEmail();
        signIn.enterEmail(email);
        signIn.clickOnContinueBtn();
        Assert.assertEquals(signIn.getPasswordHeaderDescription(),
                "Enter your Booking.com password for "+email+".");
        signIn.enterPassword(password);
        signIn.clickLoginBtn();
        home.verifyLoginIsSuccessful();
    }

    @Test
    @Epic("Booking.com - Final Assignment")
    @Feature("Sign In")
    @Description("To verify the validation message of incorrect password")
    @Story("System should show validation message when incorrect password is entered")
    @Severity(SeverityLevel.CRITICAL)
    public void loginWithIncorrectPassword(){

        String email = config.getEmail();
        String password = "Incorrect";
        signIn.clickOnLoginWithEmail();
        signIn.enterEmail(email);
        signIn.clickOnContinueBtn();
        Assert.assertEquals(signIn.getPasswordHeaderDescription(),
                "Enter your Booking.com password for "+email+".");
        signIn.enterPassword(password);
        signIn.clickLoginBtn();
        Assert.assertEquals(signIn.getIncorrectPasswordErrorMessage(),
                "Incorrect password – try again");
    }

    @AfterMethod
    public void quitDriver(){ factory.quitDriver(); }

}
