package ca.qaguru.oranghrmbatch27.tests;
import ca.qaguru.oranghrmbatch27.library.TestBase;
import ca.qaguru.oranghrmbatch27.pages.*;
import org.testng.annotations.Test;
import java.util.Random;
import java.util.UUID;
public class EmploymentStatusTests extends TestBase {
    @Test
    public void addNewEmploymentAndVerifyIsDisplayed() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.EMPLOYMENT_STATUS);
        EmploymentStatusPage employmentStatusPage = new EmploymentStatusPage(driver);
        UUID uuid = UUID.randomUUID();
        employmentStatusPage.addEmploymentStatus("Freelance" + uuid.toString());
    }
}
