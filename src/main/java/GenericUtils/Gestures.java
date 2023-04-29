package GenericUtils;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;

public class Gestures {

	public void clickByCooridnates(AndroidDriver driver,int l,int t,int w,int h) {
		driver.executeScript("mobile:clickGesture", ImmutableMap.of(
				"left",l,
				"top",t,
				"width",w,
				"height",h
				));
	}
}
