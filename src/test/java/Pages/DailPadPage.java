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

public class DailPadPage extends BasePage{
	ExtentTest test;
	public DailPadPage(ExtentTest test) throws MalformedURLException {
		PageFactory.initElements(getDriver(), this);
		this.test = test;
	}
	
	//locating the Element.
	@FindBy(xpath="//android.widget.ImageButton[@content-desc='key pad']")
	WebElement keyPad;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id='com.android.dialer:id/dialpad_key_number' and @text='0']")
	WebElement zero;

	@FindBy(xpath="//android.widget.TextView[@resource-id='com.android.dialer:id/dialpad_key_number' and @text='1']")
	WebElement one;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id='com.android.dialer:id/dialpad_key_number' and @text='2']")
	WebElement two;

	@FindBy(xpath="//android.widget.TextView[@resource-id='com.android.dialer:id/dialpad_key_number' and @text='3']")
	WebElement three;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id='com.android.dialer:id/dialpad_key_number' and @text='4']")
	WebElement four;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id='com.android.dialer:id/dialpad_key_number' and @text='5']")
	WebElement five;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id='com.android.dialer:id/dialpad_key_number' and @text='6']")
	WebElement six;

	@FindBy(xpath="//android.widget.TextView[@resource-id='com.android.dialer:id/dialpad_key_number' and @text='7']")
	WebElement seven;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id='com.android.dialer:id/dialpad_key_number' and @text='7']")
	WebElement eight;
	
	@FindBy(xpath="//android.widget.ImageButton[@content-desc='dial']")
	WebElement dialButton;
	
	// if case has been failed, this method will run and generate ss.
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
	
	
	public void openKeyPad() throws InterruptedException, IOException {
		test.info("Click on the dial pad option.");
		try {
			if(keyPad.isDisplayed()) {
				keyPad.click();
				sleepTime();
				System.out.println("Pass");
				passCaseWithSC("Keypad option is selected properly.", "keyPadPass");
			}
		} catch (Exception e) {
			failCase("keyPad element is unable to locate.", "KeypadFail");
		}
		
	}
	
	public void enterKeyNumber() throws IOException {
		test.info("Enter the number.");
		try {
			clickOnElement(zero);
			sleepTime();
			passCaseWithSC("Zero option is selected properly.", "zeroPass");
		} catch (Exception e) {
			failCase("zero element is unable to locate.", "ZeroFail");
		}
		
		try {
			clickOnElement(one);
			sleepTime();
			passCaseWithSC("one option is selected properly.", "onePass");
		} catch (Exception e) {
			failCase("one element is unable to locate.", "oneFail");
		}
		try {
			clickOnElement(six);
			passCaseWithSC("six option is selected properly.", "sixPass");
		} catch (Exception e) {
			failCase("six element is unable to locate.", "sixFail");
		}
		try {
			clickOnElement(two);
			passCaseWithSC("two option is selected properly.", "twoPass");
		} catch (Exception e) {
			failCase("two element is unable to locate.", "twoFail");
		}
		try {
			clickOnElement(three);
			passCaseWithSC("three option is selected properly.", "threePass");
		} catch (Exception e) {
			failCase("three element is unable to locate.", "threeFail");
		}
		try {
			clickOnElement(four);
			passCaseWithSC("four option is selected properly.", "fourPass");
		} catch (Exception e) {
			failCase("four element is unable to locate.", "fourFail");
		}
		try {
			clickOnElement(eight);
			passCaseWithSC("eight option is selected properly.", "eightPass");
		} catch (Exception e) {
			failCase("eight element is unable to locate.", "eightFail");
		}
		try {
			clickOnElement(seven);
			passCaseWithSC("seven option is selected properly.", "sevenPass");
		} catch (Exception e) {
			failCase("seven element is unable to locate.", "sevenFail");
		}
		try {
			clickOnElement(zero);
			passCaseWithSC("Zero option is selected properly.", "zeroPass");
		} catch (Exception e) {
			failCase("zero element is unable to locate.", "ZeroFail");
		}
		
		try {
			clickOnElement(four);
			passCaseWithSC("four option is selected properly.", "fourPass");
		} catch (Exception e) {
			failCase("four element is unable to locate.", "fourFail");
		}
		try {
			clickOnElement(eight);
			passCaseWithSC("eight option is selected properly.", "eightPass");
		} catch (Exception e) {
			failCase("eight element is unable to locate.", "eightFail");
		}
		try {
			clickOnElement(seven);
			passCaseWithSC("seven option is selected properly.", "sevenPass");
		} catch (Exception e) {
			failCase("seven element is unable to locate.", "sevenFail");
		}
		
		
	}

	public void callTheNumber() throws IOException {
		test.info("Click on the dialButton to make call.");
		try {
			clickOnElement(dialButton);
			sleepTime();
			passCaseWithSC("Clicked on the dial button", "dialButtonPass");
		} catch (Exception e) {
			failCase("dialButton element is unable to locate.", "dialButtonFail");
		}
	}
}
