package ca.qaguru.oranghrmbatch27.tests;

import ca.qaguru.oranghrmbatch27.library.TestBase;
import ca.qaguru.oranghrmbatch27.pages.*;
import org.testng.annotations.Test;

import java.util.UUID;

public class JobTitleTest extends TestBase {

    @Test
    public void addNewJob( ) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.JOB_TITLES);


        JobTitlePage jobPage = new JobTitlePage(driver);
        jobPage.saveNewJob("Quality Engineer");
       // String uuid = UUID.randomUUID().toString();
        //String jobname= "JobTitle Test " + uuid;
       // jobPage.saveNewJob(jobname);
    }

}
