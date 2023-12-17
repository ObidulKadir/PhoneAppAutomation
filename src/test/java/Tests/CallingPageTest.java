package Tests;
import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import BaseFolder.driverSetup;
import Pages.CallingPage;
import Utility.ExtentFactory;

public class CallingPageTest extends driverSetup{
	
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;
	
	@BeforeClass
	public void start() {
		report = ExtentFactory.getInstance();
		parentTest = report.createTest("<p style=\"color:#FF6000; font-size:20px\"><b>In-call page.</b></p>").assignAuthor("QA TEAM").assignDevice("Pixel 7");
	}
	
	@Test(priority=0)
	public void speakerTest() throws IOException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Speaker option.</b></p>");
		CallingPage incallPage = new CallingPage(childTest);
		incallPage.speakerOn();
	}
	
	@Test(priority=1)
	public void unmuteTest() throws IOException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>unmute option.</b></p>");
		CallingPage incallPage = new CallingPage(childTest);
		incallPage.muteOn();
	}
	@Test(priority=2)
	public void endCallTest() throws IOException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>End calling.</b></p>");
		CallingPage incallPage = new CallingPage(childTest);
		incallPage.endCall();
	}
	
	@AfterClass
	public void report() {
		report.flush();
	}

}
