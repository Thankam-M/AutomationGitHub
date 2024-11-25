package PagesImplementation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class PullrequestImpl {
    WebDriver driver;

    By PULLREQUESTTAB=By.xpath("//*[@class='octicon octicon-git-pull-request UnderlineNav-octicon d-none d-sm-inline']");
    By CODESTAB=By.xpath("//span[@data-content='Code']");
    By MAIN=By.xpath("//*[text()='main']");
    By CREATEDBRANCH=By.xpath("//*[@id=':r9f:--label']");
    By EDITFILE=By.xpath("//*[@title='Edit file']");
    By TEXTBOX=By.xpath("//*[@role='textbox']");
    By COMMITCHANGESBUTTON=By.xpath("//*[text()='Commit changes...']");
    By COMMITBUTTON=By.xpath("//*[@class='prc-Button-Label-pTQ3x' and text()='Commit changes']");
    By NEWPR=By.xpath("//*[text()='New pull request']");
    By COMPARE=By.xpath("//*[text()='compare:']");
    By CREATEPR=By.xpath("//*[@class='js-details-target btn-primary btn']");
    By CREATEPRSECOND=By.xpath("//*[@class='hx_create-pr-button js-sync-select-menu-button btn-primary btn BtnGroup-item flex-auto']");
By DIALOGUEBOX=By.xpath("//*[@class='Dialog__Backdrop-sc-uaxjsn-0 hdmqIr']");
By MERGEPR=By.xpath("//*[@class='merge-box-button btn-group-merge rounded-left-2 btn btn-primary BtnGroup-item js-details-target hx_create-pr-button']");
By CONFIRMMERGE=By.xpath("//button[@type='submit' and contains(@class, 'btn btn-primary BtnGroup-item js-merge-commit-button')]");
By CONFIRMATIONMESSAGE=By.xpath("//*[text()='Pull request successfully merged and closed']");



    public PullrequestImpl(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void createpullrequest(String branch)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
        String xpathsnew = String.format("//*[@title='%s']", branch);
        WebElement selectbranchsnew= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathsnew)));
//        WebElement codetab= wait.until(ExpectedConditions.visibilityOfElementLocated(CODESTAB));
//
//        codetab.click();
//
//        WebElement main= wait.until(ExpectedConditions.visibilityOfElementLocated(MAIN));
//
//        main.click();
       // WebElement createdbranch= wait.until(ExpectedConditions.visibilityOfElementLocated(CREATEDBRANCH));

       // createdbranch.click();
        String xpath = String.format("//*[@title='%s']", branch);
        WebElement selectbranch= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));


        selectbranch.click();
        WebElement editfile= wait.until(ExpectedConditions.visibilityOfElementLocated(EDITFILE));

        editfile.click();
        WebElement textbox= wait.until(ExpectedConditions.visibilityOfElementLocated(TEXTBOX));

        textbox.sendKeys("TEST COMMIT");

        WebElement commit= wait.until(ExpectedConditions.visibilityOfElementLocated(COMMITCHANGESBUTTON));

        commit.click();

        WebElement commitchanges= wait.until(ExpectedConditions.visibilityOfElementLocated(COMMITBUTTON));

        commitchanges.click();
        WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(100));
       waits.until(ExpectedConditions.invisibilityOfElementLocated(DIALOGUEBOX));

        WebElement pullreq= waits.until(ExpectedConditions.elementToBeClickable(PULLREQUESTTAB));

        pullreq.click();
        pullreq.click();

        WebElement newpr= wait.until(ExpectedConditions.visibilityOfElementLocated(NEWPR));

        newpr.click();
        WebElement compare= wait.until(ExpectedConditions.visibilityOfElementLocated(COMPARE));

        compare.click();

        String xpaths = String.format("//*[text()='%s']", branch);
        WebElement selectbranchs= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpaths)));


        selectbranchs.click();

        WebElement createpr= wait.until(ExpectedConditions.visibilityOfElementLocated(CREATEPR));


        createpr.click();
        WebElement createprsecond= wait.until(ExpectedConditions.visibilityOfElementLocated(CREATEPRSECOND));


        createprsecond.click();
        WebElement mergepr= wait.until(ExpectedConditions.visibilityOfElementLocated(MERGEPR));


        mergepr.click();
        WebElement confirmmerge= wait.until(ExpectedConditions.visibilityOfElementLocated(CONFIRMMERGE));


        confirmmerge.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(CONFIRMATIONMESSAGE));
String msg=driver.findElement(CONFIRMATIONMESSAGE).getText();

        Assert.assertEquals(msg,"Pull request successfully merged and closed");

    }
}
