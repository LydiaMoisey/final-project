package by.itacademy.moiseenkolydia.breezy.ui.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private final By ICON_PROFILE = By.className("header_profile");
    private final By LABEL_LOGIN_FORM = By.xpath("//*[@id='login_modal']/div[@class='modal_head']");
    private final By INPUT_EMAIL = By.xpath("//form[@id='login_form']//input[@name='email']");
    private final By INPUT_PASSWORD = By.xpath("//form[@id='login_form']//input[@type='password']");
    private final By BUTTON_LOGIN = By.xpath("//div[@data-func='login']");
    private final By LABEL_EMAIL_IN_PROFILE = By.className("email");
    private final By BUTTON_LOGOUT = By.xpath("//a[@href='https://breezy.by/logout']");
    private final By ERROR_BLOCK = By.xpath("//form[@id='login_form']/div[@class='error_place']");

    public LoginPage openLoginForm() {
        driver.findElement(ICON_PROFILE).click();
        return this;
    }

    public LoginPage inputEmail(String email) {
        driver.findElement(INPUT_EMAIL).sendKeys(email);
        return this;
    }

    public LoginPage inputPassword(String password) {
        driver.findElement(INPUT_PASSWORD).sendKeys(password);
        return this;
    }

    public LoginPage clickLogin() {
        driver.findElement(BUTTON_LOGIN).click();
        return this;
    }

    public LoginPage getUserEmailInProfile() {
        driver.findElement(LABEL_EMAIL_IN_PROFILE).getText();
        return this;
    }

    public LoginPage clickLogout() {
        driver.findElement(BUTTON_LOGOUT).click();
        return this;
    }

    public LoginPage getErrorAuthorization() {
        driver.findElement(ERROR_BLOCK).getText();
        return this;
    }
}
