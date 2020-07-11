package test.selenium;

import com.codeborne.selenide.SelenideDriver;
import io.github.bonigarcia.seljup.*;
import org.aeonbits.owner.ConfigCache;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import test.MyAppConfig;

import static com.codeborne.selenide.Browsers.FIREFOX;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.openqa.selenium.By.linkText;

@ExtendWith(SeleniumExtension.class)
@Execution(ExecutionMode.CONCURRENT)
@TestMethodOrder(MethodOrderer.Random.class)
public class SeleniumLocalTest {

    MyAppConfig configuration = ConfigCache.getOrCreate(MyAppConfig.class);

    @DriverCapabilities
    Capabilities capabilities = new FirefoxOptions();

    @Test
    public void testLocalFirefox(FirefoxDriver driver) {
        driver.get("https://bonigarcia.github.io/selenium-jupiter/");
        assertThat(driver.getTitle(),
                containsString("JUnit 5 extension for Selenium"));
    }

    @Test
    public void testLocalChrome(ChromeDriver driver) {
        driver.get("https://bonigarcia.github.io/selenium-jupiter/");
        assertThat(driver.getTitle(),
                containsString("JUnit 5 extension for Selenium"));
    }

    @Test
    void headlessTest(@Arguments("--headless") ChromeDriver driver) {
        driver.get("https://bonigarcia.github.io/selenium-jupiter/");
        assertThat(driver.getTitle(),
                containsString("JUnit 5 extension for Selenium"));
    }

    @AfterEach
    public void tearDown(WebDriver driver){
        if (driver != null){
            driver.quit();
        }
    }
}

