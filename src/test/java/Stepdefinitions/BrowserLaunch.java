package Stepdefinitions;

import PagesImplementation.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.cucumber.datatable.DataTable;

public class BrowserLaunch {

    WebDriver driver;
    LoginPageImpl Signup;
    LoginPageImpl Login;
    CreationOfRepositoryPageImpl createrepo;
    IssueTrackingImpl createissues;
    LoginPageImpl invalidcreds;
        BranchCreationImpl newbranch;
        PullrequestImpl pullreq;
        LoginPageImpl Logout;



    @Given("user launches the browser {string} and github url {string}")
    public void user_launches_the_browser_and_github_url(String browser, String url) throws InterruptedException {


        if (browser.equals("chrome")) {


            driver = new ChromeDriver();


        } else if (browser.equals("firefox")) {


            driver = new FirefoxDriver();

        } else {
            System.out.println("Please provide a proper browser value..");
        }

        driver.manage().window().maximize();
        driver.navigate().to(url);

    }


    @Given("user creates a new account using username {string} and password {string} and ueername {string}")
    public void user_creates_a_new_account_using_username_and_password_and_ueername(String email, String password, String username) {

        System.out.println("Creating new account with email: " + username + " and password: " + password);

        // Initialize the LoginPageImpl object
        Signup = new LoginPageImpl(driver);
        Signup.signup(email, password,username);

        System.out.println("Signup process completed");
    }

    @Given("validate whether invalid credentials throw error message")
    public void validate_whether_invalid_credentials_throw_error_message(DataTable dt) {
invalidcreds=new LoginPageImpl(driver);
invalidcreds.signupwithinvaliddetails(dt.asMap(String.class, String.class));
    }



    @Given("user login into github application using username {string} and password {string}")
    public void user_login_into_github_application_using_username_and_password(String username, String password) {
        Login = new LoginPageImpl(driver);
        Login.login(username, password);

    }


    @Given("user creates a new repository {string} with {string} access")
    public void user_creates_a_new_repository_with_access(String name,String access)throws InterruptedException   {
        createrepo=new CreationOfRepositoryPageImpl(driver);
        createrepo.newrepocreation(name,access);
    }

    @Given("user creates issues for the repo")
    public void user_creates_issues_for_the_repo() {
        createissues=new IssueTrackingImpl(driver);
        createissues.issuetracking();
    }
    @Given("user creates label type {string} and assignee as the owner")
    public void user_creates_label_type_and_assignee_as_the_owner(String labelname) {
       createissues.labelandassignee(labelname);
    }

    @Given("user creates a new branch {string}")
    public void user_creates_a_new_branch(String string) {
        newbranch=new BranchCreationImpl(driver);
        newbranch.newbranchcreation(string);
    }

    @Given("user creates pull requests for the  {string} to main branch")
    public void user_creates_pull_requests_for_the_to_main_branch(String string) {
       pullreq=new PullrequestImpl(driver);
       pullreq.createpullrequest(string);
    }

    @Given("user logout of the application")
    public void user_logout_of_the_application() {
        Logout = new LoginPageImpl(driver);
        Logout.logout();
    }


}

