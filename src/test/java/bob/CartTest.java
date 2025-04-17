package bob;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductPage;

public class CartTest extends BaseTest {
    CartPage cartpage;
    ProductPage productpage;

    @BeforeMethod
    public void setup() {
        cartpage = new CartPage(CH);
        productpage = new ProductPage(CH);
    }

    @Test(description = "TCS-01: Verify Checkout Process from Cart")
    public void CheckOut() {
        /*

        1. Navigate to cart page
        2. Click on Checkout button
        */

        cartpage.cart();
        cartpage.COut();

        Assert.assertTrue(CH.getCurrentUrl().contains("checkout-step-one.html"),
                "Checkout page did not open!");
    }

    @Test(description = "TCS-02: Verify Removing Backpack from Cart")
    public void remove_back() {
        // Add jacket, bike,back
        productpage.AddJacket();
        productpage.AddBike();
        productpage.AddBack();

        int initialCount = cartpage.getCartItemCount();
        Assert.assertEquals(initialCount, 3, "Initial cart count mismatch! Found: " + initialCount);

        //remove
        cartpage.Rback();

        // Wait for update
        int updatedCount = waitForCartUpdate(initialCount);
        Assert.assertEquals(updatedCount, 2,
                "Item removal failed! Expected 2 items but found: " + updatedCount);
    }


    private int waitForCartUpdate(int previousCount) {
        int attempts = 0;
        int currentCount = cartpage.getCartItemCount();

        while (currentCount == previousCount && attempts < 5) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            currentCount = cartpage.getCartItemCount();
            attempts++;
        }
        return currentCount;
    }


    @Test(description = "TCS-03: press button to back to product page")
    public void back_to_product_page() throws InterruptedException {

        productpage.cart_button();

        cartpage.Continue_shopping();

        Assert.assertTrue(productpage.isOnProductPage(),
                "Expected to be on product page but was on: " + CH.getCurrentUrl());
    }



    @Test(description = "TCS-04: Verify Add/Remove Items and Proceed to Checkout")
    public void Add_Remove_Checkout() {
        // Add items
        productpage.AddBike();
        productpage.AddJacket();
        Assert.assertEquals(cartpage.getCartItemCount(), 2, "Items not added to cart!");

        // remove jacket
        cartpage.cart();
        cartpage.Rjacket();


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        Assert.assertEquals(cartpage.getCartItemCount(), 1, "Jacket removal failed!");

        cartpage.COut();
        Assert.assertTrue(CH.getCurrentUrl().contains("checkout-step-one.html"),
                "Checkout failed after removal!");
    }
}