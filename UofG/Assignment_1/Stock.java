package Assignment_1;

public class Stock {
	private final double COMMISSION = 9.99;
	private String name;
	private double quantity;
	private String symbol;
	private double  price;
	private double bookValue;
	private double gains;

	// Getters and setters 
	public String getName(){
		return name;
	}
	public void setName(String newName){
		this.name = newName;
	}

	public double getQuantity()
	{
		return quantity;
	}
	public void setQuantity(double newQty){
		try {
            this.quantity = newQty;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid double value.");
        }
	}

	public String getSymbol()
	{
		return symbol;
	}
	public void setSymbol(String newSymbol){
		this.symbol = newSymbol;
	}

	
	public void setPrice(double newPrice) {
        try {
            this.price = Math.abs(newPrice);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid double value.");
        }
    }
	public double getPrice() {
		return price;
	}


	// Methods
	public double findBookValue(double unitPrice)
	{
		bookValue = (getQuantity() * unitPrice) + COMMISSION;
		return bookValue;
	}
	public double getBookValue() {
		return bookValue;
	}
	public double paymentRecieved(){
		return (getQuantity() * getPrice()) - COMMISSION;
	}
	public double getGains() {
		return gains;
	}
	public double gain(double bookValueBefore, double bookValueAfter)
	{
		return gains = bookValueAfter - bookValueBefore;
	}
}
