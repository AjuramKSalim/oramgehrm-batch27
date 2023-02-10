package ca.qaguru.oranghrmbatch27.pages;

import ca.qaguru.oranghrmbatch27.library.PageBase;
import org.apache.commons.codec.language.bm.Languages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.List;
public class LanguagesPage extends PageBase {
    WebDriver driver;
    private final String idLanAddBtn = ".oxd-button--secondary";

    private final String idLanTxtLevel = "div[class='oxd-form-row'] input[class*='oxd-input']";

    private final String idLanSaveBtn = "//button[@type='submit']";
    private final String lblAlreadyExistsMessage = "//div[@class='oxd-form-row'] /div";
    private final String getIdLanCancelBtn = "//div[@class='oxd-form-actions'] /button[1]";
    private final String tblLanguages = ".oxd-table-body";
    private final String languages = "//div[@class='oxd-table-body'] /div[@class='oxd-table-card']";
    @FindBy(xpath = languages)
    private List<WebElement> listLanguages;

    public LanguagesPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void saveNewLanguages(String languagesName) {
        click(By.cssSelector(idLanAddBtn));
        setText(By.cssSelector(idLanTxtLevel), languagesName);
        if (getText(By.xpath(lblAlreadyExistsMessage)).contains("Already exists")) {
            click(By.xpath(getIdLanCancelBtn));
        } else {
            click(By.xpath(idLanSaveBtn));
        }
        isElementVisible(By.cssSelector(tblLanguages));
        for (WebElement Languages : listLanguages) {
            String txtLanguages = Languages.getText();
            System.out.println(txtLanguages);
        }
        Boolean match = listLanguages.stream().map(s -> s.getText()).anyMatch(s -> s.equalsIgnoreCase(languagesName));
        Assert.assertTrue(match);
        System.out.println("\n");
        System.out.println(languagesName + " is added successfully");
        System.out.println("\n");
    }
}