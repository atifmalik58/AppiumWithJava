package Tests;

import baseTest.AppFactory;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.signUpPage;
import utilities.excelReader;

import java.net.MalformedURLException;
import java.util.Random;


public class signUpTests {

    excelReader excel_reader;
    signUpPage signUp;
    AppFactory factory;

    @BeforeTest
    public void setup() throws MalformedURLException {

        excel_reader = new excelReader();
        excel_reader.readExcelFile();
        factory = new AppFactory();
        factory.initializer();
        signUp = new signUpPage();
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
        signUp.verifyAccountCreated();
    }

    @AfterTest
    public void quitDriver(){ factory.quitDriver(); }
    public int rand(){
        Random r = new Random();
        int x = r.nextInt(900) + 100;
        return x;
    }
}
