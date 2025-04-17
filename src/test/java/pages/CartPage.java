package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    WebDriver CH;
    WebDriverWait wait;

    public CartPage(WebDriver CH) {
        this.CH = CH;
        this.wait = new WebDriverWait(CH, Duration.ofSeconds(10)); // Explicit wait
    }

    // Locators
    private By CheckOut = By.id("checkout");
    private By ContinueShopping = By.id("continue-shopping");
    private By RemoveBackpack = By.id("remove-sauce-labs-backpack");
    private By RemoveBike = By.id("remove-sauce-labs-bike-light");
    private By RemoveTshirt = By.id("remove-sauce-labs-bolt-t-shirt");
    private By RemoveJacket = By.id("remove-sauce-labs-fleece-jacket");
    private By RemoveOnesie = By.id("remove-sauce-labs-onesie");
    private By RemoveRed = By.id("remove-test.allthethings()-t-shirt-(red)");
    private By CartBadge = By.className("shopping_cart_badge");
    private By CartLink = By.className("shopping_cart_link");
    private By continue_shopping =By.id("continue-shopping");

    // Methods
    public void COut() {
        wait.until(ExpectedConditions.elementToBeClickable(CheckOut)).click();
    }

    public void Rback() {
        wait.until(ExpectedConditions.elementToBeClickable(RemoveBackpack)).click();
    }

    public void Rbike() {
        wait.until(ExpectedConditions.elementToBeClickable(RemoveBike)).click();
    }

    public void Rshirt() {
        wait.until(ExpectedConditions.elementToBeClickable(RemoveTshirt)).click();
    }

    public void Rjacket() {
        wait.until(ExpectedConditions.elementToBeClickable(RemoveJacket)).click();
    }

    public void Ronesie() {
        wait.until(ExpectedConditions.elementToBeClickable(RemoveOnesie)).click();
    }

    public void Rred() {
        wait.until(ExpectedConditions.elementToBeClickable(RemoveRed)).click();
    }

    public void cart() {
        wait.until(ExpectedConditions.elementToBeClickable(CartLink)).click();
    }
    public void Continue_shopping() {
        wait.until(ExpectedConditions.elementToBeClickable(continue_shopping)).click();
    }

    public int getCartItemCount() {
        try {
            return Integer.parseInt(CH.findElement(CartBadge).getText());
        } catch (Exception e) {
            return 0;
        }
    }


    public void waitForCartToUpdate(int expectedCount) {
        wait.until(ExpectedConditions.textToBe(CartBadge, String.valueOf(expectedCount)));
    }

}
