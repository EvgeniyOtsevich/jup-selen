package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.*;

public class CartPage {

    public CheckoutPage proceedToCheckout() {
        $$(".btn-primary").filter(Condition.visible).first().click();
        return page(CheckoutPage.class);
    }
}
