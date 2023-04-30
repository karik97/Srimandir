package GenericUtils;
import java.util.HashMap;
import java.util.Map;
import org.testng.Assert;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.android.connection.HasNetworkConnection;

public class Gestures {

	public void clickByCooridnates(AndroidDriver driver,int sx,int sy,int ex,int ey) {	


		driver.executeScript("mobile:clickGesture", ImmutableMap.of(
				"startX",sx,
				"startY",sy,
				"endX",ex,
				"endY",ey
				));
	}

	public void scroll(AndroidDriver driver,int l,int t,int w,int h,String dir) {
		driver.executeScript("mobile:scrollGesture", ImmutableMap.of(
				"left",h,
				"top",w,
				"width",w,
				"height", h,
				"direction",dir,
				"percent", 0.75
				));
	}

	public void scrollStartEndXY(AndroidDriver driver,int sx,int sy,int ex,int ey,String dir) {
		driver.executeScript("mobile:scrollGesture", ImmutableMap.of(
				"startX",sx,
				"startY",sy,
				"endX",ex,
				"endY",ey,
				"direction",dir,
				"percent",0.75	 
				));	
	}

	public void swipeByXY(AndroidDriver driver,int sx,int sy,int ex,int ey,String dir) {
		driver.executeScript("mobile:swipeGesture", ImmutableMap.of(
				"startX",sx,
				"startY",sy,
				"endX",ex,
				"endY",ey,
				"direction",dir,
				"percent",0.75
				));
	}

	public void click(int x,int y,AndroidDriver driver) {
		Map<String, Object> arg=new HashMap<String, Object>();
		arg.put("x", x);
		arg.put("y", y);
		driver.executeScript("mobile: tap", arg);
	}

	public void DataOn(AndroidDriver driver) {
		ConnectionState state = driver.setConnection(new ConnectionStateBuilder().withDataEnabled().build());
		Assert.assertTrue(state.isDataEnabled(),"data is not enabled");
	}

	public void DataOff(AndroidDriver driver) {
		ConnectionState state = driver.setConnection(new ConnectionStateBuilder().withDataDisabled().build());
		Assert.assertTrue(state.isDataEnabled(),"data is not disabled");
	}
	
	public void DataOn(AndroidDriver driver,boolean enable) {
		HasNetworkConnection conn = (HasNetworkConnection)driver;
	}

	public void thread(long sec) {
		try {
			Thread.sleep(sec);
		} catch (InterruptedException e) {}
	}

	public void WifiOn(AndroidDriver driver) {
		ConnectionState state = driver.setConnection(new ConnectionStateBuilder().withWiFiEnabled().build());
		Assert.assertTrue(state.isWiFiEnabled(), "Wifi is not switched on");
	}

	public void WifiOff(AndroidDriver driver) {
		ConnectionState state = driver.setConnection(new ConnectionStateBuilder().withWiFiDisabled().build());
		Assert.assertFalse(state.isWiFiEnabled(),"Wifi is not switched off");
	}
}
