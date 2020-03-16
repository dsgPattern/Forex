public class ExchangePrinter {
    public static void PrintExchangeRates(IExchange exchange){
        System.out.println("Euro to $ rate = " + exchange.GetDolarToEuro());
        System.out.println("Euro to GBP rate = " + exchange.GetGbpToEuro());
    }
}
