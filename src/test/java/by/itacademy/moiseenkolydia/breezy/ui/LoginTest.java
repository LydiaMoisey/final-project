package by.itacademy.moiseenkolydia.breezy.ui;

import by.itacademy.moiseenkolydia.breezy.ui.domain.User;
import by.itacademy.moiseenkolydia.breezy.ui.pages.LoginPage;
import by.itacademy.moiseenkolydia.breezy.ui.steps.LoginSteps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {
    LoginSteps steps = new LoginSteps();

    @Test
    @DisplayName("Login with registered user credentials")
    public void testLoginWithValidCredentials() {
        steps.login(User.VALID_EMAIL, User.VALID_PASSWORD);
        Assertions.assertEquals(User.VALID_EMAIL, LoginPage.getUserEmailInProfile());
    }

    @Test
    @DisplayName("Login with unregistered email")
    public void testLoginWithInvalidEmail() {
        steps.login(User.RANDOM_EMAIL, User.VALID_PASSWORD);
        Assertions.assertEquals(LoginPage.ERROR_INVALID_EMAIL_AND_PASSWORD, LoginPage.getErrorAuthorization());
    }

    @Test
    @DisplayName("Login with invalid password")
    public void testLoginWithInvalidPassword() {
        steps.login(User.VALID_EMAIL, User.RANDOM_PASSWORD);
        Assertions.assertEquals(LoginPage.ERROR_INVALID_EMAIL_AND_PASSWORD, LoginPage.getErrorAuthorization());
    }

    @Test
    @DisplayName("Login without email")
    public void testLoginWithoutEmail() {
        steps.login("", User.VALID_PASSWORD);
        Assertions.assertEquals(LoginPage.ERROR_WITHOUT_EMAIL, LoginPage.getErrorAuthorization());
    }
    @Test
    @DisplayName("Login without password")
    public void testLoginWithoutPassword() {
        steps.login(User.VALID_EMAIL, "");
        Assertions.assertEquals(LoginPage.ERROR_WITHOUT_PASSWORD, LoginPage.getErrorAuthorization());
    }
    @Test
    @DisplayName("Logout")
    public void testLogout() {
        steps.logout(User.VALID_EMAIL, User.VALID_PASSWORD);
        Assertions.assertEquals(LoginPage.LABEL_LOGIN, LoginPage.getLoginFormLabel());
    }
}
