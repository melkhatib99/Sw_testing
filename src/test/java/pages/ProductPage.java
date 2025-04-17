package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {

    WebDriver CH ;


    public ProductPage(WebDriver CH) {
        this.CH = CH;
    }

    //locators

    By BackBag = By.id("add-to-cart-sauce-labs-backpack");
    By BikeLight = By.id("add-to-cart-sauce-labs-bike-light");
    By T_shirt = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    By Jacket = By.id("add-to-cart-sauce-labs-fleece-jacket");
    By cart_button =By.className("shopping_cart_link");



    public void AddBack(){

        CH.findElement(BackBag).click();

    }
    public void  cart_button(){

        CH.findElement(cart_button).click();

    }
    public void AddBike(){

        CH.findElement(BikeLight).click();

    }
    public void AddT_shirt(){

        CH.findElement(T_shirt).click();

    }
    public void AddJacket(){

        CH.findElement(Jacket).click();

    }


    public boolean isOnProductPage() {
        try {
            // Example: Check for a product list container or a specific heading
            return CH.findElement(By.id("product-container")).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }


}
