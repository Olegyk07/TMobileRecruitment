package tmobile.pages;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class ProductPage {

    public void addToCart() {
        $$("[data-qa='PRD_AddToBasket']")
                .filter(visible)
                .first()
                .click();
    }
}
