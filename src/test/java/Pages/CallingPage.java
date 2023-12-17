package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import Utility.getScreenShot;

import static BaseFolder.driverSetup.getDriver;

import java.io.IOException;
import java.net.MalformedURLException;

public class CallingPage extends BasePage{
	
	ExtentTest test;
	public CallingPage(ExtentTest test) throws MalformedURLException {
		PageFactory.initElements(getDriver(), this);
		this.test = test;
	}
	//locating 
	@FindBy(xpath="//android.widget.LinearLayout[@content-desc='Speaker, is on']/android.widget.ImageView")
	WebElement speaker;

	@FindBy(xpath="//android.widget.LinearLayout[@content-desc='Unmuted']/android.widget.ImageView")
	WebElement unmute;

	@FindBy(id="com.android.dialer:id/incall_end_call")
	WebElement endCall;
	
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
		
		
		public void speakerOn() throws IOException {
			test.info("Click on the speaker button.");
			try {
				clickOnElement(speaker);
				sleepTime();
				passCaseWithSC("Clicked on the Speaker", "SpeakerPass");
			} catch (Exception e) {
				failCase("Spaker element is unable to locate.", "SpeakerFail");
			}
		}
		
		public void muteOn() throws IOException {
			test.info("Clic on the mute button.");
			try {
				clickOnElement(unmute);
				sleepTime();
				passCaseWithSC("Clicked on the unmute", "unmutePass");
			} catch (Exception e) {
				failCase("unmute element is unable to locate.", "unmuteFail");
			}
		}
		
		public void endCall() throws IOException {
			test.info("Clic on the endCall button.");
			try {
				clickOnElement(endCall);
				sleepTime();
				passCaseWithSC("Clicked on the endCall", "endCallPass");
			} catch (Exception e) {
				failCase("endCall element is unable to locate.", "endCallFail");
			}
		}
		
		
	
	

}
