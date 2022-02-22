package tests;

import baseEntities.BaseTest;
import core.ReadProperties;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.AuthenticationPage;
import pages.MyAccountPage;

public class AP_2_Test extends BaseTest {

    @Description("verifying the login to an existing account")
    @Test
    void signInAccount() {
        AuthenticationPage authenticationPage = new AuthenticationPage(true);
        authenticationPage.signIn(ReadProperties.getInstance().getEmail(),ReadProperties.getInstance().getPassword());

        Assertions.assertEquals(new MyAccountPage().getWelcomeText(), "Welcome to your account. Here you can manage all of your personal information and orders.");
    }
}