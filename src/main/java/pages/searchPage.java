package pages;

import baseTest.AppDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.List;

public class searchPage {

    public searchPage(){

        PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
    }

    @FindBy(xpath = "//*[@resource-id = 'com.booking:id/facet_search_box_accommodation_destination']" +
            "/*[@resource-id = 'com.booking:id/facet_search_box_basic_field_label']")
    public WebElement destination_search_box;

    @FindBy(id = "com.booking:id/facet_with_bui_free_search_booking_header_toolbar_content")
    public WebElement enter_destination_box;

    @FindBy(id = "com.booking:id/view_disambiguation_destination_title")
    public List<WebElement> destination_results;

    @FindBy(id = "com.booking:id/calendar_month_list")
    public WebElement calendar;

    @FindBy(xpath = "//*[@resource-id='com.booking:id/month_custom_view']/android.view.View")
    public List<WebElement> days;

    @FindBy(id = "com.booking:id/facet_date_picker_confirm")
    public WebElement select_date_button;

    @FindBy(id = "com.booking:id/facet_search_box_cta")
    public WebElement search_button;

    @FindBy(xpath = "//*[@resource-id = 'com.booking:id/results_list_facet']" +
            "/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.view.ViewGroup")
    public List<WebElement> search_results;

    @FindBy(xpath = "//*[@text='Car rental']")
    public WebElement car_rental_label;

    @FindBy(id = "com.booking:id/search_box_edit_pick_up_location")
    public WebElement pick_up_location_box;

    @FindBy(id = "com.booking:id/search_query_edittext")
    public WebElement enter_location_box;

    @FindBy(id = "com.booking:id/ape_rc_view_location_name")
    public List<WebElement> pick_up_location_search_results;
    @FindBy(id = "com.booking:id/bgoc_search_box_date_pick_up")
    public WebElement pick_up_date_box;

    @FindBy(id = "com.booking:id/calendar_confirm")
    public WebElement select_pickUpDate_button;

    @FindBy(id = "com.booking:id/search_box_btn_search")
    public WebElement pick_up_search_button;

    @FindBy(id = "com.booking:id/vehicle_name")
    public List<WebElement> pickUp_search_results;


    public void clickDestinationSearchBox(){

        AppDriver.waitForElement(destination_search_box).click();
    }

    public void selectDestination(String destination){

        AppDriver.waitForElement(enter_destination_box).sendKeys(destination);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<WebElement> destinations = AppDriver.waitForElements(destination_results);
        Iterator<WebElement> itr = destinations.iterator();
        while(itr.hasNext()) {
            WebElement dest = itr.next();
            if (dest.getText().equals(destination)){
                dest.click();
                break;
            }
        }
    }

    public void selectDates(String startDate, String endDate){

        AppDriver.waitForElement(calendar);
        List<WebElement> dates = AppDriver.waitForElements(days);
        Iterator<WebElement> date = dates.iterator();
        while(date.hasNext()){
            WebElement day = date.next();
            if (day.getAttribute("content-desc").equals(startDate)){
                day.click();
            }
            if (day.getAttribute("content-desc").equals(endDate)){
                day.click();
                break;
            }
        }
    }

    public void clickSelectDateButton(){

        AppDriver.waitForElement(select_date_button).click();
    }

    public void clickSearchButton(){

        AppDriver.waitForElement(search_button).click();
    }

    public void getSearchResults(){

        AppDriver.waitForElements(search_results);
    }


    public void selectCarRentalScreen(){

        AppDriver.waitForElement(car_rental_label).click();
    }

    public void enterPickUpLocation(String location){

        AppDriver.waitForElement(pick_up_location_box).click();
        AppDriver.waitForElement(enter_location_box).sendKeys(location);
    }


    public void selectPickUpLocation(){

        List<WebElement> locations = AppDriver.waitForElements(pick_up_location_search_results);
        locations.get(0).click();
    }

    public void selectPickUpDate(String startDate, String endDate){

        AppDriver.waitForElement(pick_up_date_box).click();
        AppDriver.waitForElement(calendar);
        List<WebElement> dates = AppDriver.waitForElements(days);
        Iterator<WebElement> date = dates.iterator();
        while(date.hasNext()){
            WebElement day = date.next();
            if (day.getAttribute("content-desc").equals(startDate)){
                day.click();
            }
            if (day.getAttribute("content-desc").equals(endDate)){
                day.click();
                break;
            }
        }
        AppDriver.waitForElement(select_pickUpDate_button).click();
    }

    public void clickSearchButtonPickUp(){

        AppDriver.waitForElement(pick_up_search_button).click();
    }


    public String getDestinationText(){

        return AppDriver.waitForElement(destination_search_box).getText();
    }

    public String getLocationText(){

        return AppDriver.waitForElement(pick_up_location_box).getText();
    }

    public void getSearchResultsPickUpDate(){

        AppDriver.waitForElements(pickUp_search_results);

    }


}
