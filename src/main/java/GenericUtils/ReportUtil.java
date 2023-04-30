package GenericUtils;
import java.awt.Desktop;
import java.io.File;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportUtil {
	
	private ExtentReports report;
	public ReportUtil(String p,String dt,String rn,String pn) {
		ExtentSparkReporter s=new ExtentSparkReporter(p);
		s.config().setDocumentTitle(dt);
		s.config().setReportName(rn);
		s.config().setTheme(Theme.DARK);
		
		report=new ExtentReports();
		report.attachReporter(s);
		report.setSystemInfo("os", System.getProperty("os.name"));
		report.setSystemInfo("platformName", pn);
	}
	
	public void createTest(String n) {
		ExtentTest t = report.createTest(n);
		UtilityTransfer.set(t);
	}
	
	public void pass(ExtentTest t,String msg) {
		t.pass(msg);
	}
	
	public void fail(ExtentTest t,String msg) {
		t.fail(msg);
	}
	
	public void fail(Throwable msg,ExtentTest t) {
		t.fail(msg);
	}
	
	public void warn(ExtentTest t,String msg) {
		t.fail(msg);
	}
	
	public void warn(Throwable msg,ExtentTest t) {
		t.fail(msg);
	}
	
	public void addScreenShot(ExtentTest t,String path,String n) {
		t.addScreenCaptureFromBase64String(path, n);
	}
	public void saveReport(String p) {
		try {
			report.flush();
			Desktop.getDesktop().browse(new File(p).toURI());
		} catch (Exception e) {	} 
	}
	
	public void authorCategory(ExtentTest t,String [] a,String [] c) {
		t.assignAuthor(a);
		t.assignCategory(c);
	}
	
	public void info(ExtentTest t,String msg) {
		t.info(msg);
	}
}
