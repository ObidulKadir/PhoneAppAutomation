package Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.appium.java_client.android.AndroidDriver;

public class getScreenShot {
	
	public static String capture(AndroidDriver driver, String screenShotName) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + screenShotName +".png";
		File destination = new File(dest);
		FileUtils.copyFile(source, destination);
		
		
		return dest;
	}

}
