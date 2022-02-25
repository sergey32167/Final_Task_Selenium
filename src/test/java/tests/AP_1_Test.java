package tests;

import baseEntities.BaseTest;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.AuthenticationPage;
import pages.MyAccountPage;

public class AP_1_Test extends BaseTest {

    @Description("verification of creating a new account")
    @Test
     void createNewAccount() {
        AuthenticationPage authenticationPage = new AuthenticationPage(true);
        authenticationPage.createAccount()
                .fillingInDataNewAccount(properties.getFirstName(), properties.getLastName(), properties.getEmail(), properties.getPassword(), properties.getFirstName(), properties.getLastName(), properties.getCompany(), properties.getAddress(), properties.getCity(), properties.getZip(), properties.getPhone(), properties.getAlias());

        Assertions.assertEquals(new MyAccountPage().getNameAccountText(), properties.getFirstName() + " " + properties.getLastName());
    }
}