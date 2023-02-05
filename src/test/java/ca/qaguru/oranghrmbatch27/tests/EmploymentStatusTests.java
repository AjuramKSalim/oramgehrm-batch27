package ca.qaguru.oranghrmbatch27.tests;

import ca.qaguru.oranghrmbatch27.library.TestBase;
import ca.qaguru.oranghrmbatch27.pages.*;
import org.testng.annotations.Test;

public class EmploymentStatusTests extends TestBase {


    @Test
    public void addNewEmploymentStatus() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.EMPLOYMENT_STATUS);
        EmploymentStatusPage employmentStatusPage = new EmploymentStatusPage(driver);
        employmentStatusPage.addEmploymentStatus("Freelance2");
    }
}
