package Activities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class GoogleKeepActivity {
	AndroidDriver<MobileElement> driver=null;
	WebDriverWait wait=null;
	
	@BeforeClass()
	public void setUp() throws MalformedURLException {
		// Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "RZ8N212SJAL");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.keep");
        caps.setCapability("appActivity", ".activities.BrowseActivity");
        
        //Instantiate Appium driver
        URL appServer=new URL("http://127.0.0.1:4723/wd/hub");
        driver=new AndroidDriver<MobileElement>(appServer,caps);
        wait=new WebDriverWait(driver,10);
	}
	
  @Test
  public void googleKeepActivity() throws InterruptedException {
	  Thread.sleep(2000);
	  String title="Title1";
	  String desc="Description new";
	  driver.findElementById("new_note_button").click();
	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("new_note_button")));
	  driver.findElementById("editable_title").sendKeys(title);
	  driver.findElementById("edit_note_text").sendKeys(desc);
	  driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]").click();
	  
	  String noteXpath="//androidx.cardview.widget.CardView[@content-desc=\""+title+". "+desc+". \"]/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout";
	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath(noteXpath)));
	  Assert.assertTrue(driver.findElementByXPath(noteXpath).isDisplayed());
	  
	  
  }
  
  @AfterClass()
  public void closeDriver() {
  	driver.quit();
  }
}
