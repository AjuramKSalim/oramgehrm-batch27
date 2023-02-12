package ca.qaguru.oranghrmbatch27.tests;

import ca.qaguru.oranghrmbatch27.library.TestBase;
import ca.qaguru.oranghrmbatch27.pages.*;
import org.testng.annotations.Test;

import java.util.UUID;

public class PaygradesTests extends TestBase {


    @Test
    public void addNewPaygrades() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.PAY_GRADES);
        PaygradesPage PaygradesPage = new PaygradesPage (driver);
        PaygradesPage.SaveNewPayGrade("Level1");
        String uuid = UUID.randomUUID().toString();
        PaygradesPage.SaveNewPayGrade("Level1"+ uuid);
    }
}
