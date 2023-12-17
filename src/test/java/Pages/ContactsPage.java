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

public class ContactsPage extends BasePage{
	
	ExtentTest test;
	public ContactsPage(ExtentTest test) throws MalformedURLException {
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
	
	@FindBy(xpath="//android.widget.TextView[@resource-id='com.android.dialer:id/bottom_nav_item_text' and @text='Contacts']")
	WebElement contactsPage;

	@FindBy(xpath="//android.widget.TextView[@resource-id='com.android.dialer:id/contact_name' and @text='Create new contact']")
	WebElement createContactButton;


	@FindBy(xpath="//android.widget.EditText[@text='First name']")
	WebElement firstName;

	@FindBy(xpath="//android.widget.EditText[@text='Last name']")
	WebElement lastName;

	@FindBy(xpath="//android.widget.EditText[@text='Phone']")
	WebElement phoneNumber;

	@FindBy(id="com.android.contacts:id/editor_menu_save_button")
	WebElement saveButton;

	//updatecontact.

	@FindBy(xpath="//android.widget.TextView[@content-desc='Edit']")
	WebElement editButton;

	@FindBy(xpath="//android.widget.EditText[@text='Email']")
	WebElement email;

	// moreOptions
	@FindBy(xpath="//android.widget.ImageButton[@content-desc='More options']")
	WebElement moreOptions;

	@FindBy(xpath="//android.widget.TextView[@resource-id='android:id/title' and @text='Delete']")
	WebElement deleteButton;

	@FindBy(xpath="//android.widget.Button[@resource-id='android:id/button1']")
	WebElement confirmDeleteButton;
	
	public void clickOnTheCreateNewContact() throws IOException {
		test.info("Click on the create contact button.");
		try {
			clickOnElement(createContactButton);
			sleepTime();
			passCaseWithSC("Clicked on the create contact button", "createContactButton");
		} catch (Exception e) {
			failCase("createContactButton element is unable to locate.", "createContactButtonFail");
		}
	}
	
	public void createANewContact() throws IOException {
		test.info("Fillout the form.");
		try {
			writeOnElement(firstName, "Sam");
			passCase("Entered the firstName");
		} catch (Exception e) {
			failCase("FirstName element is unable to locate.", "FirstNameFail");
		}
		
		try {
			writeOnElement(lastName, "Bahadur");
			passCase("Entered the lastName");
		} catch (Exception e) {
			failCase("lastName element is unable to locate.", "lastNameFail");
		}
		
		try {
			writeOnElement(phoneNumber, "01628477298");
			passCaseWithSC("Entered the Phone Number.", "phoneNumberPass");
			
		} catch (Exception e) {
			failCase("phoneNumber element is unable to locate.", "phoneNumberFail");
		}
	
		test.info("Save the contact");
		try {
			clickOnElement(saveButton);
			sleepTime();
			passCaseWithSC("Save a new contact.", "saveButton");
		} catch (Exception e) {
			failCase("saveButton element is unable to locate.", "saveButtonFail");
		}
	}
	
	public void updateTheContact() throws IOException {
		test.info("Click on the Edit button.");
		try {
			clickOnElement(editButton);
			sleepTime();
			passCaseWithSC("clicked on the editButton", "editButtonPass");
		} catch (Exception e) {
			failCase("editButton element is unable to locate.", "editButtonFail");
		}

		test.info("Click on the Edit button.");
		try {
			writeOnElement(email, "abc@gmail.com");
			sleepTime();
			passCaseWithSC("Entered the email address", "emailPass");
		} catch (Exception e) {
			failCase("The Email element is unable to locate.", "emailFail");
		}
		
		test.info("Click on the edit button.");
		try {
			clickOnElement(saveButton);
			sleepTime();
			passCaseWithSC("Save a new contact.", "saveButton");
		} catch (Exception e) {
			failCase("saveButton element is unable to locate.", "saveButtonFail");
		}
	}
	
	public void deleteTheContact() throws IOException {
		test.info("Click on the more options button.");
		try {
			clickOnElement(moreOptions);
			sleepTime();
			passCaseWithSC("Clicked on the moreOptions button.", "moreOptionsPass");
		} catch (Exception e) {
			failCase("The moreOptions element is unable to locate.", "moreOptionsFail");
		}
		
		test.info("Click on the more delete button.");
		try {
			clickOnElement(deleteButton);
			sleepTime();
			passCaseWithSC("Clicked on the deleteButton button.", "deleteButtonPass");
		} catch (Exception e) {
			failCase("The deleteButton element is unable to locate.", "deleteButtonFail");
		}
		
		test.info("Click on the more confirm delete button.");
		try {
			clickOnElement(confirmDeleteButton);
			sleepTime();
			passCaseWithSC("Clicked on the confirmDelete button.", "confirmDeleteButtonPass");
		} catch (Exception e) {
			failCase("The confirmDeleteButton element is unable to locate.", "confirmDeleteButtonFail");
		}
	}
}
