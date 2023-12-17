package Tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import BaseFolder.driverSetup;
import Pages.DailPadPage;
import Pages.RecentsPage;

@Test
public class RecentsPageTest extends driverSetup{
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;
	
	@BeforeClass
	public void start() throws InterruptedException {

		report = Utility.ExtentFactory.getInstance();
		parentTest = report.createTest("<p style=\"color:#FF6000; font-size:20px\"><b>Recent Log Page.</b></p>").assignAuthor("QA TEAM").assignDevice("Pixel 7");
	}
	@Test (priority = 0)
	public void recentCallLogTest() throws IOException, InterruptedException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Recent Log test.</b></p>");
		RecentsPage rp = new RecentsPage(childTest);
		rp.recentCallLogFunctionality();
	}
	
	@Test(priority = 1)
	public void dialNumberTest() throws IOException, InterruptedException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Create A new contact.</b></p>");
		RecentsPage rp = new RecentsPage(childTest);
		rp.createNewContact();
	}
	
	
	@AfterClass
	public void report() {
		report.flush();
	}
}
