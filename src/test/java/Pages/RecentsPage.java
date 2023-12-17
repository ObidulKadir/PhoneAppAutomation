package Pages;

import static BaseFolder.driverSetup.getDriver;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import Utility.getScreenShot;

public class RecentsPage extends BasePage{
	ExtentTest test;
	public RecentsPage(ExtentTest test) throws MalformedURLException {
		PageFactory.initElements(getDriver(), this);
		this.test = test;
	}
	
	// if case has been failed, this method will run and generate ss.
		@SuppressWarnings("unused")
	public void failCase(String message, String scName) throws IOException {
			test.fail(
						"<p style=\"color:#FF5353; font-size:13px\"><b>"+message+"</b></p>");
			Throwable t = new InterruptedException("Exception");
			test.fail(t);
			String screenShotPath = getScreenShot.capture(getDriver(), ""+scName+"");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + scName +".png";
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			getDriver().quit();
			}
		// if case has been pass but wants ss with the action.
		@SuppressWarnings("unused")
	private void passCaseWithSC(String message, String scName) throws IOException {
			test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>"+message+"</b></p>");
			String screenShotPath = getScreenShot.capture(getDriver(), ""+scName+"");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + ""+scName+".png";
			test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
				
			}
				
		// if only pass the cases then this method will run and generate a message.
	@SuppressWarnings("unused")
	private void passCase(String message) {
			test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>"+message+"</b></p>");
		}
		
	//locating the element
	@FindBy(xpath="//android.widget.LinearLayout[@resource-id='com.android.dialer:id/call_log_tab']")
	WebElement recentCallLog;

	@FindBy(xpath="//android.widget.TextView[@resource-id='com.android.dialer:id/name']")
	WebElement clickOntheContact;

	@FindBy(xpath="//android.widget.TextView[@text='Create new contact']")
	WebElement selectCreateNewContact;
	
	public void recentCallLogFunctionality() throws IOException {
		test.info("Click on the recentCallLog button.");
		try {
			clickOnElement(recentCallLog);
			sleepTime();
			passCaseWithSC("Clicked on the recentCallLog", "recentCallLogPass");
		} catch (Exception e) {
			failCase("recentCallLog element is unable to locate.", "recentCallLogFail");
		}
		
		test.info("Click on the clickOntheContact button.");
		try {
			clickOnElement(clickOntheContact);
			sleepTime();
			passCaseWithSC("Clicked on the clickOntheContact", "clickOntheContactPass");
		} catch (Exception e) {
			failCase("clickOntheContact element is unable to locate.", "clickOntheContactFail");
		}
	}
	
	public void createNewContact() throws IOException {
		test.info("Click on the CreateNewContact button.");
		try {
			clickOnElement(selectCreateNewContact);
			sleepTime();
			passCaseWithSC("Clicked on the selectCreateNewContact", "selectCreateNewContactPass");
		} catch (Exception e) {
			failCase("selectCreateNewContact element is unable to locate.", "selectCreateNewContactFail");
		}
	}
	
}
