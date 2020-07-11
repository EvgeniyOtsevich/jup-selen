package test.selenide;

import com.codeborne.selenide.*;
import io.github.bonigarcia.seljup.DriverCapabilities;
import io.github.bonigarcia.seljup.DriverUrl;
import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.HomePage;

import java.util.stream.IntStream;

import static base.PageManipulator.at;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertAll;

@ExtendWith(SeleniumExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WebDriverRunnerSelenideRemoteTest {

    /**
     * The 3rd way of running Selenide is to setup hub url as DriverUrl annotation
     * with capabilities from Selenoid UI.
     *
     * First thing in test is set the RemoteWebDriver to use Selenide methods
     * without direct calling Driver
     *
     * */


    @BeforeAll
    public void setUp() {
        Configuration.timeout = 10000;
    }

    @DriverUrl
    final String url = "http://localhost:4444/wd/hub";

    @DriverCapabilities
    DesiredCapabilities anotherCapabilities = new DesiredCapabilities();{
        anotherCapabilities.setBrowserName("chrome");
        anotherCapabilities.setVersion("83.0");
        anotherCapabilities.setCapability("enableVNC", true);
        anotherCapabilities.setCapability("enableVideo", false);
    }

    @Test
    @DisplayName("Remote WebDriver with Selenoid Capability Selenide Test")
    void testSelenoidCapabilitySelenideBrowser(RemoteWebDriver driver) {
        WebDriverRunner.setWebDriver(driver);

        open("https://afbeauty.lv/");

        at(HomePage.class)
                .closePopup()
                .addFeaturedProduct()
                .verifyProductAddedToCart(2)
                .goToCart()
                .proceedToCheckout()
                .verifyCheckoutOpened();
    }
}

