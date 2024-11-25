package PagesImplementation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IssueTrackingImpl {

    WebDriver driver;

    By ISSUESTAB=By.xpath("//span[@data-content='Issues']");
    By NEWISSUES=By.xpath("//*[text()='New issue']");
    By ISSUETITLE=By.xpath("//*[@id='issue_title']");
    By ISSUEDESP=By.xpath("//*[@id='issue_body']");
    By SUBMITBUTTON=By.xpath("//button[contains(text(),'Submit new issue')]");
    By LABEL=By.xpath("//*[@data-menu-trigger='labels-select-menu']");
    By ASSIGNEE=By.xpath("//*[@data-menu-trigger='assignees-select-menu']");

    By LABELNAME=By.xpath("//*[@data-label-name='bug']");
    By ASSIGNEENAME=By.xpath("//span[@class='js-username']");


    public IssueTrackingImpl(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void issuetracking()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
       WebElement issuetab= wait.until(ExpectedConditions.visibilityOfElementLocated(ISSUESTAB));

        issuetab.click();

        WebElement newissues= wait.until(ExpectedConditions.visibilityOfElementLocated(NEWISSUES));

        newissues.click();
        WebElement title= wait.until(ExpectedConditions.visibilityOfElementLocated(ISSUETITLE));

        title.sendKeys("test title");

        WebElement issuedes= wait.until(ExpectedConditions.visibilityOfElementLocated(ISSUEDESP));

        issuedes.sendKeys("test description");

        WebElement submit= wait.until(ExpectedConditions.visibilityOfElementLocated(SUBMITBUTTON));

        submit.click();

    }
    public void labelandassignee(String labelname)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        WebElement label= wait.until(ExpectedConditions.visibilityOfElementLocated(LABEL));

        label.click();
        String xpath = String.format("//span[@class='name js-label-name-html' and text()='%s']", labelname);
        WebElement element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        element.click();
        System.out.println(labelname);
        label.click();


        WebElement assignee= wait.until(ExpectedConditions.visibilityOfElementLocated(ASSIGNEE));
        assignee.click();
        WebElement assigneename= wait.until(ExpectedConditions.visibilityOfElementLocated(ASSIGNEENAME));
        assigneename.click();
        System.out.println(labelname);
        assignee.click();




    }

}
