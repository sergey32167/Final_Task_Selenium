package tests;

import baseEntities.BaseTest;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import pages.AuthenticationPage;

public class AP_1_Test extends BaseTest {

    @Description("verification of creating a new account")
    @Test
     void createNewAccount() {
        AuthenticationPage authenticationPage = new AuthenticationPage(true);
        authenticationPage.createAccount()
                .fillingInDataNewAccount()
                .entryСheck();
    }
}