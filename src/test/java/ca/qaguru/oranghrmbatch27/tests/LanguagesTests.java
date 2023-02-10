package ca.qaguru.oranghrmbatch27.tests;

import ca.qaguru.oranghrmbatch27.library.TestBase;
import ca.qaguru.oranghrmbatch27.pages.HeaderPage;
import ca.qaguru.oranghrmbatch27.pages.LanguagesPage;
import ca.qaguru.oranghrmbatch27.pages.LoginPage;
import ca.qaguru.oranghrmbatch27.pages.MenuOptions;
import org.testng.annotations.Test;

import java.util.UUID;

public class LanguagesTests extends TestBase {
    @Test
    public void addNewLanguages() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.LANGUAGES);
        LanguagesPage languagesPage = new LanguagesPage(driver);
        languagesPage.saveNewLanguages("Malayalam");
        String uuid = UUID.randomUUID().toString();
        languagesPage.saveNewLanguages("Hindi" + uuid);
    }
}
