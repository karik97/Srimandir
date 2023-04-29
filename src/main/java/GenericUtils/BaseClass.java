package GenericUtils;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import SriMandirPOM.ExplorePage;
import SriMandirPOM.RashifalComponets;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class BaseClass implements FrameworkConstans{

	private AppiumDriverLocalService Server;
	protected	PropertyUtils prop;
	protected AndroidDriver driver; 
	protected SoftAssert soft; 
	protected Java_utils java;
	protected Excel_utils excel;

	@BeforeClass
	public void start() throws Exception{

		prop=new PropertyUtils(PROPPATH);
		excel=new Excel_utils(EXCELPATH);
		soft=new SoftAssert();
		java=new Java_utils();

		Server = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingPort(4723).withArgument(GeneralServerFlag.SESSION_OVERRIDE));
		Server.start();		
		Server.clearOutPutStreams();

		DesiredCapabilities desireCapability = new DesiredCapabilities();
		desireCapability.setCapability(MobileCapabilityType.PLATFORM_NAME, prop.readData(Ennum_data.PLATFORMNAME));
		desireCapability.setCapability(MobileCapabilityType.PLATFORM_VERSION, prop.readData(Ennum_data.PLATFORMVERSION));
		desireCapability.setCapability(MobileCapabilityType.UDID, prop.readData(Ennum_data.UDID));
		desireCapability.setCapability(MobileCapabilityType.DEVICE_NAME, prop.readData(Ennum_data.DEVICENAME));
		desireCapability.setCapability(MobileCapabilityType.AUTOMATION_NAME, prop.readData(Ennum_data.AUTOMATIONNAME));
		desireCapability.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 10);

		driver =new AndroidDriver(new URL("http://127.0.0.1:4723"),desireCapability);
		driver.unlockDevice();
		driver.activateApp(prop.readData(Ennum_data.APPPACKAGE));
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

	protected Gestures gestures;
	protected ExplorePage explore;
	protected RashifalComponets rasiComponent;
	@BeforeMethod
	public void object() {

		explore=new ExplorePage(driver);
		rasiComponent =new RashifalComponets(driver);

		gestures=new Gestures();
		Assert.assertTrue(explore.avatarTitle().isDisplayed(), "avatarTitle is not displayed");		
		Assert.assertTrue(explore.navigationExplore().isDisplayed(), "navigationExplore is not displayed");
		explore.navigationExplore().click();	
		Assert.assertTrue(explore.Rashifaltoolbar().isDisplayed(), "Rashifal toolbar is not displayed");
		explore.Rashifaltoolbar().click();
	}

	@AfterMethod 
	public void closeApp() {

		driver.terminateApp(prop.readData(Ennum_data.APPPACKAGE));
		driver.lockDevice();
	}

	@AfterClass
	public void stop() {
		try {
			Server.stop();
			driver.quit();
			prop.readClose();

		}catch(Exception e) {}
		soft.assertAll();

	}

}
