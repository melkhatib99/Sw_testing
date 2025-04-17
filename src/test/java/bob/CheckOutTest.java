package bob;

import base.BaseTest;
import base.Login;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckOut;
import pages.LoginPage;

public class CheckOutTest extends BaseTest {

    CheckOut checkout;
    CartPage cartPage;






    @BeforeMethod

    public void before(){

        checkout = new CheckOut(CH);
        checkout.cartview();
        checkout.checkout();
    }
    @AfterMethod
        public void after(){
        checkout.continuee();


    }


  @Test

     public void GocheckOut(){
      checkout = new CheckOut(CH);


      checkout.cartview();
      checkout.checkout();

  }

  @Test

     public void validata(){

      checkout.enterfirstname("mohamed");
      checkout.enterlastname("elkhateb");
      checkout.enterZipcode("555");


  }


  @Test

     public void entersernameonly(){


      checkout.enterfirstname("mohamed");
      checkout.continuee();




  }

    @Test

    public void enterlastnameonly() {


        checkout = new CheckOut(CH);
        checkout.enterlastname("elkhateb");

    }

    @Test

    public void enterziponly() {


       // checkout = new CheckOut(CH);
        checkout.enterZipcode("555");

    }




}
