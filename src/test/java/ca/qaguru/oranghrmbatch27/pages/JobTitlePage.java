package ca.qaguru.oranghrmbatch27.pages;
import ca.qaguru.oranghrmbatch27.library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.List;

public class JobTitlePage extends PageBase {
    WebDriver driver;

    private final String jobAddBtn = ".oxd-button--secondary";
    private final String jobTxtLevel="div[class='oxd-form-row'] input[class*='oxd-input']";
    private final String jobSaveBtn="//button[@type='submit']";
    private final String lblAlreadyExistsMessage = "//div[@class='oxd-form-row'] /div";
    private final String jobCancelBtn= "//div[@class='oxd-form-actions'] /button[1]";
    private final String tblJob = ".oxd-table-body";
    private final String jobs=" //div[contains(@class, 'oxd-table-body')]/div[contains(@class,'oxd-table-card')]";

    @FindBy(xpath = jobs)
    private List<WebElement> listJobs;

    public JobTitlePage(WebDriver driver) {
        super(driver);
        this.driver=driver;

        PageFactory.initElements(driver,this);
    }
    public void saveJobAndVerifyDisplayed(String jobName) {
        click(By.cssSelector(jobAddBtn));
        setText(By.cssSelector(jobTxtLevel), jobName);
        if (getText(By.xpath(lblAlreadyExistsMessage)).contains("Already exists")) {
            click(By.xpath(jobCancelBtn));
            System.out.println("The Job title is already exsts");
        } else {
            click(By.xpath(jobSaveBtn));
        }
        isElementVisible(By.cssSelector(tblJob) );

        for (WebElement Job : listJobs) {
            String txtEducation = Job.getText();
            System.out.println(txtEducation);
        }
        Boolean match = listJobs.stream().map(s -> s.getText()).anyMatch(s -> s.equalsIgnoreCase(jobName));
        Assert.assertTrue(match);
        System.out.println("\n");
        System.out.println(jobName + " is added successfully");
        System.out.println("\n");
    }

    public void deleteAndVerifyJob(String jobName) {
        isElementVisible(By.cssSelector(tblJob));
        for (WebElement Job : listJobs) {
            String txtEducation = Job.getText();
            if (txtEducation.equalsIgnoreCase(jobName)){
                System.out.println(txtEducation+" is available");
                clickDeleteIcon(jobName);
                break;
            }
            }
        Boolean match = listJobs.stream().map(s -> s.getText()).anyMatch(s -> s.equalsIgnoreCase(jobName));
        Assert.assertFalse(match);
        System.out.println("\n");
        System.out.println(jobName + " is deleted successfully");
        System.out.println("\n");
        }

    public void clickDeleteIcon(String jname){
        String btnxpath="//div[@class='oxd-table-row oxd-table-row--with-border' and .//div[text()='"+jname+"']]//button[1]";
        click(By.xpath(btnxpath));
        click(By.xpath("//*[@id='app']/div[3]/div/div/div/div[3]/button[2]"));
      }
}
