
public class Stock {
	private String Name;
	private String ProductID;
	private double Price;

	Stock(){
		this("null","null",00.00);
	}
	Stock(String Name, String ProductID, double Price){
		this.Name = Name;
		this.ProductID = ProductID;
		this.Price = Price;
		
		
	}
	public void setName(String newName) {
		this.Name = newName;
	}
	public void setProductID(String newProductID) {
		this.ProductID = newProductID;
	}
	public void setPrice(double newPrice) {
		this.Price = newPrice;
	}
	
	
	//get method
	public String getName() {
		return this.Name;
	}
	public String getProductID() {
		return this.ProductID;
	}
	public double getPrice() {
		return this.Price;
	}
	public String toString() {
	    return "Name: " + getName() + "\nProduct ID: " +
	    		getProductID() + "\nPrice: RM "+ getPrice();
	}
	
	
	
	

}
