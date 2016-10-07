package uk.co.atter.rbc.shoppingbasketpricer;

import java.math.BigDecimal;

public class BasketPricer {
	PriceList priceList;

	public BasketPricer(PriceList pl) {
		priceList = pl;
	}

	public String priceBasket(ShoppingBasket basket) throws UnpricedItemException {
		BigDecimal basketTotal = new BigDecimal("0.00");
		
		for (String item : basket.getItems())
		{
			BigDecimal itemPrice = priceList.getPrice(item);
			
			if(invalidPrice(itemPrice))
				throw new UnpricedItemException(item);
			
			basketTotal = basketTotal.add(itemPrice);
		}
		
		return basketTotal.toString();
	}

	public static boolean invalidPrice(BigDecimal itemPrice) {
		if (itemPrice == null)
			return true;
		
		if (itemPrice.equals(new BigDecimal("0.00")))
			return true;
		
		if (itemPrice.scale() != 2)
			return true;
		
		return false;
	}

}
