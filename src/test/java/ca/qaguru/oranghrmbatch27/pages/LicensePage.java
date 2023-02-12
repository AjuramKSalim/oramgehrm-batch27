package ca.qaguru.oranghrmbatch27.pages;

import ca.qaguru.oranghrmbatch27.library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class LicensePage extends PageBase {
    WebDriver driver;
    private final String idLicAddBtn = ".oxd-button--secondary";
    private final String idLicTxtLevel=".oxd-input--active";
    private final String idLicSaveBtn="//button[@type='submit']";
    private final String lblAlreadyExistsMessage = "//div[@class='oxd-form-row'] /div";
    private final String getIdLicCancelBtn= "//div[@class='oxd-form-actions'] /button[1]";
    private final String tblLicense = ".oxd-table-body";
    private final String license = "//div[@class='oxd-table-body'] /div[@class='oxd-table-card']";
    @FindBy(xpath = license)
    private List<WebElement> listLicense;

    public LicensePage (WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void saveNewLicense(String license)
    {
        click(By.cssSelector(idLicAddBtn));
        setText(By.cssSelector(idLicTxtLevel), license);
        if (getText(By.xpath(lblAlreadyExistsMessage)).contains("Already exists")) {
            click(By.xpath(getIdLicCancelBtn));
        } else {
            click(By.xpath(idLicSaveBtn));
        }
        isElementVisible(By.cssSelector(tblLicense));

        for (WebElement License : listLicense) {
            String txtLicense = License.getText();
            System.out.println(txtLicense);

        }
        Boolean match = listLicense.stream().map(s -> s.getText()).anyMatch(s -> s.equalsIgnoreCase(license));
        Assert.assertTrue(match);
        System.out.println("\n");
        System.out.println(license + " is added successfully");
        System.out.println("\n");
    }
}
