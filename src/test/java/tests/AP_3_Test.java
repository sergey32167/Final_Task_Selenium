package tests;

import core.Watcher;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import pages.AuthenticationPage;
import strategy.AdditionInRandomWishlist;
import strategy.Customers;

@ExtendWith(Watcher.class)
public class AP_3_Test {

    @Description("checking the creation of a random wishlist and adding products to it")
    @Test
    @Execution(ExecutionMode.CONCURRENT)
    void createRandomWishlistAndAddProduct() {
        AuthenticationPage authenticationPage = new AuthenticationPage(true);
        authenticationPage.signIn();

        Customers customers = new Customers();
        customers.setAddition(new AdditionInRandomWishlist());
        customers.executeAddition();
    }
}
