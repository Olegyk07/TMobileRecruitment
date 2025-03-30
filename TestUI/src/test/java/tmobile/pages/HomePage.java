package tmobile.pages;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class HomePage {

    public void openHomePage() {
        open("https://www.t-mobile.pl/");
    }

    public void acceptCookiesIfVisible() {
        SelenideElement acceptButton = $("#didomi-notice-agree-button");

        acceptButton.should(appear.because("Wait for Cookies button is appear"), Duration.ofSeconds(10));

        if (acceptButton.isDisplayed()) {
            acceptButton.scrollIntoView(true).shouldBe(visible, enabled).click();
        }
    }

    public boolean isCartItemCountCorrect(int expectedCount) {
        String countText = $x("//a[contains(@class, 'group/basket')]//div[contains(@class, 'rounded-full')]")
                .shouldBe(visible)
                .getText();

        int actualCount = Integer.parseInt(countText.trim());
        return actualCount == expectedCount;
    }
}
