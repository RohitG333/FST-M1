package examples;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity2 {
	AndroidDriver<MobileElement> driver=null;
	WebDriverWait wait=null;
	
	@BeforeClass()
	public void setUp() throws MalformedURLException {
		// Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "RZ8N212SJAL");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        caps.setCapability("noReset", true);
        
        //Instantiate Appium driver
        URL appServer=new URL("http://127.0.0.1:4723/wd/hub");
        driver=new AndroidDriver<MobileElement>(appServer,caps);
        wait=new WebDriverWait(driver,10);
	}
	
	@Test
    public void testSearchAppium() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
        driver.get("https://www.training-support.net/");
        String pageTitle = driver.findElementByXPath("//*[@text='Training Support']").getText();
        System.out.println("Title on Homepage: " + pageTitle);
 
        MobileElement aboutButton = driver.findElementByXPath("//*[@content-desc='About Us']");
        aboutButton.click();
 
        String newPageTitle = driver
                .findElementByXPath("//*[@text='About Us']")
                .getText();
 
        System.out.println("Title on new page: " + newPageTitle);
 
        // Assertions
        Assert.assertEquals(pageTitle, "Training Support");
        Assert.assertEquals(newPageTitle, "About Us");
    }
	
    @AfterClass()
    public void closeDriver() {
    	driver.quit();
    }
}
