import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementPaths {
	
	WebDriver driver;
	
	
	@FindBy(id="btn_skip")
	public static WebElement button_skip;

	@FindBy(id="search_widget_textbox")
	public static WebElement button_searchWidget;

	@FindBy(id="search_autoCompleteTextView")
	public static WebElement button_autocomplete;

	@FindBy(xpath="//android.widget.TextView[contains(@resource-id,'com.flipkart.android:id/incorrect_login_text') and @text='iphone 7 in Mobiles']")
	public static WebElement searchItem;

	@FindBy(xpath="//android.widget.TextView[contains(@resource-id,'com.flipkart.android:id/product_list_product_item_main_text') and @text='Apple iPhone 7 (Jet Black, 128 GB)']")
	public static WebElement selectItem;

	@FindBy(id="product_buynow_1")
	public static WebElement buyNow;

	@FindBy(id="tv_welcomestring_description")
	public static WebElement welcomeElement;

	@FindBy(xpath="//android.widget.ImageView[contains(@index,'2')]")
	public static WebElement sideNavBar;

	@FindBy(xpath="//android.widget.TextView[contains(@resource-id,'com.flipkart.android:id/flyout_parent_title') and @text='Offer Zone']")
	public static WebElement offerZone;

	@FindBy(xpath="//android.widget.TextView[contains(@text, 'Mobiles & Tablets')]")
	public static WebElement mobileZone;

	@FindBy(xpath="//android.widget.TextView[contains(@text, 'Now')]")
	public static WebElement nowText;

	@FindBy(xpath="//android.widget.TextView[contains(@text, 'Exchange Offer')]")
	public static WebElement exchangeOffer;

	public void clickMobileZone()
	{
		waitTillVisible(WebElementPaths.mobileZone);
		mobileZone.click();
	}
	public void clickNow()
	{
		waitTillVisible(WebElementPaths.nowText);
		nowText.click();
	}
	public void clickExchange()
	{
		waitTillVisible(WebElementPaths.exchangeOffer);
		exchangeOffer.click();
	}

	public void clickOfferZone()
	{
		waitTillVisible(WebElementPaths.offerZone);
		offerZone.click();
	}


	public void clickSideNavBar()
	{
		waitTillVisible(WebElementPaths.sideNavBar);
		sideNavBar.click();
	}

	public void clickButtonSkip()
	{
		waitTillVisible(WebElementPaths.button_skip);
		button_skip.click();
	}

	public void clickSearchWidget()
	{
		waitTillVisible(WebElementPaths.button_searchWidget);
		button_searchWidget.click();
	}

	public void clickSearchItem()
	{
		waitTillVisible(WebElementPaths.searchItem);
		searchItem.click();
	}

	public void clickSelectItem()
	{
		waitTillVisible(WebElementPaths.selectItem);
		selectItem.click();
	}

	public void clickBuyNow()
	{
		waitTillVisible(WebElementPaths.buyNow);
		buyNow.click();
	}

	public void inputSearchTextbox(String input)
	{
		waitTillVisible(WebElementPaths.button_autocomplete);
		button_autocomplete.sendKeys(input);
	}


	public String getWelcomeDesc()
	{
		waitTillVisible(WebElementPaths.welcomeElement);
		return  welcomeElement.getText();
	}

	public void waitTillVisible(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	
	  public WebElementPaths(WebDriver driver){
		  
	        this.driver = driver;
	 
	        //This initElements method will create all WebElements
	 
	        PageFactory.initElements(driver, this);
	 
	    }

}
