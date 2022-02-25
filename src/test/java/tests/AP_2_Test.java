package tests;

import baseEntities.BaseTest;
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
        authenticationPage.signIn(properties.getEmail(), properties.getPassword());

        Assertions.assertEquals(new MyAccountPage().getNameAccountText(), properties.getFirstName() + " " + properties.getLastName());
    }
}