import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import org.json.JSONObject;

public class URLTEST {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://valutakurser.dk");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuilder htmlContent = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                htmlContent.append(line);
            }
            br.close();

            Document document = Jsoup.parse(htmlContent.toString());
            Element jsonScript = document.getElementById("__NEXT_DATA__");
            if (jsonScript != null) {
                String jsonString = jsonScript.html();

                JSONObject jsonObject = new JSONObject(jsonString);
                JSONObject latestCurrencies = jsonObject.getJSONObject("props")
                        .getJSONObject("pageProps")
                        .getJSONObject("initiallyFetchedCurrencies");

                for (Object currency : latestCurrencies.getJSONArray("popular")) {
                    JSONObject currencyObj = (JSONObject) currency;
                    if (currencyObj.getString("currencyName").equals("Amerikanske dollar")) {
                        double actualValue = currencyObj.getDouble("actualValue");
                        double currencyChange = currencyObj.getDouble("currencyChange");

                        System.out.println("Exchange rate (DKK to USD): " + actualValue);
                        System.out.println("Currency Change: " + currencyChange);
                        break;
                    }
                }
            } else {
                System.out.println("No JSON data found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}