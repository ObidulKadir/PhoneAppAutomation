package Tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import BaseFolder.driverSetup;
import Pages.ContactsPage;
import Pages.DailPadPage;
import Pages.RecentsPage;

@Test
public class ContactsPageTest extends driverSetup{
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;
	
	@BeforeClass
	public void start() throws InterruptedException {

		report = Utility.ExtentFactory.getInstance();
		parentTest = report.createTest("<p style=\"color:#FF6000; font-size:20px\"><b>Contacts Page.</b></p>").assignAuthor("QA TEAM").assignDevice("Pixel 7");
	}
	@Test (priority = 0)
	public void recentCallLogTest() throws IOException, InterruptedException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Go to the Create contact form page.</b></p>");
		ContactsPage cp = new ContactsPage(childTest);
		cp.clickOnTheCreateNewContact();
	}
	
	@Test (priority = 1)
	public void createAnewContact() throws IOException, InterruptedException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Create a new contact..</b></p>");
		ContactsPage cp = new ContactsPage(childTest);
		cp.createANewContact();
	}
	
	@Test (priority = 2)
	public void updateTheContact() throws IOException, InterruptedException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Update the contact.</b></p>");
		ContactsPage cp = new ContactsPage(childTest);
		cp.updateTheContact();
	}
	
	@Test (priority = 3)
	public void deleteTheContact() throws IOException, InterruptedException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Delete the contact.</b></p>");
		ContactsPage cp = new ContactsPage(childTest);
		cp.deleteTheContact();
	}
	
	@AfterClass
	public void report() {
		report.flush();
	}
}
