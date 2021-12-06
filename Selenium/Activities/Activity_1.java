import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_1 {

	public static void main(String[] args) {
		//Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
		//WebDriver driver = new ChromeDriver();
        //Open the browser
        driver.get("https://www.training-support.net");
        
        //Perform testing and assertions
        
        //Close the browser
        driver.close();

	}

}
