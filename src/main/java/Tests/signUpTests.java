package Tests;

import baseTest.AppFactory;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.homePage;
import pages.signUpPage;
import utilities.excelReader;

import java.net.MalformedURLException;
import java.util.Random;


public class signUpTests {

    excelReader excel_reader;
    signUpPage signUp;

    homePage home;
    AppFactory factory;

    @BeforeMethod
    public void setup() throws MalformedURLException {

        excel_reader = new excelReader();
        excel_reader.readExcelFile();
        factory = new AppFactory();
        factory.initializer();
        signUp = new signUpPage();
        home = new homePage();
    }

    @Test
    @Epic("Booking.com - Final Assignment")
    @Feature("Account Creation")
    @Description("To verify user can create New Account")
    @Story("User should be able to create New Account for Login into the application")
    @Severity(SeverityLevel.CRITICAL)
    public void createAccount(){

        String email = "final" + rand() + excelReader.GetCellValue(1,0);
        String password = excelReader.GetCellValue(1,1);
        signUp.clickOnCreateAccount();
        signUp.enterEmail(email);
        signUp.clickOnContinueBtn();
        Assert.assertTrue(signUp.title_header.isDisplayed());
        signUp.enterPassword(password);
        signUp.enterConfirmPassword(password);
        signUp.createAccountBtn();
        home.verifyLoginIsSuccessful();
    }

    @Test
    @Epic("Booking.com - Final Assignment")
    @Feature("Account Creation")
    @Description("To verify the validation message of confirm password")
    @Story("System should show validation message when confirm password does not match")
    @Severity(SeverityLevel.CRITICAL)
    public void incorrectConfirmPassword(){

        String email = "final" + rand() + excelReader.GetCellValue(1,0);
        String password = excelReader.GetCellValue(1,1);
        signUp.clickOnCreateAccount();
        signUp.enterEmail(email);
        signUp.clickOnContinueBtn();
        Assert.assertTrue(signUp.title_header.isDisplayed());
        signUp.enterPassword(password);
        signUp.enterConfirmPassword("incorrect password");
        signUp.createAccountBtn();
        Assert.assertEquals(signUp.getConfirmPasswordErrorMessage(),"This password doesn't match");
        signUp.navigateBack();
        signUp.navigateBack();
    }

    @AfterMethod
    public void quitDriver(){ factory.quitDriver(); }
    public int rand(){
        Random r = new Random();
        int x = r.nextInt(900) + 100;
        return x;
    }
}
