package Tests;

import baseTest.AppFactory;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.searchPage;
import pages.homePage;
import pages.signInPage;
import utilities.configReader;

import java.net.MalformedURLException;

public class searchTests {

    configReader config;
    searchPage search;
    homePage home;
    signInPage signIn;
    AppFactory factory;

    @BeforeMethod
    public void setup() throws MalformedURLException {

        config = new configReader();
        factory = new AppFactory();
        factory.initializer();
        search = new searchPage();
        signIn = new signInPage();
        home = new homePage();

        String email = config.getEmail();
        String password = config.getPassword();

        signIn.loginWithValidCredentials(email, password);
        home.verifyLoginIsSuccessful();
        home.navigateToSearchPage();

    }

    @Test
    @Epic("Booking.com - Final Assignment")
    @Feature("Search Hotels")
    @Description("To verify user can get search results for hotels")
    @Story("User should be able to perform hotel search by entering Destination and Travel Dates")
    @Severity(SeverityLevel.CRITICAL)
    public void searchHotels(){

        search.clickDestinationSearchBox();
        search.selectDestination("Bangkok");
        search.selectDates("13 April 2023", "20 April 2023");
        search.clickSelectDateButton();
        Assert.assertEquals(search.getDestinationText(), "Bangkok");
        search.clickSearchButton();
        search.getSearchResults();
    }

    @Test
    @Epic("Booking.com - Final Assignment")
    @Feature("Search Car Rentals")
    @Description("To verify user can get search results for Car Rentals")
    @Story("User should be able to perform Car Rentals search by entering Location and Pickup Dates")
    @Severity(SeverityLevel.CRITICAL)
    public void searchCarRentals(){

        search.selectCarRentalScreen();
        search.enterPickUpLocation("Bangkok");
        search.selectPickUpLocation();
        Assert.assertEquals(search.getLocationText(), "Bangkok");
        search.selectPickUpDate("13 April 2023", "20 April 2023");
        search.clickSearchButtonPickUp();
        search.getSearchResultsPickUpDate();
    }
    @AfterMethod
    public void quitDriver(){ factory.quitDriver(); }

}
