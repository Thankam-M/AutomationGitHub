package PagesImplementation;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.Map;

import java.time.Duration;

import Pages.DataTableConfig;

public class LoginPageImpl {

    WebDriver driver;

    By CREATE_ACCOUNT=By.xpath("//*[text()= 'Create an account']");
    By EMAIL=By.xpath("//*[@type='email']");
    By PASSWORD=By.xpath("//*[@type='password']");
    By CONTINUE=By.xpath("//*[contains(text(), 'Continue')]");
    By CONTINUEPASS=By.xpath("//*[@data-continue-to='username-container']");
    By CONTINUEUSERNAME=By.xpath("//*[@data-continue-to='captcha-and-submit-container']");
    By PASSWORDSTRONG=By.xpath("//*[contains(text(), 'Password is strong')]");
By LOGINUSER=By.xpath("//*[@name='login']");
By PASSWORDUSER=By.xpath("//*[@name='password']");
By SIGNIN=By.xpath("//*[@value='Sign in']");
By SIGNUPUSER=By.xpath("//*[@id='login']");
By EMAILERRORMESSAGE=By.xpath("//*[text()='Email is invalid or already taken']");
    By PASSWORDSHORT=By.xpath("//*[contains(text(), 'Password is too short')]");

    By USERNAMEERRORMSG=By.xpath("//*[@class='m-1']//*[@class='mb-1']");
    By PROFILE=By.xpath("//*[@class='avatar circle']");
    By SIGNOUT=By.xpath("//*[text()='Sign out']");


    public LoginPageImpl(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }



    public void signup(String email, String password,String username) {


        // Wait for the "Create an account" link to be clickable and click it
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       WebElement createAccountButton = wait.until(ExpectedConditions.elementToBeClickable(CREATE_ACCOUNT));
       createAccountButton.click();
        driver.findElement(CREATE_ACCOUNT).click();
//
//        // Wait for the email and password fields to be visible and enter values
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(EMAIL));
        emailField.sendKeys(email);  // Use the dynamic email here



       WebElement cc = wait.until(ExpectedConditions.elementToBeClickable(CONTINUE));
        cc.click();

//
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD));
        passwordField.sendKeys(password);

        WebElement passwordstrong = wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORDSTRONG));


       Assert.assertEquals(passwordstrong.getText(),"Password is strong");
      WebElement dd=  wait.until(ExpectedConditions.elementToBeClickable(CONTINUEPASS));
        dd.click();

        WebElement usernamefield=wait.until(ExpectedConditions.visibilityOfElementLocated(SIGNUPUSER));
        usernamefield.sendKeys(username);

        WebElement ff=wait.until(ExpectedConditions.elementToBeClickable(CONTINUEUSERNAME));
        ff.click();


    }


    public void signupwithinvaliddetails(Map<String, String> map) {


        // Wait for the "Create an account" link to be clickable and click it
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement createAccountButton = wait.until(ExpectedConditions.elementToBeClickable(CREATE_ACCOUNT));
        createAccountButton.click();
        driver.findElement(CREATE_ACCOUNT).click();

        String Invalidemail = DataTableConfig.TableValues(map,"Invalidemail");
        String Validemail = DataTableConfig.TableValues(map,"Validemail");
        String Invalidpassword = DataTableConfig.TableValues(map,"InvalidPassword");
        String Validpassword = DataTableConfig.TableValues(map,"ValidPassword");
        String Invalidusername = DataTableConfig.TableValues(map,"Invalidusername");
        String Validusername = DataTableConfig.TableValues(map,"ValidUsername");



//        // Wait for the email and password fields to be visible and enter values
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(EMAIL));
        emailField.sendKeys(Invalidemail);

        WebElement emailerrormsg = wait.until(ExpectedConditions.visibilityOfElementLocated(EMAILERRORMESSAGE));

        Assert.assertEquals(emailerrormsg.getText(),"Email is invalid or already taken");

        emailField.clear();

        emailField.clear();

        emailField.clear();


        emailField.sendKeys(Validemail);







        WebElement cc = wait.until(ExpectedConditions.elementToBeClickable(CONTINUE));
        cc.click();

//
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD));
        passwordField.sendKeys(Invalidpassword);

        WebElement passwordshort = wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORDSHORT));


        Assert.assertEquals(passwordshort.getText(),"Password is too short");
        passwordField.clear();
        passwordField.sendKeys(Validpassword);
        WebElement dd=  wait.until(ExpectedConditions.elementToBeClickable(CONTINUEPASS));
        dd.click();


        WebElement usernamefield=wait.until(ExpectedConditions.visibilityOfElementLocated(SIGNUPUSER));
        usernamefield.sendKeys(Invalidusername);
        WebElement usernameerror = wait.until(ExpectedConditions.visibilityOfElementLocated(USERNAMEERRORMSG));

       Assert.assertEquals(usernameerror.getText(),"Username "+ Invalidusername +" is not available.");
        usernamefield.clear();
        usernamefield.sendKeys(Validusername);
        WebElement ff=wait.until(ExpectedConditions.elementToBeClickable(CONTINUEUSERNAME));
        ff.click();






    }

    public void login(String email, String password) {
        driver.findElement(LOGINUSER).sendKeys(email);
        driver.findElement(PASSWORDUSER).sendKeys(password);
        driver.findElement(SIGNIN).click();
    }

    public void logout()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));

        WebElement profile= wait.until(ExpectedConditions.visibilityOfElementLocated(PROFILE));
        wait.until(ExpectedConditions.elementToBeClickable(PROFILE));
        profile.click();
        driver.findElement(SIGNOUT).click();
        driver.quit();
    }



}
