package tests;

import baseEntities.BaseTest;
import core.ReadProperties;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import pages.AuthenticationPage;

public class AP_1_Test extends BaseTest {

    @Description("verification of creating a new account")
    @Test
     void createNewAccount() {
        AuthenticationPage authenticationPage = new AuthenticationPage(true);
        authenticationPage.createAccount()
                .fillingInDataNewAccount(ReadProperties.getInstance().getFirstName(), ReadProperties.getInstance().getLastName(), ReadProperties.getInstance().getEmail(), ReadProperties.getInstance().getPassword(),ReadProperties.getInstance().getFirstName(), ReadProperties.getInstance().getLastName(),ReadProperties.getInstance().getCompany(), ReadProperties.getInstance().getAddress(),ReadProperties.getInstance().getCity(), ReadProperties.getInstance().getZip(), ReadProperties.getInstance().getPhone(),ReadProperties.getInstance().getAlias())
                .entryСheck();
    }
}