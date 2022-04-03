import org.testng.annotations.Test;
import java.net.MalformedURLException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
 
public class Grid4TestNG {
     
    String baseURL, nodeURL;
    protected ThreadLocal<RemoteWebDriver> threadDriver = null;
 
    @BeforeClass
    public void setUp() throws MalformedURLException {
        baseURL="https://tusur.ru";
        nodeURL = "http://localhost:4444";
    }
                 
    @Test
    public void test1() throws Throwable {
    	System.out.println("Executing on FireFox");
    	System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
    	FirefoxOptions options = new FirefoxOptions();
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
        caps.setBrowserName("firefox");
        caps.setPlatform(Platform.WIN10);
        FirefoxDriver driver = new FirefoxDriver(options);
        driver.get(baseURL);
        String appTitle = driver.getTitle();
        Assert.assertEquals("Томский государственный университет систем управления и радиоэлектроники", appTitle);
        driver.quit();
    }
    @Test
    public void test2() throws Throwable {
    	System.out.println("Executing on CHROME");
    	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
    	ChromeOptions options = new ChromeOptions();
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(ChromeOptions.CAPABILITY, options);
        caps.setBrowserName("chrome");
        caps.setPlatform(Platform.WIN10);
        ChromeDriver driver = new ChromeDriver(options);
        driver.get(baseURL);
        String appTitle = driver.getTitle();
        Assert.assertEquals("Томский государственный университет систем управления и радиоэлектроники", appTitle);
        driver.quit();
    }
}