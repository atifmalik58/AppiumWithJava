package Tests;

import baseTest.AppFactory;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.loginPage;
import utilities.excelReader;

import java.net.MalformedURLException;
import java.util.Random;


public class loginTests {

    excelReader excel_reader;
    loginPage login;
    AppFactory factory;

    @BeforeTest
    public void setup() throws MalformedURLException {

        excel_reader = new excelReader();
        excel_reader.readExcelFile();
        factory = new AppFactory();
        factory.initializer();
        login = new loginPage();
    }

    @Test
    @Epic("Booking.com - Final Assignment")
    @Feature("Account Creation")
    @Description("To verify user can create New Account")
    @Story("User should be able to create New Account for Login into the application")
    @Severity(SeverityLevel.CRITICAL)
    public void createAccount(){

        String email = "atif" + rand() + excelReader.GetCellValue(1,0);
        String password = excelReader.GetCellValue(1,1);
        login.clickOnCreateAccount();
        login.enterEmail(email);
        login.clickOnContinueBtn();
        Assert.assertTrue(login.title_header.isDisplayed());
        login.enterPassword(password);
        login.enterConfirmPassword(password);
        login.createAccountBtn();
        login.verifyAccountCreated();
    }

    @AfterTest
    public void quitDriver(){
        factory.quitDriver();
    }
    public int rand(){
        Random r = new Random();
        int x = r.nextInt(900) + 100;
        return x;
    }
}
