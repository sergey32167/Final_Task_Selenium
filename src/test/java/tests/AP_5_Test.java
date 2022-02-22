package tests;

import baseEntities.BaseTest;
import core.ReadProperties;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.AuthenticationPage;
import pages.InCartPage;
import strategy.AdditionInCart;
import strategy.Customers;

public class AP_5_Test extends BaseTest {

    @Description("checking the addition of goods to the cart and calculating the cost")
    @Test
    void addProductsInCart() {
        AuthenticationPage authenticationPage = new AuthenticationPage(true);
        authenticationPage.signIn(ReadProperties.getInstance().getEmail(),ReadProperties.getInstance().getPassword());

        Customers customers = new Customers();
        customers.setAddition(new AdditionInCart());
        customers.executeAddition();

        InCartPage inCartPage = new InCartPage();
        Assertions.assertEquals(inCartPage.totalPriceProductsText(),  inCartPage.sumProductPrice());
        Assertions.assertEquals(inCartPage.counterProductText(),  "3 Products");
    }
}