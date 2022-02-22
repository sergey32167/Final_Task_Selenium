package tests;

import baseEntities.BaseTest;
import core.ReadProperties;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import pages.AuthenticationPage;
import strategy.AdditionInRandomWishlist;
import strategy.Customers;

public class AP_3_Test extends BaseTest {

    @Description("checking the creation of a random wishlist and adding products to it")
    @Test
    void createRandomWishlistAndAddProduct() {
        AuthenticationPage authenticationPage = new AuthenticationPage(true);
        authenticationPage.signIn(ReadProperties.getInstance().getEmail(), ReadProperties.getInstance().getPassword());

        Customers customers = new Customers();
        customers.setAddition(new AdditionInRandomWishlist());
        customers.executeAddition();
    }
}