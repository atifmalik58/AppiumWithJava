package pages;

import baseTest.AppDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
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

    @FindBy(id = "com.booking:id/text_input_end_icon")
    public List<WebElement> password_imageEyeIcon;

    @FindBy(id = "com.booking:id/identity_header_title")
    public WebElement title_header;

    @FindBy(id = "com.booking:id/identity_landing_social_button_text")
    public WebElement create_account_btn;

    @FindBy(id = "com.booking:id/genius_onbaording_bottomsheet_title")
    public WebElement welcome_text;



    public void waitForElement(WebDriver d, WebElement elem){

        WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(100));
        wait.until(ExpectedConditions.visibilityOf(elem));
    }

    public void waitForElements(WebDriver d, List<WebElement> elem_list){

        WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(100));
        wait.until(ExpectedConditions.visibilityOfAllElements(elem_list));

    }
    public void clickOnCreateAccount(){

        waitForElement(AppDriver.getDriver(), sign_withEmail);
        sign_withEmail.click();
    }

    public void clickOnContinueBtn(){

        waitForElement(AppDriver.getDriver(), continue_btn);
        continue_btn.click();
    }
    public void enterEmail(String email){

        waitForElement(AppDriver.getDriver(), userName_txtField);
        userName_txtField.sendKeys(email);
    }

    public void enterPassword(String password){

        waitForElements(AppDriver.getDriver(), password_imageEyeIcon);
        waitForElements(AppDriver.getDriver(), password_txtField);
        password_txtField.get(0).sendKeys(password);
    }

    public void enterConfirmPassword(String password){

        waitForElements(AppDriver.getDriver(), password_txtField);
        password_txtField.get(1).sendKeys(password);
    }

    public void createAccountBtn(){

        waitForElement(AppDriver.getDriver(), create_account_btn);
        create_account_btn.click();
    }

    public void verifyAccountCreated(){

        waitForElement(AppDriver.getDriver(), welcome_text);
        Assert.assertTrue(welcome_text.isDisplayed());
    }
}
