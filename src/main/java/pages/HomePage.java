package pages;

import base.Pages;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.Text;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class HomePage {

  /*  private SelenideElement tableOfContent = $("#toca");
    private ElementsCollection level1menuItems = tableOfContent.$$(".sectlevel1 > li > a");
    private ElementsCollection h2Items = $$(".sect1 > h2");

    public ElementsCollection getLevel1menuItems() {
        return level1menuItems;
    }

    public ElementsCollection getH2Items() {
        return h2Items;
    }*/
    public HomePage closePopup() {
        $("[title=\"Close (Esc)\"]").click();
        return this;
    }

    public HomePage addFeaturedProduct() {
        $$(".product-card").stream()
                .filter(product -> Float.parseFloat(product.$(".product-price span").getText().split(" ")[0].replace(",",".")) >= 10 && product.$(".addtocart").isEnabled())
                .findFirst()
                .get()
                .$(".addtocart")
                .scrollTo()
                .click();
        return this;
    }

    public HomePage verifyProductAddedToCart(int value) {
        $(".count")
                .scrollTo()
                .waitUntil(text(String.valueOf(value)).because("Expected cart count to " + value), 10000);
        //assertThat($(".count").getText(), is(containsString(String.valueOf(value))));
        return this;
    }

    public CartPage goToCart() {
        $(".cart-link").click();
        return page(CartPage.class);
    }
}
