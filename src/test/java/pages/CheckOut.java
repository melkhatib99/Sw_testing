package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOut {
    WebDriver CH;

    public CheckOut(WebDriver CH) {
        this.CH = CH;
    }

     //locators
     By CheckOut = By.id("checkout");

     By ViewCart = By.className("shopping_cart_link");
     By FirstName = By.id("first-name");
    By LastName = By.id("last-name");
    By ZipCode  = By.id("postal-code");
    By Continue = By.id("continue");
    By cancel = By.id("cancel");

    //Methods

    public void enterfirstname(String Username ){

        CH.findElement(FirstName).sendKeys(Username);

    }

    public void enterlastname(String lastname ){

        CH.findElement(LastName).sendKeys(lastname);
    }

    public void enterZipcode(String number){

        CH.findElement(ZipCode).sendKeys(number); ;
    }

    public void checkout(){

        CH.findElement(CheckOut).click();
    }

     public void cartview(){
        CH.findElement(ViewCart).click();

     }

     public void continuee (){
        CH.findElement(Continue).click();

     }









}
