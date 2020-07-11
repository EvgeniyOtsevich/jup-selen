package test.selenide;

import com.codeborne.selenide.*;
import io.github.bonigarcia.seljup.DriverCapabilities;
import io.github.bonigarcia.seljup.SelenideConfiguration;
import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Browsers.FIREFOX;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.openqa.selenium.By.linkText;

@ExtendWith(SeleniumExtension.class)
public class SelenideConfigurationRemoteTest {

    /**
     * The 2nd way of running Selenide is injecting SelenideConfiguration
     * with SelenideDriver
     *
     * NB! All methods should be run from driver.***
     */

    @DriverCapabilities
    DesiredCapabilities capabilities = new DesiredCapabilities();{
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);
    }

    @SelenideConfiguration
    SelenideConfig selenideConfig = new SelenideConfig()
            .baseUrl("https://bonigarcia.github.io/selenium-jupiter")
            .remote("http://localhost:4444/wd/hub")
            .browser(CHROME)
            .browserVersion("83.0")
            .browserCapabilities(capabilities);

    @Test
    @DisplayName("Selenide Remote from Annotations Test")
    public void testSelenideConfiguration(@SelenideConfiguration SelenideDriver driver) {
        driver.open("/");
        sleep(15000);
        driver.$(linkText("About")).shouldBe(visible);
    }

}

