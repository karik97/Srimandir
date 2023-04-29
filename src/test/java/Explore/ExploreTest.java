package Explore;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import GenericUtils.BaseClass;
import GenericUtils.Ennum_data;
import SriMandirPOM.RashifalComponets;
import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class ExploreTest extends BaseClass{

	/**
	 * Verify that user is getting Rashifal widget on navigating to homefeed
	 */

	@Test
	public void SMPK_TC_3329(){

		soft.assertTrue(explore.widget().isDisplayed());
		soft.assertEquals(explore.exploreTitle(), "Explore");	
	}

	/**
	 * Verify that user is getting rashifal bottomsheet on clicking the rashifal widget for the first time
	 */

	@Test
	public void SMPK_TC_3331() {

		explore.widget().click();
		soft.assertTrue(explore.bottomSheet().isDisplayed());
	}

	/**
	 * Verify that user is able to select "Rashi" from the rashi bottomsheet
	 */

	@Test
	public void SMPK_TC_3332() {

		explore.widget().click();
		soft.assertTrue(explore.rashi().isEnabled());
		explore.rashi().click();
		soft.assertEquals(explore.exploreTitle(), "Explore");
	}
	/**
	 * Verify that the respective user selected raashi title is getting displayed
	 */

	@Test
	public void SMPK_TC_3335() {

		explore.widget().click();
		explore.rashi().click();
		soft.assertEquals(explore.sign(), "Gemini Sign");
		soft.assertEquals(explore.exploreTitle(), "Explore");
	}

	/**
	 * Verify that user is getting the respective date and day on the rashifal widget
	 */

	@Test
	public void SMPK_TC_3338() {
		
		soft.assertTrue(explore.widgetDateDay().contains(java.rashiDate()));
		soft.assertEquals(explore.exploreTitle(), "Explore");
	}

	/**
	 * Verify that user is getting the respective content displayed according to the selected rashifal
	 */

	@Test
	public void SMPK_TC_3369() {

		explore.widget().click();
		explore.rashi().click();
		System.out.println(explore.content());
		soft.assertEquals(explore.exploreTitle(), "Explore");
	}

	/**
	 * Verify that the "Anya Rashifal dekhe" and share kare buttons are visible to the user
	 */

	@Test
	public void SMPK_TC_3371() {

		soft.assertTrue(explore.shareButton().isDisplayed());
		soft.assertEquals(explore.exploreTitle(), "Explore");	    
	}

	/**
	 * Verify that bottomsheet is disappearing on selecting any Raashi
	 * @throws InterruptedException 
	 */

	@Test
	public void SMPK_TC_3375() throws InterruptedException {

		explore.widget().click();
		explore.rashi().click();
		Thread.sleep(5000);
		try {
			soft.assertTrue(explore.bottomSheet().isDisplayed());
		}
		catch(Exception e) {
			System.out.println("bottomsheet is dissappeared TC PASS");
		}
		soft.assertEquals(explore.exploreTitle(), "Explore");
	}

	/**
	 * Verify that user is not getting multiple bottomsheet on clciking rashifal widget for multiple times after selecting a raashi	
	 * @throws InterruptedException 
	 */

	@Test
	public void SMPK_TC_15220() throws InterruptedException {
		
		for(int i=0; i<=3; i++) {
			Thread.sleep(2000);
			explore.widget().click();
			System.out.println(explore.bottomSheet().isDisplayed());			
			explore.rashi().click();
		}
		soft.assertEquals(explore.exploreTitle(), "Explore");
	}
	
	/**
	 * Verify that user is not getting empty Raashi name for the first time after selecting raashi in offline mode
	 */
	
	@Test
	public void SMPK_TC_15221() {
		
		ConnectionState conn = driver.getConnection();
	
	    explore.widget().click();
	    explore.rashi().click();
		soft.assertEquals(explore.sign(),"Gemini Sign");
		soft.assertEquals(explore.exploreTitle(), "Explore");
	}
	
	/**
	 * Verify that user is getting "Anya rashifal" and share kare button on clicking Aur dekhe on the rashifal content
	 */
	@Test
	public void SMPK_TC_15222() {
		
	}
	
	/**
	 * Verify that user can use the default and expanded view of the rashifal content
	 */
	@Test
	public void SMPK_TC_15223() {
		explore.hamBurger().click();
		
	}

	/**
	 * Verify that user is not getting empty Raashi name on selecting raashi for first time in offline mode
	 */
	@Test
	public void SMPK_TC_15224() {
		soft.assertTrue(explore.defaultRashi().isDisplayed(),"defaultRashi is not displayed");
		soft.assertEquals(explore.exploreTitle(), "Explore");
	}
	
	/**
	 * Verify that bottomsheet disappears on clicking anywhere on the screen other than the bottomsheet area
	 */
	
	@Test
	public void SMPK_TC_15225() {
		explore.widget().click();
		gestures.clickByCooridnates(driver, 0,95,1080,2080);
		try {
			soft.assertTrue(explore.bottomSheet().isDisplayed());
		}
		catch(Exception e){
			System.out.println("bottom sheet disappeared TC PASS");
		}
		soft.assertEquals(explore.exploreTitle(), "Explore");
	}
	
	/**
	 * Verify that bottom-sheet disappears on clicking device back
	 */
	@Test
	public void SMPK_TC_15226() {
		explore.widget().click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		try {
			soft.assertTrue(explore.bottomSheet().isDisplayed());
		}
		catch(Exception e) {
			System.out.println("bottom sheet disappeared TC PASS");
		}
		soft.assertEquals(explore.exploreTitle(), "Explore");
	}
	
	/**
	 * Verify that user is able to whatsapp share on clicking "Share kare"
	 */
	@Test
	public void SMPK_TC_15228() {
		explore.shareButton().click();
        soft.assertTrue(explore.shareUserB().isDisplayed());
        driver.activateApp(prop.readData(Ennum_data.APPPACKAGE));
        soft.assertEquals(explore.exploreTitle(), "Explore");
	}
	
	/**
	 * Verify that user is getting redirected to rashifal section on clicking the rashifal deeplink
	 */
	@Test
	public void SMPK_TC_15229() {
		Assert.assertTrue(explore.hamBurger().isDisplayed(),"hamBurger is not displayed");
		Assert.assertEquals(explore.exploreTitle(), "Explore");
		rasiComponent.menuProfile();
		
		rasiComponent.tvTitle();
		Assert.assertTrue(explore.defaultRashi().isDisplayed(),"defaultRashi is not displayed");
		Assert.assertTrue(explore.widget().isDisplayed(),"widget is not displayed");
		explore.rashi().click();
		
		Assert.assertTrue(explore.bottomSheet().isDisplayed(),"bottomSheet is not displayed");		
		rasiComponent.textView(excel.fetchTextView(prop.readData(Ennum_data.TVSHEET)));
		
		//soft.assertTrue(explore.widgetDateDay().contains(java.rashiDate()));
		//soft.assertTrue(explore.shareButton().isDisplayed(),"sharebutton is not displayed");
	
		
	}
}
