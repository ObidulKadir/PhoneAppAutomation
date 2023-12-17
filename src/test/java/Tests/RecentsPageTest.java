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
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Recent Call Log.</b></p>");
		RecentsPage rp = new RecentsPage(childTest);
		rp.recentCallLogFunctionality();
	}
	
	@Test(priority = 1)
	public void blockFunctionalityCheck() throws IOException, InterruptedException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Block the Number.</b></p>");
		RecentsPage rp = new RecentsPage(childTest);
		rp.blockTheNumber();
	}
	
	@Test(priority = 2)
	public void unblockFunctionalityTest() throws IOException, InterruptedException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Unblock the Number.</b></p>");
		RecentsPage rp = new RecentsPage(childTest);
		rp.unBlockTheNumber();
	}
	
	@Test(priority = 3)
	public void ClickOntheCallDetailsOption() throws IOException, InterruptedException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Call details Check.</b></p>");
		RecentsPage rp = new RecentsPage(childTest);
		rp.callDetails();
	}
	
	@Test(priority = 4)
	public void deleteTheNumber() throws IOException, InterruptedException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Delete Number.</b></p>");
		RecentsPage rp = new RecentsPage(childTest);
		rp.deleteTheNumber();
	}
	
	@Test(priority = 5)
	public void traverseContactPage() throws IOException, InterruptedException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Go to Contact Page.</b></p>");
		RecentsPage rp = new RecentsPage(childTest);
		rp.traverseContactPage();
	}
	
	@AfterClass
	public void report() {
		report.flush();
	}
}
