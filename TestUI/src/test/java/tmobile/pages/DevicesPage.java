package tmobile.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class DevicesPage {
    private final SelenideElement smartfonyLink = $("[data-ga-ea='nav-links - Urządzenia/Bez abonamentu/Smartfony']");

    public void clickSmartphonesNoSubscription() {
        $$(byTagName("button"))
                .findBy(text("Urządzenia"))
                .click();

        smartfonyLink.shouldBe(visible, enabled).click();
    }
}
