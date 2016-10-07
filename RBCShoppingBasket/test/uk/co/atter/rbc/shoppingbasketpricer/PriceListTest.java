package uk.co.atter.rbc.shoppingbasketpricer;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class PriceListTest {

	@Test
	public void getPriceOfItem() {
		PriceList pl = new PriceList();
		
		pl.addItem("Banana", "0.35");
		
		assertEquals(new BigDecimal("0.35"), pl.getPrice("Banana"));
	}

}
