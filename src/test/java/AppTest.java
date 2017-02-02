import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.poi.ss.formula.functions.T;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.FindBy;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppTest {



	AndroidDriver driver;
	WebElementPaths utils;
	HashMap<String, Integer> select = new HashMap <String ,Integer>();
	HashMap<String, Integer> fav = new HashMap <String ,Integer>();
	
TestUtil readInput=new TestUtil();

	String inputArray[]=new String[4];




	@Given("Open Flipkart App")
	public void openApp() throws InterruptedException {

		try {
			driver = Hooks.driver;

			utils = new WebElementPaths(driver);

		} catch (Exception e) {
			e.printStackTrace();
			driver.quit();

		}

	}

	@Then("Search Iphone in Search Box")
	public void SearchIphonev() throws InterruptedException {

		try {

			utils.clickButtonSkip();

			//driver.findElement(By.id("search_widget_textbox")).clear();
			utils.clickSearchWidget();

			//utils.inputSearchTextbox(RandomStringUtils.randomAlphabetic(60));

			driver.findElement(By.id("search_autoCompleteTextView")).click();

			driver.findElement(By.id("search_autoCompleteTextView")).sendKeys("Iphone");

			utils.clickSearchItem();

			utils.clickSelectItem();

		} catch (Exception e) {
			e.printStackTrace();
			driver.quit();

		}

	}


	@Then("Search Iphone with Invalid Search")
	public void SearchIphone() throws InterruptedException {

		try {

			utils.clickButtonSkip();

			//driver.findElement(By.id("search_widget_textbox")).clear();
			utils.clickSearchWidget();

			//utils.inputSearchTextbox(RandomStringUtils.randomAlphabetic(60));

			driver.findElement(By.id("search_autoCompleteTextView")).click();

			driver.findElement(By.id("search_autoCompleteTextView")).sendKeys("uguygyuvuv");
			driver.pressKeyCode(66);

			Thread.sleep(5000);

			String title=driver.findElement(By.id("title")).getText();

			Assert.assertEquals(title,"Sorry, no results found");


		} catch (Exception e) {
			e.printStackTrace();
			driver.quit();

		}

	}

	@Then("Check Iphone Option")
	public void checkIphone() throws InterruptedException {

		try {
			utils.clickBuyNow();

			String obtainedText = "Please provide following information";
			String expectedText = utils.getWelcomeDesc();
			System.out.println(expectedText);
			Assert.assertEquals("Text Mismatch", obtainedText, expectedText);
			driver.quit();

		} catch (Exception e) {
			e.printStackTrace();
			driver.quit();

		}

	}

	@Then("Adding items to cart")
	public void addItems() throws InterruptedException {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 100);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn_skip")));
			driver.findElement(By.id("btn_skip")).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_widget_textbox")));


			Thread.sleep(4000);

			//		driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'com.flipkart.android:id/announcement_title') and @text='Shop By Categories']")).click();






			driver.findElement(By.xpath("//android.widget.ImageView[contains(@index,'2')]")).click();


			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[contains(@resource-id,'com.flipkart.android:id/flyout_parent_title') and @text='Offer Zone']")));
//click offer zone
			driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'com.flipkart.android:id/flyout_parent_title') and @text='Offer Zone']")).click();
//select item
			Thread.sleep(4000);
			driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Mobiles & Tablets')]")).click();


			Thread.sleep(4000);
			driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Now')]")).click();
			Thread.sleep(4000);

			driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Exchange Offer')]")).click();
			Thread.sleep(4000);

			driver.findElement(By.id("product_buynow_1")).click();
			Thread.sleep(4000);
			String obtainedText = "Please provide following information";

			String expectedText = driver.findElement(By.id("tv_welcomestring_description")).getText();

			Assert.assertEquals("Text Mismatch", obtainedText, expectedText);

			Thread.sleep(4000);
			driver.findElement(By.xpath("//android.widget.ImageButton[contains(@content-desc,'Back button')]")).click();
//back button

			driver.findElement(By.id("search_icon")).click();


			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_autoCompleteTextView")));
			driver.findElement(By.id("search_autoCompleteTextView")).sendKeys("Iphone");
			//driver.findElement(By.id("search_autoCompleteTextView"));
			//	element.se


			Thread.sleep(3000);
			driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'com.flipkart.android:id/incorrect_login_text') and @text='iphone 7 in Mobiles']")).click();
//click search item


			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[contains(@resource-id,'com.flipkart.android:id/product_list_product_item_main_text') and @text='Apple iPhone 7 (Jet Black, 128 GB)']")));
			driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'com.flipkart.android:id/product_list_product_item_main_text') and @text='Apple iPhone 7 (Jet Black, 128 GB)']")).click();
//select item
			//driver.findElement(By.id("search_widget_textbox")).sendKeys(Keys.ENTER);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("product_buynow_1")));

			driver.findElement(By.id("product_buynow_1")).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tv_welcomestring_description")));

			String obtainedText1 = "Please provide following information";

			String expectedText1 = driver.findElement(By.id("tv_welcomestring_description")).getText();

			System.out.println(expectedText);

			Assert.assertEquals("Text Mismatch", obtainedText1, expectedText1);



		} catch (Exception e) {
			e.printStackTrace();
			driver.quit();

		}

	}



	@Then("Adding items using navigation bar")
	public void addItemsUsingNavigation() throws InterruptedException {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 100);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn_skip")));
			driver.findElement(By.id("btn_skip")).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_widget_textbox")));


			Thread.sleep(4000);

			//		driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'com.flipkart.android:id/announcement_title') and @text='Shop By Categories']")).click();






			driver.findElement(By.xpath("//android.widget.ImageView[contains(@index,'2')]")).click();


			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[contains(@resource-id,'com.flipkart.android:id/flyout_parent_title') and @text='Offer Zone']")));
//click offer zone
			driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'com.flipkart.android:id/flyout_parent_title') and @text='Offer Zone']")).click();
//select item
			Thread.sleep(4000);

		} catch (Exception e) {
			e.printStackTrace();
			driver.quit();

		}

	}


	@Then("Check whether navigation worked")
	public void checkNavigation() throws InterruptedException {

		try {

			//Assert.ass(driver.getPageSource().toString(),"doesn't match any account");

			System.out.println(driver.getPageSource());
			if(driver.getPageSource().contains("Deals of the day"))
				Assert.assertTrue(true);
			else
				Assert.assertTrue(false);


			driver.quit();

		} catch (Exception e) {
			e.printStackTrace();
			driver.quit();

		}

	}


	@Then("Check items in cart")
	public void checkItems() throws InterruptedException {

		try {
			driver.findElement(By.xpath("//android.widget.ImageButton[contains(@content-desc,'Back button')]")).click();
//back button

			driver.findElement(By.id("cart_bg_icon")).click();

			Thread.sleep(3000);

			String count =driver.findElement(By.id("title_action_bar")).getText();


			System.out.println("count number"+count);
			Assert.assertTrue(count.contains("2"));

			driver.quit();


		} catch (Exception e) {
			e.printStackTrace();
			driver.quit();

		}

	}



	@Then("Enter Invalid Login details")
	public void inputInvalidLogin() throws InterruptedException {

		try {

			WebDriverWait wait = new WebDriverWait(driver, 100);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(("com.flipkart.android:id/btn_mlogin"))));
			driver.findElement(By.id(("com.flipkart.android:id/btn_mlogin"))).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(("com.flipkart.android:id/btn_login_facebook"))));
			driver.findElement(By.id(("com.flipkart.android:id/btn_login_facebook"))).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(("android.webkit.WebView"))));
			driver.context("WEBVIEW");
			WebElement element1=driver.findElement(By.name("email"));
			element1.sendKeys("xyz");
			WebElement element2=driver.findElement(By.name("pass"));
			element2.sendKeys("pass");
			WebElement element3=driver.findElement(By.name("login"));
			element3.submit();


		} catch (Exception e) {
			e.printStackTrace();
			driver.quit();

		}

	}

	@Then("Check whether user is not logged in")
	public void checkUser() throws InterruptedException {

		try {


			if(driver.getPageSource().contains("match any account"))
				Assert.assertTrue(true);
			else
				Assert.assertTrue(false);


			driver.quit();


		} catch (Exception e) {
			e.printStackTrace();
			driver.quit();

		}

	}


	@Then("Enter valid Login details")
	public void inputValidLogin() throws InterruptedException {

		try {

			WebDriverWait wait1 = new WebDriverWait(driver, 100);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id(("com.flipkart.android:id/btn_mlogin"))));
			driver.findElement(By.id(("com.flipkart.android:id/btn_mlogin"))).click();

			Thread.sleep(1000);
			WebElement element4=driver.findElement(By.id(("com.flipkart.android:id/mobileNo")));
			element4.clear();
			element4.sendKeys("9003285458");


			WebElement element5=driver.findElement(By.id(("com.flipkart.android:id/et_password")));
			element5.sendKeys("1234");




		} catch (Exception e) {
			e.printStackTrace();
			driver.quit();

		}

	}
	@Then("Enter wrong Login details \"(.+)\"")
	public void inputWrongLogin(String input) throws InterruptedException {

		try {

		inputArray=readInput.readFromExcel(Integer.parseInt(input));

			WebDriverWait wait1 = new WebDriverWait(driver, 100);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id(("com.flipkart.android:id/btn_mlogin"))));
			driver.findElement(By.id(("com.flipkart.android:id/btn_mlogin"))).click();

			Thread.sleep(1000);
			WebElement element4=driver.findElement(By.id(("com.flipkart.android:id/mobileNo")));
			element4.clear();
			element4.sendKeys(inputArray[0]);


			WebElement element5=driver.findElement(By.id(("com.flipkart.android:id/et_password")));
			element5.sendKeys(inputArray[1]);




		} catch (Exception e) {
			e.printStackTrace();
			driver.quit();

		}

	}

	@Then("Check whether user is logged in")
	public void checkUserLogin() throws InterruptedException {

		try {

			driver.findElement(By.id("com.flipkart.android:id/btn_mlogin")).click();

			Thread.sleep(10000);
			if(driver.getPageSource().contains("Flipkart"))
				Assert.assertTrue(true);
			else
				Assert.assertTrue(false);
			Thread.sleep(10000);
			driver.quit();


		} catch (Exception e) {
			e.printStackTrace();
			driver.quit();

		}

	}
	@Then("Check whether error message displayed")
	public void checkErrorLogin() throws InterruptedException {

		try {


			driver.findElement(By.id("com.flipkart.android:id/btn_mlogin")).click();
			Thread.sleep(3000);
		String text=	driver.findElement(By.id("pageLevelError")).getText();

			System.out.println(text);
		Assert.assertEquals("Invalid email id / mobile number",text);

			Thread.sleep(10000);
			driver.quit();


		} catch (Exception e) {
			e.printStackTrace();
			driver.quit();

		}

	}






	@Given("Test1 - Buy now")
	public void openActivity() throws InterruptedException {

		try {
			driver = Hooks.driver;

			utils = new WebElementPaths(driver);




		} catch (Exception e) {
			e.printStackTrace();
			driver.quit();

		}

	}

		@Given("Test2 - BuyLapTop")
		public void buyLaptop() throws InterruptedException{

			try {

				driver = Hooks.driver;

				AndroidElement element = new AndroidElement();

				WebDriverWait wait = new WebDriverWait(driver, 100);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn_skip")));
				driver.findElement(By.id("btn_skip")).click();

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_widget_textbox")));


				Thread.sleep(4000);

		//		driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'com.flipkart.android:id/announcement_title') and @text='Shop By Categories']")).click();






				driver.findElement(By.xpath("//android.widget.ImageView[contains(@index,'2')]")).click();


				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[contains(@resource-id,'com.flipkart.android:id/flyout_parent_title') and @text='Offer Zone']")));
//click offer zone
				driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'com.flipkart.android:id/flyout_parent_title') and @text='Offer Zone']")).click();
//select item
				Thread.sleep(4000);
				driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Mobiles & Tablets')]")).click();


				Thread.sleep(4000);
				driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Now')]")).click();
				Thread.sleep(4000);

				driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Exchange Offer')]")).click();
				Thread.sleep(4000);

				driver.findElement(By.id("product_buynow_1")).click();
				Thread.sleep(4000);
				String obtainedText = "Please provide following information";

				String expectedText = driver.findElement(By.id("tv_welcomestring_description")).getText();

				Assert.assertEquals("Text Mismatch", obtainedText, expectedText);

				Thread.sleep(4000);
				driver.findElement(By.xpath("//android.widget.ImageButton[contains(@content-desc,'Back button')]")).click();
//back button

				driver.findElement(By.id("search_icon")).click();


				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_autoCompleteTextView")));
				driver.findElement(By.id("search_autoCompleteTextView")).sendKeys("Iphone");
				//driver.findElement(By.id("search_autoCompleteTextView"));
				//	element.se


				Thread.sleep(3000);
				driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'com.flipkart.android:id/incorrect_login_text') and @text='iphone 7 in Mobiles']")).click();
//click search item


				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[contains(@resource-id,'com.flipkart.android:id/product_list_product_item_main_text') and @text='Apple iPhone 7 (Jet Black, 128 GB)']")));
				driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'com.flipkart.android:id/product_list_product_item_main_text') and @text='Apple iPhone 7 (Jet Black, 128 GB)']")).click();
//select item
				//driver.findElement(By.id("search_widget_textbox")).sendKeys(Keys.ENTER);

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("product_buynow_1")));

				driver.findElement(By.id("product_buynow_1")).click();

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tv_welcomestring_description")));

				String obtainedText1 = "Please provide following information";

				String expectedText1 = driver.findElement(By.id("tv_welcomestring_description")).getText();

				System.out.println(expectedText);

				Assert.assertEquals("Text Mismatch", obtainedText1, expectedText1);


				driver.findElement(By.xpath("//android.widget.ImageButton[contains(@content-desc,'Back button')]")).click();
//back button

				driver.findElement(By.id("cart_bg_icon")).click();

				Thread.sleep(3000);

		String count =driver.findElement(By.id("title_action_bar")).getText();


				System.out.println("count number"+count);
				Assert.assertTrue(count.contains("2"));

//back button

//select item
//
//
//
//
//
//				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[contains(@text,'Under')]")));
//
//
//				driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Under')]")).click();
//
//				//driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.bitbar.testdroid:id/editText1']"));
//				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id='com.flipkart.android:id/product_addtowishlist_1']")));
//
//				driver.findElement(By.xpath("//android.widget.TextView[@resource-id,'com.flipkart.android:id/product_addtowishlist_1']")).click();



//				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("announcement_title")));
//				driver.findElement(By.xpath("announcement_title")).click();
////click search item



				Thread.sleep(10000);
				driver.quit();
			}
			catch (Exception e) {
				e.printStackTrace();
				driver.quit();

			}

//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.flipkart.android:id/btn_skip")));
//		driver.findElement(By.id("com.flipkart.android:id/btn_skip")).click();
//
//
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(("android.widget.ImageButton"))));
//		driver.findElement(By.className(("android.widget.ImageButton"))).click();
//
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(("SmartWatches & Wearables"))));
//		driver.findElement(By.name(("SmartWatches & Wearables"))).click();
//
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(("Smart Watch"))));
//		driver.findElement(By.name(("Smart Watch"))).click();
//
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(("Asus ZenWatch 2 Silver Case with Rubber Strap Sliver/rubber taupe Smartwatch"))));
//		driver.findElement(By.name(("Asus ZenWatch 2 Silver Case with Rubber Strap Sliver/rubber taupe Smartwatch"))).click();
//
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(("BUY NOW"))));
//		driver.findElement(By.name(("BUY NOW"))).click();
//
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Deny")));
//		driver.findElement(By.name("Deny")).click();
//
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(("android.widget.ImageButton"))));
//		driver.findElement(By.className("android.widget.ImageButton")).click();
//
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(("com.flipkart.android:id/cart_count"))));
//		System.out.println("Items in the cart are:"+driver.findElement(By.id("com.flipkart.android:id/cart_count")).getText());
//



	}
	


	
	
}
