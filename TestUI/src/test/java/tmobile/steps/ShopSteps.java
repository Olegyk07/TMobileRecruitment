package tmobile.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tmobile.context.PagesContainer;
import tmobile.utils.DriverManager;

public class ShopSteps {
    private static final Logger logger = LoggerFactory.getLogger(ShopSteps.class);

    private final PagesContainer pages;

    public ShopSteps(PagesContainer pages) {
        this.pages = pages;
    }

    @Before
    public void setUp() {
        DriverManager.setup();
    }

    @After
    public void tearDown(io.cucumber.java.Scenario scenario) {
        if (scenario.isFailed()) {
            DriverManager.closeBrowserOnFailure(new Throwable(scenario.getName()));
        } else {
            DriverManager.closeBrowser();
        }
    }

    @Given("user open a Web Browser")
    public void openBrowser() {
        // Setup will handle this
    }

    @When("go to main page")
    public void goToMainPage() {
        pages.home.openHomePage();
        pages.home.acceptCookiesIfVisible();
    }

    @When("click {string} from the section {string}")
    public void clickSmartphonesNoSubscription(String option, String section) {
        pages.devices.clickSmartphonesNoSubscription();
    }

    @When("click at product number {int}")
    public void selectProductByNumber(int productNumber) {
        pages.smartphones.clickProductByNumber(productNumber);
    }

    @When("add product to cart")
    public void addProductToCart() {
        pages.product.addToCart();
    }

    @When("returns to the main page")
    public void returnToHomepage() {
        pages.cart.returnToHomePage();
    }

    @Then("cart must contains exactly one product")
    public void verifyCartIcon() {
        assert pages.home.isCartItemCountCorrect(1);
        logger.info("Cart is verified and exactly one product is appear");
    }
}
