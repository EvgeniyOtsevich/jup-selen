import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.seljup.SelenideConfiguration;
import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.HomePage;

import java.util.stream.IntStream;

import static base.PageManipulator.at;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;

@ExtendWith(SeleniumExtension.class)
@TestMethodOrder(MethodOrderer.Random.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AfbeautyCheckoutTest {

    @BeforeAll
    public void setUp() {
        Configuration.startMaximized = true;
    }

    @Test
    @DisplayName("Afbeauty Checkout Test")
    public void testSelenideDefaultLocal() {
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

