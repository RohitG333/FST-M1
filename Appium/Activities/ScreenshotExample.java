package examples;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ScreenshotExample {
	AndroidDriver<MobileElement> driver=null;
	WebDriverWait wait=null;
	
	@BeforeClass()
	public void setUp() throws MalformedURLException {
		// Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "RZ8N212SJAL");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.sec.android.app.popupcalculator");
        caps.setCapability("appActivity", ".Calculator");
        
        //Instantiate Appium driver
        URL appServer=new URL("http://127.0.0.1:4723/wd/hub");
        driver=new AndroidDriver<MobileElement>(appServer,caps);
        wait=new WebDriverWait(driver,10);
	}
    @Test
    public void add() throws IOException {
    	driver.findElementById("calc_keypad_btn_07").click();
    	driver.findElementByAccessibilityId("Plus").click();
    	driver.findElementByXPath("//android.widget.Button[@content-desc='9']").click();
    	driver.findElementById("calc_keypad_btn_equal").click();
    	wait.until(ExpectedConditions.textToBePresentInElement(driver.findElementById("calc_edt_formula"), "16"));
    	Assert.assertEquals(driver.findElementById("calc_edt_formula").getText(), "16");
    	File screenShotName;
        // Take screenshot
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
 
        // This specifies the location the screenshot will be saved
        screenShotName = new File("src/test/resources/screenshot.jpg");
 
        // This will copy the screenshot to the file created
        FileUtils.copyFile(scrFile, screenShotName);
 
        //Set filepath for image
        String filePath = "../"+screenShotName.toString();
        
        //Set image HTML in the report
        String path = "<img src='"+ filePath +"'/>";
        
        //Show image in report
        Reporter.log(path);
    }
    
    @AfterClass()
    public void closeDriver() {
    	driver.quit();
    }
}
