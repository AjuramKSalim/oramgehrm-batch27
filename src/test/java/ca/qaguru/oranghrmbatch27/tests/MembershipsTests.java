package ca.qaguru.oranghrmbatch27.tests;


import ca.qaguru.oranghrmbatch27.library.TestBase;
import ca.qaguru.oranghrmbatch27.pages.*;
import org.testng.annotations.Test;

import java.util.UUID;

public class MembershipsTests extends TestBase {
@Test
public void addNewMembership() {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.login("admin", "admin123", true, null);
    HeaderPage headerPage = new HeaderPage(driver);
    headerPage.selectMenu(MenuOptions.MEMBERSHIPS);
    MembershipsPage membershipsPage = new MembershipsPage(driver);
    membershipsPage.saveNewMemberships("Level1");
    String uuid = UUID.randomUUID().toString();
    membershipsPage.saveNewMemberships("level2 " + uuid);
}
}

