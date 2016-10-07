package uk.co.atter.rbc.shoppingbasketpricer;

public class UnpricedItemException extends Exception {
	String item;

	public UnpricedItemException(String item) {
		this.item = item;
	}
	
	@Override
	public String toString()
	{
		return "Item: " + item + " is not priced.";
	}
	
	

	private static final long serialVersionUID = 2246995023780426605L;
}
