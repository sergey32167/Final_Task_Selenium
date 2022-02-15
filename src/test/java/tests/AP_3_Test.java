package tests;

import core.Watcher;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import pages.HomePage;

@ExtendWith(Watcher.class)
public class AP_3_Test {

    @Description("checking the creation of a random wishlist and adding products to it")
    @Test
    @Execution(ExecutionMode.CONCURRENT)
    void createRandomWishlistAndAddProduct() {
        HomePage homePage = new HomePage(true);
        homePage.clickSignInButton()
                .signIn()
                .signInWishlist()
                .createRandomWishlist()
                .addToWishlist()
                .goToAccount()
                .signInWishlist()
                .contentWishlist()
                .cleanWishlistTable()
        ;
    }
}
