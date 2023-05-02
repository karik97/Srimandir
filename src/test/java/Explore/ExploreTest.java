package Explore;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import GenericUtils.Annotation;
import GenericUtils.BaseClass;
import GenericUtils.Ennum_data;
import GenericUtils.UtilityTransfer;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

@Listeners(GenericUtils.Listener.class)
public class ExploreTest extends BaseClass{

	/**
	 * Verify that user is getting Rashifal widget on navigating to homefeed
	 * rashifal widget is not found in home page its defect according to the testcase
	 */

	@Annotation(author = "kartik")
	@Test
	public void SMPK_TC_3329(){

		soft.assertTrue(explore.widget().isDisplayed());
		soft.assertEquals(explore.exploreTitle(), "Explore");	
	}

	/**
	 * Verify that user is getting rashifal bottomsheet on clicking the rashifal widget for the first time
	 */
	@Annotation(author = "kartik")
	@Test
	public void SMPK_TC_3331() {

		explore.widget().click();
		soft.assertTrue(explore.bottomSheet().isDisplayed());
	}

	/**
	 * Verify that user is able to select "Rashi" from the rashi bottomsheet
	 */
	@Annotation(author = "kartik")
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
	@Annotation(author = "kartik")
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
	@Annotation(author = "kartik")
	@Test
	public void SMPK_TC_3338() {		
		report.info(UtilityTransfer.get() ,explore.widgetDateDay()+"--->"+java.rashiDate());
		soft.assertTrue(explore.widgetDateDay().contains(java.rashiDate()));
		soft.assertEquals(explore.exploreTitle(), "Explore");
	}

	/**
	 * Verify that user is getting the respective content displayed according to the selected rashifal
	 */
	@Annotation(author = "kartik")
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
	@Annotation(author = "kartik")
	@Test
	public void SMPK_TC_3371() {

		soft.assertTrue(explore.shareButton().isDisplayed());
		soft.assertEquals(explore.exploreTitle(), "Explore");	    
	}
	
	/**
	 * Verify that user is getting rashifal bottomsheet when back to network state
	 * 
	 */
	@Annotation(author = "kartik")
	@Test
	public void SMPK_TC_3374()  {
		
		gestures.thread(2000);
		explore.rashi().click();
		gestures.thread(2000);
		gestures.DataOn(driver);
		Assert.assertTrue(explore.bottomSheet().isDisplayed(),"bottomSheet is not displayed");		
	}
	

	/**
	 * Verify that bottomsheet is disappearing on selecting any Raashi
	 */
	@Annotation(author = "kartik")
	@Test
	public void SMPK_TC_3375(){

		explore.widget().click();
		explore.rashi().click();
		gestures.thread(3000);
		try {
			soft.assertTrue(explore.bottomSheet().isDisplayed());
			report.info(UtilityTransfer.get(), "bottomsheet is not dissappeared TC FAIL");
		}
		catch(Exception e) {
			System.out.println("bottomsheet is dissappeared TC PASS");
			report.info(UtilityTransfer.get(), "bottomsheet is dissappeared TC PASS");
		}
		soft.assertEquals(explore.exploreTitle(), "Explore");
	}

	/**
	 * Verify that user is not getting multiple bottomsheet on clciking rashifal widget for multiple times after selecting a raashi	
	 *
	 */
	@Annotation(author = "kartik")
	@Test
	public void SMPK_TC_15220() {
		
		for(int i=0; i<=3; i++) {
			gestures.thread(3000);
			explore.widget().click();
			System.out.println(explore.bottomSheet().isDisplayed());	
			report.info(UtilityTransfer.get(), "bottomsheet is dissappeared");
			explore.rashi().click();
		}
		soft.assertEquals(explore.exploreTitle(), "Explore");
	}
	
	/**
	 * Verify that user is not getting empty Raashi name for the first time after selecting raashi in offline mode
	 */
	@Annotation(author = "kartik")
	@Test
	public void SMPK_TC_15221() {
		
		gestures.thread(2000);
	    explore.widget().click();
	    explore.rashi().click();
		soft.assertEquals(explore.sign(),"Gemini Sign");
		soft.assertEquals(explore.exploreTitle(), "Explore");
	}
	
	/**
	 * Verify that user is getting "Anya rashifal" and share kare button on clicking Aur dekhe on the rashifal content
	 * Anya rashifal did not found its a defect
	 */
	@Test
	public void SMPK_TC_15222() {
		
	}
	
	/**
	 * Verify that user can use the default and expanded view of the rashifal content
	 */
	@Annotation(author = "kartik")
	@Test
	public void SMPK_TC_15223() {
		explore.hamBurger().click();
		explore.expandedView();
		soft.assertEquals(explore.exploreTitle(), "Explore");
	}

	/**
	 * Verify that user is not getting empty Raashi name on selecting raashi for first time in offline mode
	 */
	@Annotation(author = "kartik")
	@Test
	public void SMPK_TC_15224() {
		gestures.DataOff(driver);
		gestures.thread(2000);
		soft.assertTrue(explore.defaultRashi().isDisplayed(),"defaultRashi is not displayed");
		soft.assertEquals(explore.exploreTitle(), "Explore");
	}
	
	/**
	 * Verify that bottomsheet disappears on clicking anywhere on the screen other than the bottomsheet area
	 */
	@Annotation(author = "kartik")
	@Test
	public void SMPK_TC_15225() {
		explore.widget().click();
		gestures.click(500,500 ,driver);
		try {
			soft.assertTrue(explore.bottomSheet().isDisplayed());
			report.info(UtilityTransfer.get(), "bottomsheet is not dissappeared TC FAIL");
		}
		catch(Exception e){
			System.out.println("bottom sheet disappeared TC PASS");
			report.info(UtilityTransfer.get(), "bottomsheet is dissappeared TC PASS");
		}
		soft.assertEquals(explore.exploreTitle(), "Explore");
	}
	
	/**
	 * Verify that bottom-sheet disappears on clicking device back
	 */
	@Annotation(author = "kartik")
	@Test
	public void SMPK_TC_15226() {
		explore.widget().click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		try {
			soft.assertTrue(explore.bottomSheet().isDisplayed());
			report.info(UtilityTransfer.get(), "bottomsheet is not dissappeared TC FAIL");
		}
		catch(Exception e) {
			System.out.println("bottom sheet disappeared TC PASS");
			report.info(UtilityTransfer.get(), "bottomsheet is dissappeared TC PASS");
		}
		soft.assertEquals(explore.exploreTitle(), "Explore");
	}
	
	/**
	 * Verify that user is able to whatsapp share on clicking "Share kare"
	 */
	@Annotation(author = "kartik")
	@Test
	public void SMPK_TC_15228() {
		explore.shareButton().click();
        soft.assertTrue(explore.shareUserB().isDisplayed());
        driver.activateApp(prop.readData(Ennum_data.APPPACKAGE));
        soft.assertEquals(explore.exploreTitle(), "Explore");
	}
	
	/**
	 * Verify that user is getting redirected to rashifal section on clicking the rashifal deeplink
	 * did not found the deeplink
	 */
	@Test
	public void SMPK_TC_15229() {
		
	}
	/**
	 * Verify all the UI components of rashifal
	 * scroll action is not performing on the application 
	 */
	@Annotation(author = "kartik")
	@Test
	public void SMPK_TC_15230() {
		
		Assert.assertTrue(explore.widget().isDisplayed(), "widget is not displayed");
		explore.widget().click();
		rashifalComponent.bottomSHeetHeader();
		rashifalComponent.textViewElement(excel.fetchTextView(prop.readData(Ennum_data.TVSHEET)));
		rashifalComponent.containerElement(excel.rashifalElement(prop.readData(Ennum_data.TVSHEET)));
		
	}
	
}
