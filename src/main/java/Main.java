import org.w3c.dom.*;


public class Main {
	public static void main(String[] args) {
		//EuropeanCentralBankExchangeRateProvider ecbRates = new EuropeanCentralBankExchangeRateProvider();
		ExchangePrinter.PrintExchangeRates(new RatesProvider());
	}
}
