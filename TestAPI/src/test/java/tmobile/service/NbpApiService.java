package tmobile.service;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import tmobile.model.Currency;
import tmobile.model.ExchangeTable;

import java.util.List;
import java.util.logging.Logger;

public class NbpApiService {
    private static final String NBP_URL = "http://api.nbp.pl/api/exchangerates/tables/A?format=json";
    private static Response response;
    private static final Logger logger = Logger.getLogger(NbpApiService.class.getName());

    public static void fetchRates() {
        response = RestAssured.get(NBP_URL);
    }

    public static List<Currency> getCurrencies() {
        List<ExchangeTable> table = response.jsonPath().getList("", ExchangeTable.class);
        return table.get(0).getRates();
    }

    public static int getStatusCode() {
        return response.statusCode();
    }
}