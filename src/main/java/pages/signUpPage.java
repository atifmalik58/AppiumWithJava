package pages;

import baseTest.AppDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class signUpPage {

    public signUpPage(){

        PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
    }

    @FindBy(id = "com.booking:id/identity_account_start")
    public WebElement sign_withEmail;

    @FindBy(xpath = "//*[@text = 'Enter your email address']")
    public WebElement email_header_title;
    @FindBy(id = "com.booking:id/identity_text_input_edit_text")
    public WebElement userName_txtField;

    @FindBy(id = "com.booking:id/identity_email_continue")
    public WebElement continue_btn;

    @FindBy(id = "com.booking:id/identity_text_input_edit_text")
    public List<WebElement> password_txtField;

    @FindBy(id = "com.booking:id/text_input_end_icon")
    public List<WebElement> password_imageEyeIcon;

    @FindBy(id = "com.booking:id/textinput_error")
    public WebElement password_errorMessage;

    @FindBy(id = "com.booking:id/identity_landing_social_button_text")
    public WebElement create_account_btn;

    @FindBy(xpath = "//*[@content-desc='Navigate up']")
    public WebElement back_navigation;

    public void clickOnCreateAccount(){

        AppDriver.waitForElement(sign_withEmail).click();
    }

    public void clickOnContinueBtn(){

        AppDriver.waitForElement(continue_btn).click();
    }

    public String getEmailHeaderTitle(){

        return AppDriver.waitForElement(email_header_title).getText();
    }

    public void enterEmail(String email){

        AppDriver.waitForElement(userName_txtField).sendKeys(email);
    }

    public void enterPassword(String password){

        AppDriver.waitForElements(password_imageEyeIcon);
        AppDriver.waitForElements(password_txtField).get(0).sendKeys(password);
    }

    public void enterConfirmPassword(String password){

        AppDriver.waitForElements(password_txtField).get(1).sendKeys(password);
    }

    public void createAccountBtn(){

        AppDriver.waitForElement(create_account_btn).click();
    }

    public String getConfirmPasswordErrorMessage(){

        AppDriver.waitForElement(password_errorMessage);
        return password_errorMessage.getText();
    }

    public void navigateBack(){

        back_navigation.click();
    }

}
