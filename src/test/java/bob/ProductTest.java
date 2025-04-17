package bob;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.ProductPage;

import java.time.Duration;

public class ProductTest extends BaseTest
{
   //public WebDriver CH;

    ProductPage productpage ;



    @Test // verify sorting

    public void sorting_Z_A(){

        CH.findElement(By.className("product_sort_container")).click();
        WebElement dropdownElement = CH.findElement(By.className("product_sort_container"));

        // Create Select object
        Select dropdown = new Select(dropdownElement);

        // Select by value
        dropdown.selectByValue("za");
    }

    @Test // verify sorting

    public void sorting_low_high(){


        WebElement dropdownElement = CH.findElement(By.className("product_sort_container"));

        // Create Select object
        Select dropdown = new Select(dropdownElement);

        // Select by value
        dropdown.selectByValue("lohi");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Test // verify sorting

    public void sorting_high_low(){

        WebElement dropdownElement = CH.findElement(By.className("product_sort_container"));

        // Create Select object
        Select dropdown = new Select(dropdownElement);

        // Select by value
        dropdown.selectByValue("hilo");
    }

   @Test() //add T_shirt

           public void AddShirt() {



       JavascriptExecutor js = (JavascriptExecutor) CH;
       js.executeScript("window.scrollBy(0,1000)");

       productpage = new ProductPage(CH);
        productpage.AddT_shirt();
    }


     @Test

           public void addjacket(){



         JavascriptExecutor js = (JavascriptExecutor) CH;
         js.executeScript("window.scrollBy(0,1000)");

         productpage = new ProductPage(CH);
         productpage.AddJacket();

     }

     @Test // add multible products

      public void AddMultibleProducts(){



         JavascriptExecutor js = (JavascriptExecutor) CH;
         js.executeScript("window.scrollBy(0,1000)");

         productpage = new ProductPage(CH);
         productpage.AddJacket();
         productpage.AddBike();

     }

    @Test // products can be removed

    public void RemoveItems (){

        JavascriptExecutor js = (JavascriptExecutor) CH;
        js.executeScript("window.scrollBy(0,1000)");

        productpage = new ProductPage(CH);
        productpage.AddJacket();
        CH.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        productpage.AddBack();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        CH.findElement(By.id("remove-sauce-labs-fleece-jacket")).click();

    }


    @Test // verify cart button
    public void CartButton(){

        CH.findElement(By.className("shopping_cart_link")).click();

    }


    }










