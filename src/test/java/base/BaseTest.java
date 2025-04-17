package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import static base.Login.*;

public class BaseTest {

    protected WebDriver CH;


    @BeforeClass

    public void preconditions(){
        CH = new ChromeDriver();
        CH.manage().window().maximize();
        CH.get("https://www.saucedemo.com/");
        CH.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        performValidLogin(CH);

    }

}

