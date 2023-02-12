package ca.qaguru.oranghrmbatch27.tests;


import ca.qaguru.oranghrmbatch27.library.TestBase;
import ca.qaguru.oranghrmbatch27.pages.HeaderPage;
import ca.qaguru.oranghrmbatch27.pages.LoginPage;
import ca.qaguru.oranghrmbatch27.pages.MembershipsPage;
import ca.qaguru.oranghrmbatch27.pages.MenuOptions;
import org.testng.annotations.Test;

public class MembershipsTests extends TestBase {
    @Test(priority = 1)
    public void addNewMembership() {
        MembershipsPage membershipsPage = loginAndFetchMembershipsPage();
        membershipsPage.saveNewMembershipAndVerifyItsAdded("Level1");
    }

    @Test(priority = 2)
    public void updateMembership() throws Exception {
        MembershipsPage membershipsPage = loginAndFetchMembershipsPage();
        membershipsPage.updateMembershipAndVerifyIfChanged("Level1", "Level1-updated");
    }

    @Test(priority = 3)
    public void deleteMembership() throws Exception {
        MembershipsPage membershipsPage = loginAndFetchMembershipsPage();
        membershipsPage.deleteMembershipAndVerifyItsDeleted("Level1-updated");
    }

    private MembershipsPage loginAndFetchMembershipsPage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.MEMBERSHIPS);
        return new MembershipsPage(driver);
    }
}

