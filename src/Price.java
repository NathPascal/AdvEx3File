//3.2
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
