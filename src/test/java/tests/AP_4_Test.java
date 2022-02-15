package tests;

import core.Watcher;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import pages.AuthenticationPage;
import strategy.AdditionInMyWishlist;
import strategy.Customers;

@ExtendWith(Watcher.class)
public class AP_4_Test {

    @Description("verification of creating your own wishlist and adding products to it")
    @Test
    @Execution(ExecutionMode.CONCURRENT)
    void createMyWishlistAndAddProduct() {
        AuthenticationPage authenticationPage = new AuthenticationPage(true);
        authenticationPage.signIn();

        Customers customers = new Customers();
        customers.setAddition(new AdditionInMyWishlist());
        customers.executeAddition();
    }
}
