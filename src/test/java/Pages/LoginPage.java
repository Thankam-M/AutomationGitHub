package Pages;

import org.openqa.selenium.By;

public interface LoginPage {
    public void signup(String email, String password);
    By CREATE_ACCOUNT=By.xpath("//*[text()= 'Create an account']");


}
