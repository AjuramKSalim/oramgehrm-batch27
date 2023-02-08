package ca.qaguru.oranghrmbatch27.pages;

import ca.qaguru.oranghrmbatch27.library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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
    // Method to Edit License
    public void editLicense(String oldlicense, String newText)
    {
       click(By.xpath("//div[text()='"+oldlicense+"']/ancestor::div[@class='oxd-table-card']/descendant::i[3]"));
       setText(By.cssSelector(idLicTxtLevel),newText);
        if (getText(By.xpath(lblAlreadyExistsMessage)).contains("Already exists")) {
            click(By.xpath(getIdLicCancelBtn));
        } else {
            click(By.xpath(idLicSaveBtn));
        }
        isElementVisible(By.cssSelector(tblLicense));
        for (WebElement License : listLicense)
        {
            String txtLicense = License.getText();
            System.out.println(txtLicense);
        }
        System.out.println("Edit button clicked\n\n");
    }
}
