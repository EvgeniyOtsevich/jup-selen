package test.selenide;

import com.codeborne.selenide.*;
import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.HomePage;

import java.util.stream.IntStream;

import static base.PageManipulator.at;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertAll;

@ExtendWith(SeleniumExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SelenideRemoteTest {

    /**
     * The 1st way of running Selenide is use Configuration
     * All data should be set in setUp method
     *
     * browserCapabilities can be set in 2 ways:
     * - with using DriverCapabilities annotation
     *      Configuration.browserCapabilities = capabilities;
     * - with setup capability directly
     *      Configuration.browserCapabilities.setCapability("enableVNC", true);
     */

    @BeforeAll
    public void setUp() {
        Configuration.baseUrl = "https://bonigarcia.github.io/selenium-jupiter";
        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.browser = "firefox";
        Configuration.browserVersion = "59.0";
        Configuration.browserCapabilities.setCapability("enableVNC", false);
        Configuration.browserCapabilities.setCapability("enableVideo", false);
    }

   /* @Test
    @DisplayName("Selenide Remote Default(from set up) Browser Test")
    public void testSelenideRemote() {
        open("/");
        sleep(3000);
        ElementsCollection lvlOneMenu = at(HomePage.class).getLevel1menuItems();
        ElementsCollection headerItems = at(HomePage.class).getH2Items();

        IntStream.range(0, lvlOneMenu.size()).forEach(i -> {
            var text = lvlOneMenu.get(i).getText();
            lvlOneMenu.get(i).click();
            assertAll(
                    () -> assertThat(headerItems.get(i).getText(), is(equalTo(text))),
                    () -> assertThat(url(), is(endsWith(lvlOneMenu.get(i).getText().replace(" ", "-").toLowerCase())))
            );
        });
    }*/

}

