package tests;

import baseEntities.BaseTest;
import core.ReadProperties;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import pages.AuthenticationPage;
import strategy.AdditionInMyWishlist;
import strategy.Customers;

public class AP_4_Test extends BaseTest {

    @Description("verification of creating your own wishlist and adding products to it")
    @Test
    void createMyWishlistAndAddProduct() {
        AuthenticationPage authenticationPage = new AuthenticationPage(true);
        authenticationPage.signIn(ReadProperties.getInstance().getEmail(),ReadProperties.getInstance().getPassword());

        Customers customers = new Customers();
        customers.setAddition(new AdditionInMyWishlist());
        customers.executeAddition();
    }
}