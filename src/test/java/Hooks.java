import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

/**
 * Created by vsampathkumar on 11/30/16.
 */
public class Hooks {

    public static AndroidDriver driver;

    @Before
    public void setUp() throws Exception {

        System.out.println("Hi");
        DesiredCapabilities capabilities = new DesiredCapabilities();


        capabilities.setCapability("BROWSER_NAME", "Android");
        capabilities.setCapability("appium-version", "1.0");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "5.0");
        capabilities.setCapability("deviceName", "Android");
        capabilities.setCapability("app", "/Users/aartichella/Library/Android/sdk/platform-tools/flipkart.apk");
        capabilities.setCapability("appPackage", "com.flipkart.android");
        capabilities.setCapability("appActivity", "com.flipkart.android.SplashActivity");

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
      //  driver.setConnection(Connection.ALL);

    }

    @After
    public void tearDown() throws Exception
    {
        driver.quit();
    }
}
