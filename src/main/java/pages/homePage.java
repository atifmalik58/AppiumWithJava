package pages;

import baseTest.AppDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class homePage {

    public homePage(){

        PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
    }


    @FindBy(xpath = "//*[@content-desc='Search']")
    public WebElement search_navigation;

    @FindBy(xpath = "//*[@content-desc='Saved']")
    public WebElement saved_navigation;

    @FindBy(xpath = "//*[@content-desc='Bookings']")
    public WebElement bookings_navigation;

    @FindBy(xpath = "//*[@content-desc='Profile']")
    public WebElement profile_navigation;

    @FindBy(id = "com.booking:id/genius_onbaording_bottomsheet_title")
    public WebElement welcome_text;

    @FindBy(id = "com.booking:id/genius_onbaording_bottomsheet_cta")
    public WebElement welcome_popup_btn;

    @FindBy(id = "com.booking:id/facet_profile_header_avatar")
    public WebElement profile_avatar;

    public void navigateToSearchPage(){ search_navigation.click(); }
    public void navigateToSavedPage(){ saved_navigation.click(); }
    public void navigateToBookingsPage(){ bookings_navigation.click(); }
    public void navigateToProfilePage(){ profile_navigation.click(); }

    public void verifyLoginIsSuccessful(){

        AppDriver.waitForElement(welcome_text);
        Assert.assertTrue(welcome_text.isDisplayed());
        welcome_popup_btn.click();
        navigateToProfilePage();
        Assert.assertTrue(profile_avatar.isDisplayed());
    }
}
