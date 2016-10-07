package uk.co.atter.rbc.shoppingbasketpricer;

import static org.junit.Assert.*;

import org.junit.Test;

public class ShoppingBasketTest {

	@Test
	public void testGetItemsCount() {
		ShoppingBasket sb = new ShoppingBasket("Banana", "Apple");
		assertEquals(2,  sb.getItemCount());
	}

	@Test
	public void testGetItems() {
		ShoppingBasket sb = new ShoppingBasket("Banana", "Apple");
		assertTrue(sb.getItems().contains("Apple"));
		assertTrue(sb.getItems().contains("Banana"));
	}

}
