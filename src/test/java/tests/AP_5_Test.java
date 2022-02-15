package tests;

import core.Watcher;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import pages.HomePage;

@ExtendWith(Watcher.class)
public class AP_5_Test {

    @Description("checking the addition of goods to the cart and calculating the cost")
    @Test
    @Execution(ExecutionMode.CONCURRENT)
    void addProductsInCart() {
        HomePage homePage = new HomePage(true);
        homePage.clickSignInButton()
                .signIn()
                .jumpToHomePage()
                .goToProductByName("Faded Short Sleeve T-shirts")
                .addProduct()
                .goToProductByName("Blouse")
                .addProduct()
                .goToProductByName("Printed Dress")
                .addProduct()
                .cartEntry()
                .addCheck()
        ;
    }
}
