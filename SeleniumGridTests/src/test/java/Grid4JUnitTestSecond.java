import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

@TestInstance (Lifecycle.PER_CLASS)
public class Grid4JUnitTestSecond {
	
	 private WebDriver driver;
	 String baseURL, nodeURL;
	 protected ThreadLocal<RemoteWebDriver> threadDriver = null;

	 @BeforeAll
	 public void setUp() throws MalformedURLException {
		 baseURL="https://www.calculator.net/triangle-calculator.html";
		 nodeURL="http://localhost:4444";
	 }
	 @AfterEach
	 public void tearDown() {
		 driver.close();
	 }
	 @Test
	 public void test1() throws Throwable {
		 System.out.println("Executing on FireFox");
		 DesiredCapabilities caps = new DesiredCapabilities();
		 caps.setBrowserName("firefox");
		 caps.setPlatform(Platform.WIN10);
		 driver = new RemoteWebDriver(new URL(nodeURL), caps);
		 driver.get(baseURL);
		 String appTitle = driver.getTitle();
		 assertEquals("Triangle Calculator", appTitle);
	 }
	  @Test
	  public void test2() throws Throwable {
		  System.out.println("Executing on CHROME");
		  DesiredCapabilities caps = new DesiredCapabilities();
		  caps.setBrowserName("chrome");
		  caps.setPlatform(Platform.WIN10);
		  driver = new RemoteWebDriver(new URL(nodeURL), caps);
		  driver.get(baseURL);
		  String appTitle = driver.getTitle();
		  assertEquals("Triangle Calculator", appTitle);
	  }
}
