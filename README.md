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
The Native demo app that has been used for the iOS test can be found [here](https://github.com/saucelabs/my-demo-app-rn/releases).
Be aware of the fact that you need the build for the iOS real device. So please check the file you download.

> The advice is to download the files to an `apps` folder in the root of this folder.

### Upload apps to Sauce Storage
You can download the apps from [here](https://github.com/saucelabs/my-demo-app-rn/releases/). Make sure you rename the app to:
- iOS Real Devices: `iOS-Real-Device-MyRNDemoApp.*.*.*-*.ipa` => `iOS-Real-Device-MyRNDemoApp.ipa`

And manually upload them to the preferred Data Center, see [this](https://docs.saucelabs.com/mobile-apps/live-testing/live-mobile-app-testing/#uploading-an-app) for the instructions.

### Useful Links 
* How to upload the apps to the Sauce Storage and the app capability: [Application Storage](https://docs.saucelabs.com/mobile-apps/app-storage/).
* Appium Capabilities for Real Device Testing: [Appium Capabilities](https://docs.saucelabs.com/dev/test-configuration-options/#mobile-appium-capabilities).
* Sauce Labs Data Center Endpoints: [Data Center EndPoints](https://docs.saucelabs.com/basics/data-center-endpoints/).
* How to set the pass/fail status of a test: [Annotating Tests with Selenium's JavaScript Executor](https://docs.saucelabs.com/basics/test-config-annotation/test-annotation/#selenium-javascript-executor).

## Run Native App tests on Sauce Labs iOS real devices in the Sauce Labs Platform
If you want to run the Native iOS App tests on Sauce Labs real devices then you can run the iOS tests with

    // If using the US DC
    mvn clean install -DtestngXmlFile=appium_ios_rdc_app_test.xml -Dregion=us
    
    // If using the EU DC
    mvn clean install -DtestngXmlFile=appium_ios_rdc_app_test.xml -Dregion=eu
    
The tests will be executed on a any available iPhone, platform version 15 or 16.

## Run Web App tests on Sauce Labs Android Emulators
If you want to run the Web App tests on Sauce Labs real Android devices then you can run the web tests with

    // If using the US DC
    mvn clean install -DtestngXmlFile=appium_android_emu_web_test.xml -Dregion=us
    
    // If using the EU DC
    mvn clean install -DtestngXmlFile=appium_android_emu_web_test.xml -Dregion=eu
    
The tests will be executed on Android Emulator, platform version 13.0.

