package support;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReportClass implements ITestListener, Constants {
	public static ExtentReports extentReport = new ExtentReports();
	public static ExtentSparkReporter htmlReporter = new ExtentSparkReporter("reports/report.html");
	public static ExtentTest extentTest;

	public void onTestStart(ITestResult result) {
		extentReport.attachReporter(htmlReporter);
	}

	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.PASS, "All steps have passed!");
	}

	public void onTestFailure(ITestResult result) {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		String destinationPath = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator
				+ result.getName() + ".png";
		File finalDestinationPath = new File(destinationPath);
		try {
			FileUtils.copyFile(source, finalDestinationPath);
		} catch (Exception e) {
			e.printStackTrace();
		}

		extentTest.log(Status.FAIL, "Test has failed! check the attached screenshot please")
				.addScreenCaptureFromPath(destinationPath);
	}

	public void onFinish(ITestContext context) {
		extentTest.log(Status.INFO, "Testing is done !");
		extentReport.flush();
	}

}
