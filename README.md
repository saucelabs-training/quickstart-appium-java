# Running Appium and Selenium Tests on Sauce Labs Platform
This project contains Java examples for running Appium tests on Sauce Labs platform:  
On Real Devices:  

- [Native Android App on real devices](#run-native-app-tests-on-sauce-labs-android-real-devices-in-the-sauce-labs-platform)
- [Web App on real Android devices](#run-web-app-tests-on-sauce-labs-android-real-devices-in-the-sauce-labs-platform)
- [Native iOS App on real devices](#run-native-app-tests-on-sauce-labs-ios-real-devices-in-the-sauce-labs-platform)
- [Web App on real iOS devices](#run-web-app-tests-on-sauce-labs-ios-real-devices-in-the-sauce-labs-platform)

On Simulators and Emulators:  
- [Native Android App on Emulators](#run-native-app-tests-on-sauce-labs-android-emulators)
- [Web App on Android Emulators](#run-web-app-tests-on-sauce-labs-android-emulators)
- [Native iOS App on Simulators](#run-native-app-tests-on-sauce-labs-ios-simulators)
- [Web App on iOS Simulators](#run-web-app-tests-on-sauce-labs-ios-simulators)

On Virtual Machine (VM):  
- [Run on Sauce VM](#run-browser-on-Sauce-virtual-machine)


The framework uses testNG xml file for parallel executions. All the tests in the same class will run in parallel on different devices 
## Important information
### Environment variables for Sauce Labs
The examples in this repository that can run on Sauce Labs use environment variables, make sure you've added the following

    # For Sauce Labs Real devices in the New UI
    export SAUCE_USERNAME=********
    export SAUCE_ACCESS_KEY=*******
    
### Demo app(s)
The Native demo app that has been used for all these tests can be found [here](https://github.com/saucelabs/sample-app-mobile/releases).
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
## Run Native App tests on Sauce Labs Android real devices in the Sauce Labs Platform
If you want to run the Native Android App tests on Sauce Labs real Android devices then you can run the Android tests with

    // If using the US DC
    mvn clean install -DtestngXmlFile=appium_android_rdc_app_test.xml -Dregion=us
    
    // If using the EU DC
    mvn clean install -DtestngXmlFile=appium_android_rdc_app_test.xml -Dregion=eu
    
The tests will be executed on an any available Samsung device.

> NOTE: Make sure you are in the folder `SauceAppiumSample` when you execute this command

## Run Web App tests on Sauce Labs Android real devices in the Sauce Labs Platform
If you want to run the Web App tests on Sauce Labs real Android devices then you can run the web tests with

    // If using the US DC
    mvn clean install -DtestngXmlFile=appium_android_rdc_web_test.xml -Dregion=us
    
    // If using the EU DC
    mvn clean install -DtestngXmlFile=appium_android_rdc_web_test.xml -Dregion=eu
    
The tests will be executed on any available Samsung device.

> NOTE: Make sure you are in the folder `SauceAppiumSample` when you execute this command

## Run Native App tests on Sauce Labs iOS real devices in the Sauce Labs Platform
If you want to run the Native iOS App tests on Sauce Labs real devices then you can run the iOS tests with

    // If using the US DC
    mvn clean install -DtestngXmlFile=appium_ios_rdc_app_test.xml -Dregion=us
    
    // If using the EU DC
    mvn clean install -DtestngXmlFile=appium_ios_rdc_app_test.xml -Dregion=eu
    
The tests will be executed on a iPhone 8.
> NOTE: Make sure you are in the folder `SauceAppiumSample` when you execute this command

## Run Web App tests on Sauce Labs iOS real devices in the Sauce Labs Platform
If you want to run the Web App tests on Sauce Labs real iOS devices then you can run the web tests with

    // If using the US DC
    mvn clean install -DtestngXmlFile=appium_ios_rdc_web_test.xml -Dregion=us
    
    // If using the EU DC
    mvn clean install -DtestngXmlFile=appium_ios_rdc_web_test.xml -Dregion=eu
    
The tests will be executed on a iPhone 8.
> NOTE: Make sure you are in the folder `SauceAppiumSample` when you execute this command

## Run Native App tests on Sauce Labs Android Emulators
If you want to run the Native Android App tests on Sauce Labs Android Emulator devices then you can run the Android tests with

    // If using the US DC
    mvn clean install -DtestngXmlFile=appium_android_emu_app_test.xml -Dregion=us
    
    // If using the EU DC
    mvn clean install -DtestngXmlFile=appium_android_emu_app_test.xml -Dregion=eu
    
The tests will be executed on Android Emulator, platform version 8.0.

> NOTE: Make sure you are in the folder `SauceAppiumSample` when you execute this command

## Run Web App tests on Sauce Labs Android Emulators
If you want to run the Web App tests on Sauce Labs real Android devices then you can run the web tests with

    // If using the US DC
    mvn clean install -DtestngXmlFile=appium_android_emu_web_test.xml -Dregion=us
    
    // If using the EU DC
    mvn clean install -DtestngXmlFile=appium_android_emu_web_test.xml -Dregion=eu
    
The tests will be executed on Android Emulator, platform version 8.0.

> NOTE: Make sure you are in the folder `SauceAppiumSample` when you execute this command

## Run Native App tests on Sauce Labs iOS Simulators
If you want to run the Native iOS App tests on Sauce Labs Simulator devices then you can run the iOS tests with

    // If using the US DC
    mvn clean install -DtestngXmlFile=appium_ios_sim_app_test.xml -Dregion=us
    
    // If using the EU DC
    mvn clean install -DtestngXmlFile=appium_ios_sim_app_test.xml -Dregion=eu
    
The tests will be executed on a iPhone 8 Simulator.
> NOTE: Make sure you are in the folder `SauceAppiumSample` when you execute this command

## Run Web App tests on Sauce Labs iOS Simulators
If you want to run the Web App tests on Sauce Labs iOS Simulator devices then you can run the web tests with

    // If using the US DC
    mvn clean install -DtestngXmlFile=appium_ios_sim_web_test.xml -Dregion=us
    
    // If using the EU DC
    mvn clean install -DtestngXmlFile=appium_ios_sim_web_test.xml -Dregion=eu
    
The tests will be executed on a iPhone 8 Simulator.
> NOTE: Make sure you are in the folder `SauceAppiumSample` when you execute this command

## Run Browser On Sauce Virtual Machine
If you want to run the Web App tests on Sauce Labs VM then you can run the web tests with

    // If using the US DC
    mvn clean install -DtestngXmlFile=web_desktop_test.xml -Dregion=us
    
    // If using the EU DC
    mvn clean install -DtestngXmlFile=web_desktop_test.xml -Dregion=eu
    
The tests will be executed on Windows 10, latest version of Chrome.
> NOTE: Make sure you are in the folder `SauceAppiumSample` when you execute this command
