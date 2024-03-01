package extentReports;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Testcases.Testcase;

public class ExtentReport implements ITestListener{

	//UI of the report
	public ExtentSparkReporter sparkReporter;
	
	//populate common info on the report
	public ExtentReports extent;
		
	//creating test case entries in the report and update status of the test methods
	public ExtentTest test;
	
	public void onStart(ITestContext context) {
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/myReport.html");
		
		sparkReporter.config().setDocumentTitle("Identify Courses Report");
		sparkReporter.config().setReportName("dentify Courses Testing");
		sparkReporter.config().setTheme(Theme.STANDARD);

		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
				
		extent.setSystemInfo("Computer Name","localhost");
		extent.setSystemInfo("Environment","QEA");
		extent.setSystemInfo("Tester Name","Saran M");
		extent.setSystemInfo("OS","Windows11");
		extent.setSystemInfo("Browser Name","Chrome Browser");		
	}
	
	public void onTestSuccess(ITestResult result) {
		String path=Testcase.path;
		
		if(result.getName().equals("languagelearning")) {
			String path1=Testcase.path1;
			String path2=Testcase.path2;
			String path3=Testcase.path3;
			String path4=Testcase.path4;
			test=extent.createTest(result.getName())
					.addScreenCaptureFromPath(path1,"Beginner")
					.addScreenCaptureFromPath(path2,"Intermediate")
					.addScreenCaptureFromPath(path3,"Advanced")
					.addScreenCaptureFromPath(path4,"Mixed");
		}
		else{
			test=extent.createTest(result.getName())
					.addScreenCaptureFromPath(path,result.getName());
		}
		
		test.log(Status.PASS, "Test Case Passed is: "+result.getName());
	}
	
	public void onTestFailure(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.FAIL, "Test Case Failed is: "+result.getName());
		test.log(Status.FAIL, "Test Case Failed cause is: "+result.getThrowable());
	}
	
	public void onTestSkipped(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.SKIP, "Test Case Skipped is: "+result.getName());	
	}
	
	public void onFinish(ITestContext context) {
		extent.flush();
	}
}
