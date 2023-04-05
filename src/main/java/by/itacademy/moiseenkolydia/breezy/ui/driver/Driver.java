package by.itacademy.moiseenkolydia.breezy.ui.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {
    public static WebDriver driver;

    public static WebDriver warmUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*", "--incognito", "--lang=en");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        return driver;
    }

    public void tearDown() {
        driver.quit();
        driver = null;
    }
}
