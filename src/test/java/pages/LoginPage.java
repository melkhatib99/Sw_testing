package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver CH;

    public LoginPage(WebDriver CH) {
        this.CH = CH;
    }

    //locators
    By username = By.id("user-name");
    By password = By.id("password");
    By loginButton = By.id("login-button");


    //methods

    public void enterusername(String Username ){

        CH.findElement(username).sendKeys(Username);

    }

    public void enterpassword(String PW ){

        CH.findElement(password).sendKeys(PW);
    }

    public void clicklogin(){

        CH.findElement(loginButton).click();

    }





}





