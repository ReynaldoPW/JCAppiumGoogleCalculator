package com.juaracoding;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class GoogleCalculatorTest {
    public static void main(String[] args) throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        caps.setCapability(MobileCapabilityType.UDID,"J8AXGF01D5147RP");
        caps.setCapability(MobileCapabilityType.VERSION,"9");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"ASUS X00TD");
        caps.setCapability("appPackage","com.google.android.calculator");
        caps.setCapability("appActivity","com.android.calculator2.Calculator");

        //Instantiate Android Driver
        AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);

        //perform addition operation
        MobileElement btn1 = driver.findElementById("com.google.android.calculator:id/digit_1");
        MobileElement btn2 = driver.findElementById("com.google.android.calculator:id/digit_2");
        MobileElement btn3 = driver.findElementById("com.google.android.calculator:id/digit_3");
        MobileElement btnPlus =driver.findElementByAccessibilityId("tambah");
        MobileElement btnEquals = driver.findElementByAccessibilityId("sama dengan");

        btn1.click();
        btnPlus.click();
        btn2.click();
        btnEquals.click();

        String result =driver.findElementById("com.google.android.calculator:id/result_final").getText();
        if(result.equals("3")){
            System.out.println("Addition Test Passed");
        }else {
            System.out.println("Addition Test Failed");
        }

        //perform multiplication operation
        MobileElement btnMultiply = driver.findElementByAccessibilityId("kali");
        MobileElement btn4 = driver.findElementById("com.google.android.calculator:id/digit_4");

        btn3.click();
        btnMultiply.click();
        btn4.click();
        btnEquals.click();

        result = driver.findElementById("com.google.android.calculator:id/result_final").getText();
        if(result.equals("12")){
            System.out.println("Multiplication Test Passed");
        }else {
            System.out.println("Multiplication Test Failed");
        }

        //close app
        driver.quit();

    }
}