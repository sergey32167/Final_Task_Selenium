package tests;

import core.Watcher;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import pages.AuthenticationPage;
import strategy.AdditionInCart;
import strategy.Customers;

@ExtendWith(Watcher.class)
public class AP_5_Test {

    @Description("checking the addition of goods to the cart and calculating the cost")
    @Test
    @Execution(ExecutionMode.CONCURRENT)
    void addProductsInCart() {
        AuthenticationPage authenticationPage = new AuthenticationPage(true);
        authenticationPage.signIn();

        Customers customers = new Customers();
        customers.setAddition(new AdditionInCart());
        customers.executeAddition();
    }
}
