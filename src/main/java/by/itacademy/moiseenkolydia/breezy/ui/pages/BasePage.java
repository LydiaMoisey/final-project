package by.itacademy.moiseenkolydia.breezy.ui.pages;

import by.itacademy.moiseenkolydia.breezy.ui.driver.Driver;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected static WebDriver driver;

    public BasePage() {
        driver = Driver.createDriver();
    }

    public static final String URL = "https://breezy.by";
}
