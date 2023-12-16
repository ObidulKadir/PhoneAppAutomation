package Tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import BaseFolder.driverSetup;
import Pages.DailPadPage;

@Test
public class DailPadTest extends driverSetup{
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;
	
	@BeforeClass
	public void start() throws InterruptedException {

		report = Utility.ExtentFactory.getInstance();
		parentTest = report.createTest("<p style=\"color:#FF6000; font-size:20px\"><b>Phone Dial Pad Page.</b></p>").assignAuthor("QA TEAM").assignDevice("Pixel 7");
	}
	@Test (priority = 0)
	public void openDialPadeOptionTest() throws IOException, InterruptedException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Dial Pad options.</b></p>");
		DailPadPage dailPad = new DailPadPage(childTest);
		dailPad.openKeyPad();
	}
	
	@Test(priority = 1)
	public void dialNumberTest() throws IOException, InterruptedException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Enter the keypad number.</b></p>");
		DailPadPage dailPad = new DailPadPage(childTest);
		dailPad.enterKeyNumber();
	}
	@Test (priority = 2)
	public void callTheNumberTest() throws IOException, InterruptedException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Dial the number.</b></p>");
		DailPadPage dailPad = new DailPadPage(childTest);
		dailPad.callTheNumber();
	}
	
	@AfterClass
	public void report() {
		report.flush();
	}
}
