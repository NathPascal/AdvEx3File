//3.2 : création de la classe Price

public class Price {
	String name;
	int priceItems;
	
	public Price(String name, int priceItems) {
	
		this.name = name;
		this.priceItems = priceItems;
	}

	@Override
	public String toString() {
		return name + " (" + priceItems + "€)";
	}
	
	
}
