package appiumTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import org.testng.Assert;


public class AndroidCalcTest {
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp() throws MalformedURLException{
		//Capabilities
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
		capabilities.setCapability(CapabilityType.VERSION, "4.4.2");
		capabilities.setCapability("deviceName", "LGD410cab04cbb");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.android.calculator2");
		capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
		
		//Driver
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void end(){
		driver.quit();
	}
	
	@Test
	public void ValuePlusValueTest(){
		String expectedResult = "40";
		driver.findElement(By.id("com.android.calculator2:id/allClear")).click();
		driver.findElement(By.id("com.android.calculator2:id/digit5")).click();
		driver.findElement(By.id("com.android.calculator2:id/mul")).click();
		driver.findElement(By.id("com.android.calculator2:id/digit8")).click();
		driver.findElement(By.id("com.android.calculator2:id/equal")).click();
		
		String result = driver.findElement(By.id("com.android.calculator2:id/display_Res_Text")).getText();
		System.out.println(result);
		
		Assert.assertTrue(result.contains(expectedResult));
	}

}
