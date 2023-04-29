package GenericUtils;

import com.aventstack.extentreports.ExtentTest;

public class UtilityTransfer {

	private static ThreadLocal<ExtentTest> test=new ThreadLocal<ExtentTest>();
	
	public static ExtentTest get()
	{
		return test.get();
	}
	public static void set(ExtentTest s)
	{
		test.set(s);
	}
}
