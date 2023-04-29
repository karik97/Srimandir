package SriMandirPOM;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ExplorePage {

	@AndroidFindBy(xpath ="//android.widget.FrameLayout[@content-desc=\"Explore\"]")
	private WebElement navigationExplore;

	@AndroidFindBy(id = "com.mandir:id/tv_avatar_title")
	private WebElement avatarTitle;

	@AndroidFindBy(xpath = "//*[contains(@text , 'Rashifal')]")
	private WebElement Rashifaltoolbar;
	
	@AndroidFindBy(xpath="//*[contains(@resource-id , 'com.mandir:id/tv_sign_selector')]")
	private WebElement widget;

	@AndroidFindBy(id = "com.mandir:id/menu_title")
	private WebElement exploreTitle;
	
	@AndroidFindBy(xpath = "//*[contains(@resource-id,'com.mandir:id/design_bottom_sheet')]")
	private WebElement bottomSheet;
	
	@AndroidFindBy(xpath="//*[contains(@text , 'Gemini')]")
	private WebElement rashi;
	
	@AndroidFindBy(id="com.mandir:id/tv_sign_selector")
	private WebElement defaultRashi;
	
	@AndroidFindBy(xpath="//*[contains(@text , 'Gemini Sign')]")
	private WebElement sign;
	
	@AndroidFindBy(xpath = "//*[contains(@resource-id , 'com.mandir:id/tv_title1')]")
	private WebElement widgetDateDay;
	
	@AndroidFindBy(xpath="//*[contains(@resource-id ,'com.mandir:id/tv_sign_desc')]")
	private WebElement content;
	
	@AndroidFindBy(xpath="//*[contains(@text ,'Share')]")
	private WebElement shareButton;
	
	@AndroidFindBy(id="com.mandir:id/hamburger_menu")
	private WebElement hamBurger;
	
	@AndroidFindBy(xpath = "//*[@text = 'WhatsApp']")
	private WebElement whatsappShare;

	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(text(\""+"Akka"+"\"))")
	private WebElement userB;	
	
	@AndroidFindBy(accessibility = "Send")
    private WebElement send;
	
	@AndroidFindBy(id="com.whatsapp:id/caption")
	private WebElement shared;
	
	public ExplorePage(AndroidDriver driver) {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	public WebElement avatarTitle() {

		return avatarTitle;
	}

	public WebElement navigationExplore() {

		return navigationExplore;
	}

	public WebElement Rashifaltoolbar() {

		return Rashifaltoolbar;	
		
	}

	public String exploreTitle() {

		return exploreTitle.getText();
	}
	
	public WebElement widget() {
		return widget;
	}
	
	public WebElement bottomSheet() {
		return bottomSheet;
	}

	public WebElement defaultRashi() {
		return defaultRashi;
	}
	
	public WebElement rashi() {
		return rashi;
	}
	
	public String sign() {
		return sign.getText();
	}
	
	public String widgetDateDay() {
		return widgetDateDay.getText();
	}
	
	public String content() {
		return content.getText();
	}
	
	public WebElement shareButton() {
		return shareButton;
	}
	
	public WebElement hamBurger() {
		return hamBurger;
	}

	public WebElement shareUserB() {
		whatsappShare.click();
		userB.click();
		send.click();
		send.click();
		return shared;
	}
}
