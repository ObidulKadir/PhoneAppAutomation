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

	@FindBy(xpath="//android.widget.TextView[@text='Block number']")
	WebElement blockNumber;

	@FindBy(xpath="//android.widget.Button[@resource-id='android:id/button1']")
	WebElement ConfirmBlockButton;

	@FindBy(xpath="//android.widget.TextView[@text='Unblock number']")
	WebElement unBlockNumber;

	@FindBy(xpath="//android.widget.Button[@resource-id='android:id/button1']")
	WebElement confirmUnBlockNumber;

	@FindBy(xpath="//android.widget.TextView[@text='Call details']")
	WebElement callDetailsButton;

	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.android.dialer:id/call_detail_action_delete\"]")
	WebElement deleteNumber;
	
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
	
	public void blockTheNumber() throws IOException {
		test.info("Click on the blockNumber button.");
		try {
			clickOnElement(blockNumber);
			sleepTime();
			passCaseWithSC("Clicked on the blockNumber", "blockNumberPass");
		} catch (Exception e) {
			failCase("blockNumber element is unable to locate.", "blockNumberFail");
		}
		
		test.info("Click on the confirmbutton to block the number.");
		try {
			clickOnElement(ConfirmBlockButton);
			sleepTime();
			passCaseWithSC("Clicked on the confirm button.", "confirmUnBlockNumberPass");
		} catch (Exception e) {
			failCase("confirmUnBlockNumber element is unable to locate.", "confirmUnBlockNumberFail");
		}
	}
	
	public void unBlockTheNumber() throws IOException {
		test.info("Click on the unblock button.");
		try {
			clickOnElement(unBlockNumber);
			sleepTime();
			passCaseWithSC("Clicked on the unBlockNumber", "unBlockNumberPass");
		} catch (Exception e) {
			failCase("unBlockNumber element is unable to locate.", "unBlockNumberFail");
		}
		
		test.info("Clicked on the unconfirm button to unblock number.");
		try {
			clickOnElement(confirmUnBlockNumber);
			sleepTime();
			passCaseWithSC("Clicked on the confirm button.", "confirmUnBlockNumberPass");
		} catch (Exception e) {
			failCase("confirmUnBlockNumber element is unable to locate.", "confirmUnBlockNumberFail");
		}
	}
	
	public void callDetails() throws IOException {
		test.info("Click on the call details options.");
		try {
			clickOnElement(callDetailsButton);
			sleepTime();
			passCaseWithSC("Clicked on the callDetailsButton", "callDetailsButtonPass");
		} catch (Exception e) {
			failCase("callDetailsButton element is unable to locate.", "callDetailsButtonFail");
		}
		
	}
	
	public void deleteTheNumber() throws IOException {
		test.info("Click on the delete button.");
		try {
			clickOnElement(deleteNumber);
			sleepTime();
			passCaseWithSC("Clicked on the deleteNumber", "deleteNumberPass");
		} catch (Exception e) {
			failCase("deleteNumber element is unable to locate.", "deleteNumberFail");
		}
	}
	@FindBy(xpath="//android.widget.TextView[@resource-id='com.android.dialer:id/bottom_nav_item_text' and @text='Contacts']")
	WebElement contactsPage;
	
	public void traverseContactPage() throws IOException {
		test.info("Click on the contacts button.");
		try {
			clickOnElement(contactsPage);
			sleepTime();
			passCaseWithSC("Clicked on the contactsPage", "contactsPagePass");
		} catch (Exception e) {
			failCase("contactsPage element is unable to locate.", "contactsPageFail");
		}
	}
	
}
