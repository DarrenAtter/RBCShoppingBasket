package uk.co.atter.rbc.shoppingbasketpricer;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class PriceList {
	Map<String, BigDecimal> priceList = new HashMap<>();

	public void addItem(String item, String price) {
		priceList.put(item, new BigDecimal(price));
	}

	public BigDecimal getPrice(String item) {
		return priceList.get(item);
	}
}
