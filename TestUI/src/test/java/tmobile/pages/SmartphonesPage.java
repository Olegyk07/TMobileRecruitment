package tmobile.pages;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class SmartphonesPage {

    public void clickProductByNumber(int productNumber) {
        String selector = String.format("[data-qa='LST_ProductCard%d']", productNumber - 1);
        $(selector).shouldBe(visible).click();
    }
}
