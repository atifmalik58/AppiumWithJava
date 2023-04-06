package pages;

import baseTest.AppDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class signInPage {

    public signInPage(){

        PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
    }

    @FindBy(id = "com.booking:id/identity_landing_social_button_icon")
    public WebElement sign_withEmail;

    @FindBy(id = "com.booking:id/identity_header_description")
    public WebElement email_header_description;

    @FindBy(id = "com.booking:id/identity_text_input_edit_text")
    public WebElement userName_txtField;

    @FindBy(id = "com.booking:id/identity_landing_social_button_text")
    public WebElement continue_btn;

    @FindBy(xpath = "//*[@text = 'Enter your password']")
    public WebElement password_header_title;

    @FindBy(xpath = "//*[@resource-id = 'com.booking:id/identity_header_description']")
    public WebElement password_header_description;

    @FindBy(xpath = "//*[@resource-id = 'com.booking:id/identity_text_input_edit_text']")
    public WebElement password_txtField;

    @FindBy(xpath = "//*[@text='Sign in']")
    public WebElement sign_in_btn;
    @FindBy(id = "com.booking:id/textinput_error")
    public WebElement password_errorMessage;



    public void clickOnLoginWithEmail(){

        AppDriver.waitForElement(sign_withEmail).click();
    }

    public void clickOnContinueBtn(){

        AppDriver.waitForElement(continue_btn).click();
    }

    public String getEmailHeaderDescription(){

        return AppDriver.waitForElement(email_header_description).getText();
    }

    public void enterEmail(String email){

        AppDriver.waitForElement(email_header_description);
        AppDriver.waitForElement(userName_txtField).sendKeys(email);
    }

    public String getPasswordHeaderDescription(){

        AppDriver.waitForElement(password_header_title);
        return AppDriver.waitForElement(password_header_description).getText();
    }

    public void enterPassword(String password){

        AppDriver.waitForElement(password_header_description);
        AppDriver.waitForElement(password_txtField).sendKeys(password);
    }

    public void clickLoginBtn(){

        AppDriver.waitForElement(sign_in_btn).click();
    }

    public String getIncorrectPasswordErrorMessage(){

        AppDriver.waitForElement(password_errorMessage);
        return password_errorMessage.getText();
    }

}
