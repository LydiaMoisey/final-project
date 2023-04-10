package by.itacademy.moiseenkolydia.breezy.ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import by.itacademy.moiseenkolydia.breezy.ui.driver.Driver;
import by.itacademy.moiseenkolydia.breezy.ui.pages.BasePage;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    WebDriver driver;
    @BeforeEach
    public void warmUP(){
        driver = Driver.createDriver();
        driver.get(BasePage.URL);
    }

    @AfterEach
    public void tearDown() {
        Driver.closeDriver();
    }
}
