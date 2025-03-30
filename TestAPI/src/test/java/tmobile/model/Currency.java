package tmobile.model;

public class Currency {
    private String currency;
    private String code;
    private double mid;

    public String getCurrency() {
        return currency;
    }

    public String getCode() {
        return code;
    }

    public double getMid() {
        return mid;
    }

    @Override
    public String toString() {
        return code + " (" + currency + "): " + mid;
    }
}