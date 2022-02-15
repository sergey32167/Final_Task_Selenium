package tests;

import core.Watcher;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import pages.AuthenticationPage;

@ExtendWith(Watcher.class)
public class AP_2_Test {

    @Description("verifying the login to an existing account")
    @Test
    @Execution(ExecutionMode.CONCURRENT)
    void signInAccount() {
        AuthenticationPage authenticationPage = new AuthenticationPage(true);
        authenticationPage.signIn()
                .getWelcomeText().equals("Welcome to your account. Here you can manage all of your personal information and orders.");
    }
}
