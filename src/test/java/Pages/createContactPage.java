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

public class createContactPage extends BasePage{
	
	ExtentTest test;
	public createContactPage(ExtentTest test) throws MalformedURLException {
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
		
	//locating element.
	
	@FindBy(xpath="//android.widget.EditText[@text='First name']")
	WebElement firstName;

	@FindBy(xpath="//android.widget.EditText[@text='Last name']")
	WebElement lastName;

	@FindBy(id="com.android.contacts:id/editor_menu_save_button")
	WebElement saveButton;
	
	public void filluptheCreateContactForm() {
		test.info("Fillout the form.");
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
