package Activities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class GoogleChromeActivity {
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
        
        //Instantiate Appium driver
        URL appServer=new URL("http://127.0.0.1:4723/wd/hub");
        driver=new AndroidDriver<MobileElement>(appServer,caps);
        wait=new WebDriverWait(driver,10);
	}
  
	@Test
	public void googleChromeActivity() throws InterruptedException {
		Thread.sleep(5000);
		driver.get("https://www.training-support.net/selenium");
		MobileElement ele1=scrollUntilElementFound();		
		ele1.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.EditText[contains(@resource-id,\"taskInput\")]")));
		driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,\"taskInput\")]").sendKeys("Add tasks to list");
		driver.findElementByXPath("//android.view.View[@resource-id=\"tasksCard\"]/android.view.View/android.widget.Button").click();
		driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,\"taskInput\")]").sendKeys("Get number of tasks");
		driver.findElementByXPath("//android.view.View[@resource-id=\"tasksCard\"]/android.view.View/android.widget.Button").click();
		driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,\"taskInput\")]").sendKeys("Clear the list");
		driver.findElementByXPath("//android.view.View[@resource-id=\"tasksCard\"]/android.view.View/android.widget.Button").click();
		List<MobileElement> task=driver.findElementsByXPath("//android.view.View[@resource-id=\"tasksList\"]/android.view.View/android.widget.TextView");
		for(int i=0;i<task.size();i++) {
			task.get(i).click();
		}
		List<MobileElement> clearEle=driver.findElementsByXPath("//android.view.View[@resource-id=\"tasksCard\"]/android.view.View/android.widget.TextView");
		for(int i=0;i<clearEle.size();i++) {
			if(clearEle.get(i).getText().trim().equalsIgnoreCase("Clear List")) {
				clearEle.get(i).click();
			}
		}
		try {
			MobileElement ele2=driver.findElementByXPath("//android.view.View[@resource-id=\"tasksList\"]");
			Assert.assertTrue(false);
		}catch (NoSuchElementException e) {
			Assert.assertTrue(true);
		}
		
	}
	public MobileElement scrollUntilElementFound() {
		MobileElement ele=null;
		boolean flag=false;
		while(!flag) {
			try {
				driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"To-Do List\").instance(0))");
			}catch(Exception e) {
		         System.out.println("****Element not yet found***");
		    }
			try {
				List<MobileElement> eleList=driver.findElementsByXPath("//android.widget.TextView");
				for(int i=0;i<eleList.size();i++) {
					if(eleList.get(i).getText().equalsIgnoreCase("To-Do List")) {
						System.out.println("****Element found Successfully***");
						ele= eleList.get(i);
						flag=true;
						break;
					}
				}
			}catch(Exception e) { 
				flag=false; 
			}
		}
		return ele;
	}
	
	@AfterClass()
	public void closeDriver() {
	  	driver.quit();
	}
}
