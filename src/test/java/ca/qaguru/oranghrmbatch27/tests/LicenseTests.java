package ca.qaguru.oranghrmbatch27.tests;

import ca.qaguru.oranghrmbatch27.library.TestBase;
import ca.qaguru.oranghrmbatch27.pages.*;
import org.testng.annotations.Test;

import java.util.UUID;

public class LicenseTests extends TestBase {
    @Test
    public void addNewLicense() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.LICENSES);
        LicensePage licensePage = new LicensePage(driver);
        licensePage.saveNewLicense("ISO-2005");
        String uuid = UUID.randomUUID().toString();
        licensePage.saveNewLicense("ISO-2005" + uuid);
    }

}
