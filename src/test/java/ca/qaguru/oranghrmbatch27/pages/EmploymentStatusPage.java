package ca.qaguru.oranghrmbatch27.pages;

import ca.qaguru.oranghrmbatch27.library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class EmploymentStatusPage extends PageBase {
    WebDriver driver;
    private final String employmentStatusAddButtonClassName = ".oxd-button--secondary";
    private final String employmentStatusTextAreaCssSelector = "div[class='oxd-form-row'] input[class*='oxd-input']";

    private final String employmentStatusTextAreaEditCssSelector = "div[class='oxd-form-row'] input[class*='oxd-input--active']";
    private final String employmentStatusSaveButtonXPath = "//button[@type='submit']";
    private final String employmentStatusAlreadyExistsLabel = "//div[@class='oxd-form-row'] /div";
    private final String employmentStatusCancelButtonXPath = "//div[@class='oxd-form-actions'] /button[1]";
    private final String employmentStatusEditButtonXPath = "//div[@class='oxd-table-cell-actions'] /button[2]";
    private final String employmentStatusDeleteButtonXPath = "//div[@class='oxd-table-cell-actions'] /button[1]";

    private final String employmentStatusTableXPath = "//div[@class='oxd-table-body'] /div[@class='oxd-table-card']";
    private final String employmentStatusDeleteConfirmButtonXPath = "//div[@class='orangehrm-modal-footer'] /button[2]";
    private final String employmentStatusTableClassName = ".oxd-table-body";
    @FindBy(xpath = employmentStatusTableXPath)
    private List<WebElement> employmentStatusTableElements;

    public EmploymentStatusPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addEmploymentStatus(String employmentStatus) {
        click(By.cssSelector(employmentStatusAddButtonClassName));
        setText(By.cssSelector(employmentStatusTextAreaCssSelector), employmentStatus);
        if (getText(By.xpath(employmentStatusAlreadyExistsLabel)).contains("Already exists")) {
            click(By.xpath(employmentStatusCancelButtonXPath));
        } else {
            click(By.xpath(employmentStatusSaveButtonXPath));
        }
        isElementVisible(By.cssSelector(employmentStatusTableClassName));
        Boolean match = employmentStatusTableElements.stream().map(s -> s.getText()).anyMatch(s -> s.equalsIgnoreCase(employmentStatus));
        Assert.assertTrue(match);
        System.out.println("\n");
        System.out.println(employmentStatus + " is added successfully");
        System.out.println("\n");
    }
}
