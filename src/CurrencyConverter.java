public class CurrencyConverter {
    private CurrencyData currencyData;

    public CurrencyConverter(CurrencyData currencyData) {
        this.currencyData = currencyData;
    }

    public double convert(String fromCurrency, String toCurrency, double amount) {
        double fromRate = currencyData.getRates().get(fromCurrency);
        double toRate = currencyData.getRates().get(toCurrency);

        return (amount / fromRate) * toRate;
    }
}
