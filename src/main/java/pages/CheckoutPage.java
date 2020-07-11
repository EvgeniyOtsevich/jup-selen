package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutPage {

    public void verifyCheckoutOpened() {
        $(".checkout-process").shouldBe(Condition.visible);
    }
}
