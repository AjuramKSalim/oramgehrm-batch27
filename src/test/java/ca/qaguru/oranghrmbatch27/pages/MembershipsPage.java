package ca.qaguru.oranghrmbatch27.pages;


import ca.qaguru.oranghrmbatch27.library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class MembershipsPage extends PageBase {
    WebDriver driver;
    private final String membershipAddButtonClassName = ".oxd-button--secondary";
    private final String membershipNameTextAreaCssSelector = "div[class='oxd-form-row'] input[class*='oxd-input']";
    private final String membershipSaveButtonXPath = "//button[@type='submit']";
    private final String membershipNameAlreadyExistsLabel = "//div[@class='oxd-form-row'] /div";
    private final String addMembershipCancelButtonXPath = "//div[@class='oxd-form-actions'] /button[1]";
    private final String membershipTableClassName = ".oxd-table-body";
    @FindBy(xpath = "//div[@class='oxd-table-body'] /div[@class='oxd-table-card']")
    private List<WebElement> membershipTableElements;

    public MembershipsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void saveNewMembershipAndVerifyItsAdded(String membershipName) {
        click(By.cssSelector(membershipAddButtonClassName));
        setText(By.cssSelector(membershipNameTextAreaCssSelector), membershipName);
        if (getText(By.xpath(membershipNameAlreadyExistsLabel)).contains("Already exists")) {
            click(By.xpath(addMembershipCancelButtonXPath));
        } else {
            click(By.xpath(membershipSaveButtonXPath));
        }
        Boolean match = membershipTableElements.stream().map(s -> s.getText()).anyMatch(s -> s.equalsIgnoreCase(membershipName));
        Assert.assertTrue(match);
        System.out.println("\n");
        System.out.println(membershipName + " is added successfully");
        System.out.println("\n");
    }
}
