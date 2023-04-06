package baseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AppDriver {

    public static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver(){

        return driver.get();
    }

    public static void setDriver(WebDriver Driver){

        driver.set(Driver);
    }

    public static WebElement waitForElement(WebElement elem){

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(100));
        wait.until(ExpectedConditions.visibilityOf(elem));
        return elem;
    }

    public static List<WebElement> waitForElements(List<WebElement> elem_list){

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(100));
        wait.until(ExpectedConditions.visibilityOfAllElements(elem_list));
        return elem_list;
    }

}
