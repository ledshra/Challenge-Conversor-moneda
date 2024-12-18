import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ExchangeRateProvider {
    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/";

    public CurrencyData getExchangeRates(String baseCurrency) throws Exception {
        URL url = new URL(API_URL + baseCurrency);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        InputStreamReader reader = new InputStreamReader(connection.getInputStream());
        Gson gson = new Gson();
        CurrencyData data = gson.fromJson(reader, CurrencyData.class);
        reader.close();

        return data;
    }
}