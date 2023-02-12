package ca.qaguru.oranghrmbatch27.pages;

import ca.qaguru.oranghrmbatch27.library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;


public class PaygradesPage extends PageBase {

    WebDriver driver;
    private final String clickPaygradesAddButton = "oxd-button oxd-button--medium oxd-button--secondary";
    private final String enterPaygrade = "div[class='oxd-form-row'] input[class*='oxd-input']";
    private final String savePaygradeButton = "//button[@type='submit']";
    private final String alreadyExistsMessage = "//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']";
    private final String cancelButton = "oxd-button oxd-button--medium oxd-button--ghost";
    private final String tblPaygrade = ".oxd-table-body";
    private final String paygradesxpath = "//div[@class='oxd-table-body'] /div[@class='oxd-table-card']";

    @FindBy(xpath = paygradesxpath)
    private List<WebElement> listPaygrades;

    public PaygradesPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void SaveNewPayGrade(String paygrade) {
        click(By.cssSelector(clickPaygradesAddButton));
        setText(By.cssSelector(enterPaygrade), paygrade);
        if (getText(By.xpath(alreadyExistsMessage)).contains("Already exists")) {
            click(By.xpath(cancelButton));
        } else {
            click(By.xpath(savePaygradeButton));
        }
        isElementVisible(By.cssSelector(tblPaygrade));

        for (WebElement Paygrades : listPaygrades) {
            String txtPaygrades = Paygrades.getText();
            System.out.println(txtPaygrades);
        }
        Boolean match = listPaygrades.stream().map(s -> s.getText()).anyMatch(s -> s.equalsIgnoreCase(paygrade));
        Assert.assertTrue(match);
        System.out.println("\n");
        System.out.println(paygrade + " is added successfully");
        System.out.println("\n");
    }
}



