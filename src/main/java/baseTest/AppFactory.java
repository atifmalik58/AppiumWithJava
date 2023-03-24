package baseTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import utilities.configReader;


import java.net.MalformedURLException;
import java.net.URL;

public class AppFactory {

    public AndroidDriver driver;

    public static utilities.configReader configReader;

    public void initializer() throws MalformedURLException {

        DesiredCapabilities cap = new DesiredCapabilities();
        configReader = new configReader();
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, configReader.getAutomationName());
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, configReader.getPlatformName());
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, configReader.getPlatformVersion());
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, configReader.getDeviceName());
        cap.setCapability("newCommandTimeout", 100000);
        cap.setCapability(MobileCapabilityType.APP, configReader.getApkPath());

        URL url = new URL(configReader.getServerURL());

        driver = new AndroidDriver(url, cap);

        AppDriver.setDriver(driver);

    }

    public void quitDriver(){

        if(null != driver)
            driver.quit();
    }

}
