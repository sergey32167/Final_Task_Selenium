package tests;

import baseEntities.BaseTest;
import core.ReadProperties;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import pages.AuthenticationPage;

public class AP_2_Test extends BaseTest {

    @Description("verifying the login to an existing account")
    @Test
    void signInAccount() {
        AuthenticationPage authenticationPage = new AuthenticationPage(true);
        authenticationPage.signIn(ReadProperties.getInstance().getEmail(),ReadProperties.getInstance().getPassword())
                .entryСheck();
    }
}