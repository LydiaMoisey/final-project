package by.itacademy.moiseenkolydia.breezy.ui.steps;

import by.itacademy.moiseenkolydia.breezy.ui.pages.LoginPage;

public class LoginSteps extends LoginPage {

    public void login(String email, String password) {
        openLoginForm().
                enterEmail(email).
                enterPassword(password).
                clickLogin();
    }

    public void logout(String email, String password) {
        openLoginForm().
                enterEmail(email).
                enterPassword(password).
                clickLogin().
                clickLogout();
        openLoginForm();
    }
}
