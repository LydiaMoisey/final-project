package by.itacademy.moiseenkolydia.breezy.ui.pages;

import by.itacademy.moiseenkolydia.breezy.ui.driver.Driver;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;

    public BasePage() {
        driver = Driver.warmUp();
    }

    public static final String URL = "https://breezy.by";

    public void openWebSite() {
        driver.get(URL);
    }
}
