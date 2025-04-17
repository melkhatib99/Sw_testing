package base;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;

import java.time.Duration;

public class Login {

    public static void performValidLogin(WebDriver driver) {
        LoginPage loginPage = new LoginPage(driver);
//        driver.get("https://www.saucedemo.com/");
        loginPage.enterusername("standard_user");
        loginPage.enterpassword("secret_sauce");
        loginPage.clicklogin();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}
