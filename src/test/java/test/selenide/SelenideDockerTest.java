package test.selenide;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.seljup.DockerBrowser;
import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.HomePage;

import java.util.stream.IntStream;

import static base.PageManipulator.at;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static io.github.bonigarcia.seljup.BrowserType.CHROME;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@ExtendWith(SeleniumExtension.class)
public class SelenideDockerTest {

   /* @Test
    public void SelenideDockerTest(@DockerBrowser(type = CHROME, version = "64.0") RemoteWebDriver driver) {
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
}
