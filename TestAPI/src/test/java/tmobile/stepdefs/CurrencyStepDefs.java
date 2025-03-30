package tmobile.stepdefs;

import io.cucumber.java.en.*;
import tmobile.model.Currency;
import tmobile.service.NbpApiService;

import java.util.List;
import java.util.logging.Logger;

import static org.junit.Assert.*;

public class CurrencyStepDefs {
    List<Currency> currencies;
    Logger logger = Logger.getLogger(CurrencyStepDefs.class.getName());

    @Given("I am getting the exchange rates from table A")
    public void downloadCourses() {
        NbpApiService.fetchRates();
        int status = NbpApiService.getStatusCode();
        assertEquals("Status code is not 200", 200, status);
        logger.info("Status code: " + status);
        currencies = NbpApiService.getCurrencies();
    }

    @Then("Check if the currency list is not empty")
    public void listNotEmpty() {
        assertNotNull("Currency list is null!", currencies);
        assertFalse("Currency list is empty!", currencies.isEmpty());
        logger.info("Currency list is not empty");
    }

    @Then("Check that the number of currencies with a rate below {double} is {int}")
    public void checkNumberBelow(double prog, int expectedCount) {
        long count = currencies.stream()
                .filter(c -> c.getMid() < prog)
                .count();
        assertEquals("The number of currencies below does not match " + prog, expectedCount, count);
        logger.info("Currencies below  " + prog + ": " + count);
    }

    @Then("Check that the number of currencies with a rate above {double} is {int}")
    public void checkNumberAbove(double prog, int expectedCount) {
        long count = currencies.stream()
                .filter(c -> c.getMid() > prog)
                .count();
        assertEquals("The number of currencies above does not match " + prog, expectedCount, count);
        logger.info("Currencies above " + prog + ": " + count);
    }
    @Then("Displaying the exchange rate for the currency with code {string}")
    public void courseForCode(String code) {
        currencies.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .ifPresentOrElse(
                        c -> logger.info("Course for " + code + ": " + c.getMid()),
                        () -> logger.warning("Currency code not found: " + code)
                );
    }
    @Then("Displaying the exchange rate for the currency named {string}")
    public void courseForName(String name) {
        currencies.stream()
                .filter(c -> c.getCurrency().equalsIgnoreCase(name))
                .findFirst()
                .ifPresentOrElse(
                        c -> logger.info("Course for " + name + ": " + c.getMid()),
                        () -> logger.warning("Currency not found: " + name)
                );
    }
    @Then("Displaying currencies with rates above {double}")
    public void showAbove(double prog) {
        currencies.stream()
                .filter(c -> c.getMid() > prog)
                .forEach(c -> logger.info("Above " + prog + ": " + c));
    }
    @Then("Displaying currencies with rates below {double}")
    public void showBelow(double prog) {
        currencies.stream()
                .filter(c -> c.getMid() < prog)
                .forEach(c -> logger.info("Below " + prog + ": " + c));
    }
}