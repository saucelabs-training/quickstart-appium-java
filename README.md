# Running Appium and Selenium Tests on Sauce Labs Platform
This project contains TestNG Java examples for two examples of tests that can be run on the Sauce Labs Cloud.

* The first is an Android Appium test on a mobile browser, using the [Swag Labs web app](https://www.saucedemo.com/) testing on an emulator on a Sauce Labs VM
* The Second is an iOS Appium test run against the [Swage Labs (React) mobile app](https://github.com/saucelabs/my-demo-app-rn/releases) testing on a Sauce Labs Real Device

## Important information
### Environment variables for Sauce Labs
The examples in this repository that can run on Sauce Labs use environment variables, make sure you've added the following

    # For Sauce Labs Real devices in the New UI
    export SAUCE_USERNAME=********
    export SAUCE_ACCESS_KEY=*******
    
### Demo app(s)
The Native demo app that has been used for all these tests can be found [here](https://github.com/saucelabs/my-demo-app-rn/releases).
Be aware of the fact that you need the build for the iOS real device. So please check the file you download.

> The advice is to download the files to an `apps` folder in the root of this folder.

### Upload apps to Sauce Storage
* If you want to use iOS real devices and Android real devices in the New Sauce Labs UI you need to upload the apps to the Sauce Storage.
For more information on this step please visit: [Application Storage](https://wiki.saucelabs.com/display/DOCS/Application+Storage).
* In the app capability you must use `storage:<app-id>` or `storage:filename=<file-name>`. For more information on this step please visit: [Application Storage](https://wiki.saucelabs.com/display/DOCS/Application+Storage).
* Change the value of appName in the native apps tests for Android and iOS according to your app name.
### Useful Links 
* How to upload the apps to the Sauce Storage and the app capability: [Application Storage](https://wiki.saucelabs.com/display/DOCS/Application+Storage).
* Appium Capabilities for Real Device Testing: [Appium Capabilities](https://wiki.saucelabs.com/display/DOCS/Appium+Capabilities+for+Real+Device+Testing).
* Sauce Labs Data Center Endpoints: [Data Center EndPoints](https://wiki.saucelabs.com/display/DOCS/Data+Center+Endpoints).
* How to set the pass/fail status of a test: [Annotating Tests with Selenium's JavaScript Executor](https://wiki.saucelabs.com/display/DOCS/Annotating+Tests+with+Selenium%27s+JavaScript+Executor).



## Run Native App tests on Sauce Labs iOS real devices in the Sauce Labs Platform
If you want to run the Native iOS App tests on Sauce Labs real devices then you can run the iOS tests with

    // If using the US DC
    mvn clean install -DtestngXmlFile=appium_ios_rdc_app_test.xml -Dregion=us
    
    // If using the EU DC
    mvn clean install -DtestngXmlFile=appium_ios_rdc_app_test.xml -Dregion=eu
    
The tests will be executed on a iPhone 8.



## Run Web App tests on Sauce Labs Android Emulators
If you want to run the Web App tests on Sauce Labs real Android devices then you can run the web tests with

    // If using the US DC
    mvn clean install -DtestngXmlFile=appium_android_emu_web_test.xml -Dregion=us
    
    // If using the EU DC
    mvn clean install -DtestngXmlFile=appium_android_emu_web_test.xml -Dregion=eu
    
The tests will be executed on Android Emulator, platform version 8.0.

