package testSelenium.Test;

import example.ProductStore.Pages.ProductStore;
import org.junit.jupiter.api.Test;
import testSelenium.Utility.Browser;


public class TestProductStoreCheckOut extends Browser {


    @Test
    public void createCheckOut() {
       new ProductStore(driver, wait)
               .signIn()
               .logIn()
               .addProductToCart()
               .checkOut()

       ;



    }


}
