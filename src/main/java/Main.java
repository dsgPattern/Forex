import org.w3c.dom.*;


public class Main {
	public static void main(String[] args) {
		EuropeanCentralBankExchangeRateProvider ecbRates = new EuropeanCentralBankExchangeRateProvider();
		EuropeanCentralBankExchangeRateProvider.PrintXml(ecbRates.getRates());
		//TODO: we want to use this provider with the existing ExchangePrinter
		// for that we need to adapt it to implement IExchange

		
		ExchangePrinter.PrintExchangeRates(new RatesProvider());

		EcbAdaptor ecbAdaptor=new EcbAdaptor(ecbRates);
		ExchangePrinter.PrintExchangeRates(ecbAdaptor);


	}
}
