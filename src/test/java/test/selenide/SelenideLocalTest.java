package test.selenide;

import com.codeborne.selenide.*;
import io.github.bonigarcia.seljup.SelenideConfiguration;
import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.HomePage;

import java.util.stream.IntStream;

import static base.PageManipulator.at;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;

@ExtendWith(SeleniumExtension.class)
@TestMethodOrder(MethodOrderer.Random.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SelenideLocalTest {

   /* @Test
    @DisplayName("Selenide Local Default(Chrome) Browser Test")
    public void testSelenideDefaultLocal() {
        open("https://bonigarcia.github.io/selenium-jupiter");
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


    /*@Test
    @DisplayName("Selenide Local Injected Firefox(WebDriver) Test")
    public void testSelenideInjectWebDriver(FirefoxDriver driver) {
        WebDriverRunner.setWebDriver(driver);

        open("https://bonigarcia.github.io/selenium-jupiter");
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

    @Test
    @DisplayName("Selenide Configuration Local Test")
    public void testSelenideConfiguration(@SelenideConfiguration(browser = FIREFOX) SelenideDriver driver) {
        driver.open("/");
        driver.$(linkText("About")).shouldBe(visible);
    }
}

