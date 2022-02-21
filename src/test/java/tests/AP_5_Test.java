package tests;

import baseEntities.BaseTest;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import pages.AuthenticationPage;
import strategy.AdditionInCart;
import strategy.Customers;

public class AP_5_Test extends BaseTest {

    @Description("checking the addition of goods to the cart and calculating the cost")
    @Test
    void addProductsInCart() {
        AuthenticationPage authenticationPage = new AuthenticationPage(true);
        authenticationPage.signIn();

        Customers customers = new Customers();
        customers.setAddition(new AdditionInCart());
        customers.executeAddition();
    }
}