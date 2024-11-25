package PagesImplementation;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CreationOfRepositoryPageImpl {


WebDriver driver;
By CREATEREPO=By.xpath("//*[text()='Create repository']");
        By CREATEREPONEW=By.xpath("//*[text()='New']");
        By REPONAME=By.xpath("//*[@data-testid='repository-name-input']");
        By REPOTYPE=By.xpath("//*[@value='%s']");
        By CHECKBOX=By.xpath("//*[@id=':ri:']");

    public CreationOfRepositoryPageImpl(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void newrepocreation(String name,String access) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        wait.until(ExpectedConditions.visibilityOfElementLocated(CREATEREPONEW));

driver.findElement(CREATEREPONEW).click();
driver.findElement(REPONAME).sendKeys((name));
String xpath = String.format("//*[@value='%s']", access);
WebElement element = driver.findElement(By.xpath(xpath));
        element.click();




        WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(10));
        waits.until(driver -> driver.findElement(By.xpath(xpath)).isSelected());
System.out.println(driver.findElement(By.xpath(xpath)).isSelected());

        WebElement checkbox = driver.findElement(CHECKBOX); // Locate the checkbox element
        if (!checkbox.isSelected()) { // Check if the checkbox is not already selected
            checkbox.click(); // Click to select it
        }

        waits.until(driver -> driver.findElement(CHECKBOX).isSelected());
        System.out.println(driver.findElement(CHECKBOX).isSelected());
//        WebElement repoButton = wait.until(ExpectedConditions.elementToBeClickable(CREATEREPO));
        if(driver.findElement(CREATEREPO).isDisplayed()){
        driver.findElement(CREATEREPO).click();}





    }
}
