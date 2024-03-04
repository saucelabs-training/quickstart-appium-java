package tests.RDC;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobilePlatform;
import org.joda.time.DateTime;
import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import static tests.Config.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AppiumIosRdcAppTest {

    private static ThreadLocal<IOSDriver> iosDriver = new ThreadLocal<IOSDriver>();

    AppiumBy.ByAccessibilityId productScreenLocator = new AppiumBy.ByAccessibilityId("products screen");
    AppiumBy.ByAccessibilityId sortButtonLocator = new AppiumBy.ByAccessibilityId("sort button");
    AppiumBy.ByAccessibilityId sortModalLocator = new AppiumBy.ByAccessibilityId("active option");

    @BeforeMethod
    public void setup(Method method) throws MalformedURLException {
        String appName = "iOS-Real-Device-MyRNDemoApp.ipa";

        System.out.println("Sauce iOS Native - BeforeMethod hook");
        URL url;

        switch (region) {
            case "us":
                System.out.println("region is us");
                url = new URL(SAUCE_US_URL);
                break;
            case "eu":
            default:
                System.out.println("region is eu");
                url = new URL(SAUCE_EU_URL);
                break;
        }

        MutableCapabilities capabilities = new MutableCapabilities();
        MutableCapabilities sauceOptions = new MutableCapabilities();
        // For all capabilities please check
        // http://appium.io/docs/en/writing-running-appium/caps/#general-capabilities
        // https://docs.saucelabs.com/dev/test-configuration-options/#mobile-appium-capabilities
        // Use the platform configuration https://saucelabs.com/platform/platform-configurator#/
        // to find the simulators/real device names, OS versions and appium versions you can use for your testings
        capabilities.setCapability("platformName", MobilePlatform.IOS);
        capabilities.setCapability("appium:automationName", AutomationName.IOS_XCUI_TEST);
        capabilities.setCapability("appium:deviceName", "iPhone.*");
        capabilities.setCapability("appium:platformVersion", "1[5-6].*");
        capabilities.setCapability("appium:app", "storage:filename=" + appName );

        // Sauce capabilities
        sauceOptions.setCapability("resigningEnabled", true);
        sauceOptions.setCapability("networkCapture", true);
        sauceOptions.setCapability("name", method.getName());
        DateTime dt = new DateTime();
        sauceOptions.setCapability("build", "RDC Native Simple Example: build-" + dt.hourOfDay().getAsText() + "-" + dt.minuteOfHour().getAsText());
        sauceOptions.setCapability("username", SAUCE_USERNAME);
        sauceOptions.setCapability("accessKey", SAUCE_ACCESS_KEY);
        sauceOptions.setCapability("appiumVersion", "2.0.0");
        capabilities.setCapability("sauce:options", sauceOptions);

        try {
            iosDriver.set(new IOSDriver(url, capabilities));
        } catch (Exception e) {
            System.out.println("*** Problem to create the iOS driver " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void teardown(ITestResult result) {
        System.out.println("Sauce - AfterMethod hook");
        ((JavascriptExecutor)getiosDriver()).executeScript("sauce:job-result=" + (result.isSuccess() ? "passed" : "failed"));
        getiosDriver().quit();
    }

    public  IOSDriver getiosDriver() {
        return iosDriver.get();
    }

    @Test
    public void verifySortOptionsScreen() {
        System.out.println("Sauce - Start verifySortOptionsScreen test");

        IOSDriver driver = getiosDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // wait for the main page
        wait.until(ExpectedConditions.visibilityOfElementLocated(productScreenLocator));

        driver.findElement(sortButtonLocator).click();

        //assertion - Verify the sort modal is displayed on screen
        assertThat(driver.findElement(sortModalLocator).isDisplayed(), is(true));
    }



}