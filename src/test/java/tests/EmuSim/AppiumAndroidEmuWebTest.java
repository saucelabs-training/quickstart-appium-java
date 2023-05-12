package tests.EmuSim;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobilePlatform;
import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.MutableCapabilities;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;
import static tests.Config.*;


public class AppiumAndroidEmuWebTest {

    private static ThreadLocal<AndroidDriver> androidDriver = new ThreadLocal<AndroidDriver>();

    String url = "https://www.saucedemo.com/";

    By usernameInput = By.id("user-name");
    By passwordInput = By.id("password");
    By submitButton = By.className("btn_action");
    By productTitle = By.className("inventory_list");


    @BeforeMethod
    public void setup(Method method) throws MalformedURLException {

        System.out.println("Sauce Android Web - BeforeMethod hook");

        URL url;
        MutableCapabilities capabilities = new MutableCapabilities();
        MutableCapabilities sauceOptions = new MutableCapabilities();

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

        // For all capabilities please check
        // http://appium.io/docs/en/writing-running-appium/caps/#general-capabilities
        // https://docs.saucelabs.com/dev/test-configuration-options/#mobile-appium-capabilities
        // Use the platform configuration https://saucelabs.com/platform/platform-configurator#/
        // to find the simulators/real device names, OS versions and appium versions you can use for your testings

        capabilities.setCapability("platformName", MobilePlatform.ANDROID);
        capabilities.setCapability("appium:automationName", AutomationName.ANDROID_UIAUTOMATOR2);
        capabilities.setCapability("browserName", MobileBrowserType.CHROME);

        capabilities.setCapability("appium:deviceName",  "Android GoogleAPI Emulator");
        capabilities.setCapability("appium:platformVersion",  "13.0");
        capabilities.setCapability("appium:deviceOrientation", "portrait");

        sauceOptions.setCapability("name", method.getName());
        DateTime dt = new DateTime();
        sauceOptions.setCapability("build", "Emulator Simple Example: build-" + dt.hourOfDay().getAsText() + "-" + dt.minuteOfHour().getAsText());
        List<String> tags = Arrays.asList("sauceDemo_web_android", "android", "Demo");
        sauceOptions.setCapability("tags", tags);
        sauceOptions.setCapability("username", SAUCE_USERNAME);
        sauceOptions.setCapability("accessKey", SAUCE_ACCESS_KEY);

        capabilities.setCapability("sauce:options", sauceOptions);

        try {
            androidDriver.set(new AndroidDriver(url, capabilities));
        } catch (Exception e) {
            out.println("*** Problem to create the Android driver " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void teardown(ITestResult result) {
        System.out.println("Sauce - AfterMethod hook");
        try {
            ((JavascriptExecutor) getAndroidDriver()).executeScript("sauce:job-result=" + (result.isSuccess() ? "passed" : "failed"));
        } finally {
            System.out.println("Sauce - release driver");
            getAndroidDriver().quit();
        }
    }

    public  AndroidDriver getAndroidDriver() {
        return androidDriver.get();
    }

    @Test
    public void loginToSwagLabsWebTestValid() {
        System.out.println("Sauce - Start loginToSwagLabsTestValid test");
        AndroidDriver driver = getAndroidDriver();
        driver.get(url);
        login("standard_user", "secret_sauce");

        // Verification
        Assert.assertTrue(isOnProductsPage());

    }

    public void login(String user, String pass){
        AndroidDriver driver = getAndroidDriver();

        driver.findElement(usernameInput).sendKeys(user);
        driver.findElement(passwordInput).sendKeys(pass);
        driver.hideKeyboard();

        driver.findElement(submitButton).click();

    }

    public boolean isOnProductsPage() {
        AndroidDriver driver = getAndroidDriver();

        return driver.findElement(productTitle).isDisplayed();
    }

}