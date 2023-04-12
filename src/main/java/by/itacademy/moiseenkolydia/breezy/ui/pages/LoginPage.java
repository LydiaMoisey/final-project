package by.itacademy.moiseenkolydia.breezy.ui.pages;

import by.itacademy.moiseenkolydia.breezy.ui.util.Util;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private final By ICON_PROFILE = By.className("header_profile");
    private final static By LABEL_LOGIN_FORM = By.xpath("//*[@id='login_modal']/div[@class='modal_head']");

    private final By INPUT_EMAIL = By.xpath("//form[@id='login_form']//input[@name='email']");
    private final By INPUT_PASSWORD = By.xpath("//form[@id='login_form']//input[@type='password']");
    private final By BUTTON_LOGIN = By.xpath("//div[@data-func='login']");
    private final static By LABEL_EMAIL_IN_PROFILE = By.className("email");
    private final By BUTTON_LOGOUT = By.xpath("//a[@href='https://breezy.by/logout']");
    private final static By ERROR_BLOCK = By.xpath("//form[@id='login_form']/div[@class='error_place']");
    public final static String LABEL_LOGIN = "Вход в личный кабинет";
    public final static String ERROR_INVALID_EMAIL_AND_PASSWORD = "Неправильный логин или пароль";
    public final static String ERROR_WITHOUT_EMAIL =
            String.format("%s\n%s", "Форма содержит ошибки:", "- Email -- Обязательное поле");
    public final static String ERROR_WITHOUT_PASSWORD =
            String.format("%s\n%s", "Форма содержит ошибки:", "- Пароль -- Обязательное поле");
    public final static String ERROR_WITHOUT_EMAIL_AND_PASSWORD =
            String.format("%s\n%s\n%s", "Форма содержит ошибки:", "- Email -- Обязательное поле", "- Пароль -- Обязательное поле");

    public LoginPage openLoginForm() {
        driver.findElement(ICON_PROFILE).click();
        return this;
    }

    public static String getLoginFormLabel() {
        Util.waitForPresenceOfElement(driver, 5, LABEL_LOGIN_FORM);
        return driver.findElement(LABEL_LOGIN_FORM).getText();
    }

    public LoginPage enterEmail(String email) {
        driver.findElement(INPUT_EMAIL).sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        driver.findElement(INPUT_PASSWORD).sendKeys(password);
        return this;
    }

    public LoginPage clickLogin() {
        driver.findElement(BUTTON_LOGIN).click();
        return this;
    }

    public static String getUserEmailInProfile() {
        Util.waitForPresenceOfElement(driver, 10, LABEL_EMAIL_IN_PROFILE);
        return driver.findElement(LABEL_EMAIL_IN_PROFILE).getText();
    }

    public void clickLogout() {
        Util.waitForElementToBeVisible(driver, 10, BUTTON_LOGOUT);
        driver.findElement(BUTTON_LOGOUT).click();
    }

    public static String getErrorAuthorization() {
        Util.waitForElementToBeVisible(driver, 10, ERROR_BLOCK);
        return driver.findElement(ERROR_BLOCK).getText();
    }
}
