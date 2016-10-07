package uk.co.atter.rbc.shoppingbasketpricer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ShoppingBasket {
	Collection<String> items = new ArrayList<>(); 

	public ShoppingBasket(String... strings) {
		Collections.addAll(items,  strings);
	}

	public int getItemCount() {
		return items.size();
	}

	public Collection<String> getItems() {
		return Collections.unmodifiableCollection(items);
	}

}
