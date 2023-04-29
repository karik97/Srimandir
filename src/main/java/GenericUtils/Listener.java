package GenericUtils;

import org.openqa.selenium.OutputType;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener,ISuiteListener,FrameworkConstans{

	private ReportUtil rep;
	public  static ReportUtil srep;
	
	public void onStart(ISuite suite) {
		System.out.println("onStart");
		PropertyUtils p=new PropertyUtils(PROPPATH);
		 rep = new ReportUtil("", p.readData(Ennum_data.DOCTITLE), p.readData(Ennum_data.REPORTNAME));
		 srep=rep;
	}
	
	public void onFinish(ISuite suite) {
		System.out.println("onStart");
		rep.saveReport("");
	}
	
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart");
		rep.createTest(result.getMethod().getMethodName());
		Annotation a = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Annotation.class);
		rep.authorCategory(UtilityTransfer.get(), a.author(), a.category());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess");
		rep.pass(UtilityTransfer.get(),result.getMethod().getMethodName() );
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure");
		rep.addScreenShot(UtilityTransfer.get(), BaseClass.class.cast(result.getInstance()).driver.getScreenshotAs(OutputType.BASE64), 
				result.getMethod().getMethodName()+" is failed");
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped");
		rep.addScreenShot(UtilityTransfer.get(), BaseClass.class.cast(result.getInstance()).driver.getScreenshotAs(OutputType.BASE64), 
				result.getMethod().getMethodName()+" is skipped");
		
	}

	public void onStart(ITestContext context) {
		System.out.println("onStart----test");
		
	}

	public void onFinish(ITestContext context) {
		System.out.println("onFinish----test");
	}

	
	
}
