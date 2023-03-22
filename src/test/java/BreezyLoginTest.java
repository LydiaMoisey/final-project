import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BreezyLoginTest {
    WebDriver driver;

    @BeforeEach
    public void warmUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/Google/Chrome/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(BreezyPage.URL);
    }
    @Test
    @Order(1)
    public void testBreezyLogin() {

            driver.findElement(By.className(BreezyPage.ICON_PROFILE)).click();
            driver.findElement(By.xpath(BreezyPage.INPUT_EMAIL)).sendKeys("99camomile99@gmail.com");
            driver.findElement(By.xpath(BreezyPage.INPUT_PASSWORD)).sendKeys("Qwerty!1");
            driver.findElement(By.xpath(BreezyPage.BUTTON_LOGIN)).click();
            Driver.waitForPresenceElementByClass(driver,BreezyPage.LABEL_EMAIL_IN_PROFILE,2);

            Assertions.assertEquals("99camomile99@gmail.com", driver.findElement(By.className(BreezyPage.LABEL_EMAIL_IN_PROFILE)).getText());
    }

    @Test
    public void testBreezyInvalidEmail() {

        driver.findElement(By.className(BreezyPage.ICON_PROFILE)).click();
        driver.findElement(By.xpath(BreezyPage.INPUT_EMAIL)).sendKeys("qwe123@gmail.com");
        driver.findElement(By.xpath(BreezyPage.INPUT_PASSWORD)).sendKeys("Qwerty!1");
        driver.findElement(By.xpath(BreezyPage.BUTTON_LOGIN)).click();
        Driver.waitForElementToBeVisibleByXPath(driver,BreezyPage.ERROR_BLOCK,3);

        Assertions.assertEquals("Неправильный логин или пароль", driver.findElement(By.xpath(BreezyPage.ERROR_BLOCK)).getText());
    }
    @Test
    public void testBreezyWithoutEmail() {

        driver.findElement(By.className(BreezyPage.ICON_PROFILE)).click();
        driver.findElement(By.xpath(BreezyPage.INPUT_PASSWORD)).sendKeys("Qwerty!1");
        driver.findElement(By.xpath(BreezyPage.BUTTON_LOGIN)).click();
        Driver.waitForElementToBeVisibleByXPath(driver,BreezyPage.ERROR_BLOCK,3);

        Assertions.assertEquals("Форма содержит ошибки:\n" +
                "- Email -- Обязательное поле", driver.findElement(By.xpath(BreezyPage.ERROR_BLOCK)).getText());
    }

    @Test
    public void testBreezyLogout() {

        driver.findElement(By.className(BreezyPage.ICON_PROFILE)).click();
        driver.findElement(By.xpath(BreezyPage.INPUT_EMAIL)).sendKeys("99camomile99@gmail.com");
        driver.findElement(By.xpath(BreezyPage.INPUT_PASSWORD)).sendKeys("Qwerty!1");
        driver.findElement(By.xpath(BreezyPage.BUTTON_LOGIN)).click();
        Driver.waitForPresenceElementByXPath(driver,BreezyPage.BUTTON_LOGOUT,3);
        driver.findElement(By.xpath(BreezyPage.BUTTON_LOGOUT)).click();
        driver.findElement(By.className(BreezyPage.ICON_PROFILE)).click();

        Assertions.assertEquals("Вход в личный кабинет", driver.findElement(By.xpath(BreezyPage.LABEL_LOGIN_FORM)).getText());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}