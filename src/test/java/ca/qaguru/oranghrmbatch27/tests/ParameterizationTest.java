package ca.qaguru.oranghrmbatch27.tests;

import org.testng.annotations.Test;

public class ParameterizationTest {
    @Test(dataProvider = "LoginInfo", dataProviderClass = ca.qaguru.oranghrmbatch21.tests.ParameterizationTestData.class)
    public void sampleTest(String username, String password){
        System.out.println("Username : "+ username + " Password: "+ password);
    }
}
