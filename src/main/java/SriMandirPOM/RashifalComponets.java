package SriMandirPOM;
import java.util.ArrayList;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class RashifalComponets {

	@AndroidFindBy(id="com.mandir:id/menu_profile")
	private WebElement menuProfile;

	@AndroidFindBy(id="com.mandir:id/tv_title")
	private WebElement tvTitle;

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


	public WebElement convertToElement(String replace) {
		String xpath = String.format("//*[contains(@text , '%s')]", replace);
		return driver.findElement(AppiumBy.xpath(xpath));
	}


	public void menuProfile() {
		Assert.assertTrue(menuProfile.isDisplayed(), "chooseSign element is not displayyed");
	}

	public void tvTitle() {
		Assert.assertTrue(tvTitle.isDisplayed(), "chooseSign element is not displayyed");
	}

	public void bottomSHeetHeader() {
		Assert.assertTrue(chooseSign.isDisplayed(), "chooseSign element is not displayyed");
		Assert.assertTrue(subHeader.isDisplayed(), "subHeader element is not displayyed");
		Assert.assertTrue(exit.isDisplayed(), "exit element is not displayyed");
	}


	public void textView(ArrayList<String> elements) {

		for(String element:elements) {
			WebElement	txtvw=convertToElement(element);
			Assert.assertTrue(txtvw.isDisplayed(), "textview element is not displayed");
		}
	}


	public void imageView(ArrayList<String> elements) {

		for(String element:elements) {
			WebElement	txtvw=convertToElement(element);
			Assert.assertTrue(txtvw.isDisplayed(), "textview element is not displayed");
		}
	}



}
