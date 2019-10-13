import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.net.URL;

public class Parser {
private static Document getPage() throws IOException {
	String url = "https://finance.i.ua/";
	Document page = Jsoup.parse(new URL(url), 3000);
	return page;
}


public static void main(String[] args) throws IOException {
	Document page = getPage();
	Element currencyBankRateUA = page.select("table[id=latest_currency_container]").first();
	Elements currencyUSD = currencyBankRateUA.select("tbody[class=bank_rates_usd]");
	Elements currencyEUR = currencyBankRateUA.select("tbody[class=bank_rates_eur]");
	Elements currencyRUB = currencyBankRateUA.select("tbody[class=bank_rates_rub]");
	
	System.out.println("Банк\t" + "Купівля\t" + "Продаж\t");
	for (Element tr : currencyUSD.select("tr")) {
		System.out.print(tr.text() + "\n");
	}
	System.out.println("\n" + "Банк\t" + "Купівля\t" + "Продаж\t");
	for (Element tr : currencyEUR.select("tr")) {
		System.out.print(tr.text() + "\n");
	}
	System.out.println("\n" + "Банк\t" + "Купівля\t" + "Продаж\t");
	for (Element tr : currencyRUB.select("tr")) {
		System.out.print(tr.text() + "\n");
	}
	
}
}
