import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.awt.print.Printable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class RatesProvider implements IExchange{
	private JsonObject _jsonRates;
	public RatesProvider()
	{
		_jsonRates=getRates();
	}

	public JsonObject getRates()
	{
		String url_str = "http://data.fixer.io/api/latest?access_key=ec9b7c085cec16ecf8b0511fa11daacc&symbols=USD,GBP&format=1";
		try {
			// Making Request
			URL url = new URL(url_str);
			HttpURLConnection request = (HttpURLConnection) url.openConnection();
			request.connect();
			InputStreamReader content=new InputStreamReader((InputStream) request.getContent());

			// Convert to JSON
			JsonParser jp = new JsonParser();
			JsonElement root = jp.parse(content);
			return root.getAsJsonObject();

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public String GetDolarToEuro() {
		return _jsonRates.get("rates").getAsJsonObject().get("USD").toString();
	}

	public String GetGbpToEuro() {
		return _jsonRates.get("rates").getAsJsonObject().get("GBP").toString();
	}
}
