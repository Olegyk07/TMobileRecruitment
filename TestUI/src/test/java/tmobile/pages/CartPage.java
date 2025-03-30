package tmobile.pages;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.open;

public class CartPage {
    public void returnToHomePage() {
        //waiting for the card to be loaded
        Selenide.sleep(3000);
        open("https://www.t-mobile.pl/");
    }
}
