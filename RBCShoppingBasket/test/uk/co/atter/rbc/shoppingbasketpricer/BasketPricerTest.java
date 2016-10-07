package uk.co.atter.rbc.shoppingbasketpricer;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class BasketPricerTest {

	private static final String LEMON = "LEMON";
	private static final String APPLE = "Apple";
	private static final String BANANA = "Banana";
	
	private ShoppingBasket basket;
	PriceList pl = new PriceList();
	BasketPricer bp = new BasketPricer(pl);

	@Test
	public void priceBasketWithOneItem() throws UnpricedItemException {
		basket = new ShoppingBasket(BANANA);
		
		pl.addItem(BANANA, "0.35");
		
		assertEquals("0.35", bp.priceBasket(basket));
	}

	@Test
	public void priceBasketWithTwoItems() throws UnpricedItemException {
		basket = new ShoppingBasket(BANANA, APPLE);
		
		pl.addItem(BANANA, "0.35");
		pl.addItem(APPLE, "0.50");
		
		assertEquals("0.85", bp.priceBasket(basket));
	}
	
	@Test
	public void priceBasketWithMultipleOfSameItem() throws UnpricedItemException {
		basket = new ShoppingBasket(BANANA, BANANA);
		
		pl.addItem(BANANA, "0.35");
		
		assertEquals("0.70", bp.priceBasket(basket));
	}

	@Test
	public void priceBasketWithMixedSetOfItems() throws UnpricedItemException {
		basket = new ShoppingBasket(BANANA, BANANA, APPLE, LEMON, LEMON, LEMON);
		
		pl.addItem(BANANA, "0.35");
		pl.addItem(APPLE, "0.50");
		pl.addItem(LEMON, "0.10");
		
		assertEquals("1.50", bp.priceBasket(basket));
	}
	
	@Test
	public void priceBasketWithNoItems() throws UnpricedItemException {
		basket = new ShoppingBasket();
		
		assertEquals("0.00", bp.priceBasket(basket));
	}
	
	@Test(expected=UnpricedItemException.class)
	public void priceBasketWithUnpricedItemThrowsException() throws UnpricedItemException {
		basket = new ShoppingBasket(BANANA);
		
		bp.priceBasket(basket);
	}
	
	@Test
	public void voidTestIsInvalidPrice()
	{
		assertTrue(BasketPricer.invalidPrice(null));
		assertTrue(BasketPricer.invalidPrice(new BigDecimal("0.00")));
		assertTrue(BasketPricer.invalidPrice(new BigDecimal("1")));
		
		assertFalse(BasketPricer.invalidPrice(new BigDecimal("1.23")));
	}
	
}
