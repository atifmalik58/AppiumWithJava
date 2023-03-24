package pages;

import baseTest.AppDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class loginPage {

    public loginPage(){

        PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
    }

    @FindBy(id = "com.booking:id/identity_account_start")
    public WebElement sign_withEmail;

    @FindBy(id = "com.booking:id/identity_text_input_edit_text")
    public WebElement userName_txtField;

    @FindBy(id = "com.booking:id/identity_email_continue")
    public WebElement continue_btn;

    @FindBy(id = "com.booking:id/identity_text_input_edit_text")
    public List<WebElement> password_txtField;

    @FindBy(id = "com.booking:id/identity_header_title")
    public WebElement title_header;

    @FindBy(id = "com.booking:id/identity_landing_social_button_text")
    public WebElement create_account_btn;

    @FindBy(id = "com.booking:id/genius_onbaording_bottomsheet_title")
    public WebElement welcome_text;



    public void clickOnCreateAccount(){

        sign_withEmail.click();
    }

    public void clickOnContinueBtn(){

        continue_btn.click();
    }
    public void enterEmail(String email){

        userName_txtField.sendKeys(email);
    }

    public void enterPassword(String password){

        password_txtField.get(0).sendKeys(password);
    }

    public void enterConfirmPassword(String password){

        password_txtField.get(1).sendKeys(password);
    }

    public void createAccountBtn(){

        create_account_btn.click();
    }

    public void verifyAccountCreated(){

        Assert.assertTrue(welcome_text.isDisplayed());
    }
}
