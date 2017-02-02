import io.appium.java_client.android.AndroidDriver;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;



import cucumber.api.CucumberOptions;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

@RunWith(Cucumber.class)
@CucumberOptions(
        //tags = "@Valid_Login",
        features={"/Users/aartichella/Desktop/yatraAppTes/src/main/resources/testCase.feature"})
//		"src/main/resource/com/apple/tesla/PeopleServiceTest/actionTest/classes/gradeBrowse.feature"})


public class TestRunner {


}
