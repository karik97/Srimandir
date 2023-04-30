package SriMandirPOM;
import java.util.ArrayList;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.aventstack.extentreports.App;

import GenericUtils.Gestures;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class RashifalComponets {

	@AndroidFindBy(id="com.mandir:id/tv_title")
	private WebElement chooseSign;

	@AndroidFindBy(id="com.mandir:id/iv_exit")
	private WebElement exit;

	@AndroidFindBy(id="com.mandir:id/tv_sub_header")
	private WebElement subHeader;

	private AndroidDriver driver;

	public RashifalComponets(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void bottomSHeetHeader() {
		Assert.assertTrue(chooseSign.isDisplayed(), "chooseSign element is not displayyed");
		Assert.assertTrue(subHeader.isDisplayed(), "subHeader element is not displayyed");
		Assert.assertTrue(exit.isDisplayed(), "exit element is not displayyed");
	}


	public WebElement convertToElement(String replace) {
		String xpath = String.format("//*[contains(@text , '%s')]", replace);
		return driver.findElement(AppiumBy.xpath(xpath));
	}


	public void textViewElement(ArrayList<String> elements) {

		for(String element:elements) {
			WebElement	txtvwElement=convertToElement(element);
			Assert.assertTrue(txtvwElement.isDisplayed(), element+"is not displayed");
		}
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}

	public WebElement converToElement1(String replace) {
		String id = String.format("com.mandir:id/%s", replace);
		return driver.findElement(AppiumBy.id(id));
	}

	public void containerElement(ArrayList<String> elements)
	{
		for(String element:elements) {
			if(element.equals("tv_offerings_title")) {
				new Gestures().thread(3000);
				driver.findElement(AppiumBy.androidUIAutomator
	("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+"Offer Chadhava for well-being"+"\"))"));
				
				WebElement containerElement = converToElement1(element);
				Assert.assertTrue(containerElement.isDisplayed(), element+"is not displayed");
			}else {
				new Gestures().thread(3000);
				WebElement containerElement = converToElement1(element);
				Assert.assertTrue(containerElement.isDisplayed(), element+"is not displayed");
			}
		}
	}
	
	//"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+text+"\").instance(0))"
	//driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Make today's Chadhava as per your Moonsign\")"));
	
	
	
	
}
