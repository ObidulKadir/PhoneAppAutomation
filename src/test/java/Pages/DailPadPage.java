package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static BaseFolder.driverSetup.getDriver;

import java.net.MalformedURLException;

public class DailPadPage {
	
	public DailPadPage() throws MalformedURLException {
		PageFactory.initElements(getDriver(), this);
	}
	
	//locating the Element.
	@FindBy(xpath="//android.widget.ImageButton[@content-desc='key pad']")
	WebElement keyPad;
	
	
	public void openKeyPad() throws InterruptedException {
		System.out.println("LOL");
	}
}
