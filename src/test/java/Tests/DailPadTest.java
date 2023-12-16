package Tests;

import java.io.IOException;

import org.testng.annotations.Test;

import BaseFolder.driverSetup;
import Pages.DailPadPage;

@Test
public class DailPadTest extends driverSetup{
	@Test
	public void openDialPadeOptionTest() throws IOException, InterruptedException {
		DailPadPage dailPad = new DailPadPage();
		dailPad.openKeyPad();
	}
}
