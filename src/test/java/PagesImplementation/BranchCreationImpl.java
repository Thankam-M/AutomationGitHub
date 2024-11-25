package PagesImplementation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BranchCreationImpl {

    WebDriver driver;


    By CODESTAB=By.xpath("//span[@data-content='Code']");
    By MAIN=By.xpath("//*[text()='main']");
    By ALLBRANCHES=By.xpath("//*[@class='Box-sc-g0xbh4-0 eMbEhH']");
    By NEWBRANCH =By.xpath("//*[text()='New branch']");
    By BRANCHNAME=By.xpath("//*[@class='Box-sc-g0xbh4-0 bZBlpz']//*[@type='text']");
    By CREATENEWBRANCH=By.xpath("//*[text()='Create new branch']");

    public BranchCreationImpl(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void newbranchcreation(String branch)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        WebElement codetab= wait.until(ExpectedConditions.visibilityOfElementLocated(CODESTAB));

        codetab.click();

        WebElement main= wait.until(ExpectedConditions.visibilityOfElementLocated(MAIN));

        main.click();
        WebElement allbranch= wait.until(ExpectedConditions.visibilityOfElementLocated(ALLBRANCHES));

        allbranch.click();

        WebElement newbranch= wait.until(ExpectedConditions.visibilityOfElementLocated(NEWBRANCH));

        newbranch.click();

        WebElement branchname= wait.until(ExpectedConditions.visibilityOfElementLocated(BRANCHNAME));

        branchname.sendKeys(branch);
        WebElement createnewbranchbutton= wait.until(ExpectedConditions.visibilityOfElementLocated(CREATENEWBRANCH));

        createnewbranchbutton.click();


    }


}
