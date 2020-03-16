import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class EcbAdaptor implements IExchange {

    private EuropeanCentralBankExchangeRateProvider ecbProvider;
    private Document document;

    public EcbAdaptor(EuropeanCentralBankExchangeRateProvider ecbProvider){
        this.ecbProvider=ecbProvider;
    }

    private String GetCurrencyValue(String currencyName){
        if(document==null)        {
            document=ecbProvider.getRates();
        }

        NodeList nodes=document.getElementsByTagName("Cube");
        for(int i=0;i<nodes.getLength();i++){
            if(nodes.item(i).hasChildNodes()) continue;
            if(!nodes.item(i).hasAttributes())continue;
            Element element=(Element)nodes.item(i);
            if(element.getAttributeNode("currency").getValue().equals(currencyName)){
                return element.getAttributeNode("rate").getValue();
            }
        }
        return "";
    }

    @Override
    public String GetDolarToEuro() {
        return GetCurrencyValue("USD");
    }

    @Override
    public String GetGbpToEuro() {
        return GetCurrencyValue("GBP");
    }
}
