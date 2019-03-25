
public class Fabric extends Stock{
	private int Quantity;
	private String BestBefore;
	private java.util.Date DateReceived;
	
	Fabric(String Name, String ProductID, double Price, int Quantity, String BestBefore){
		super(Name,ProductID,Price);
		this.Quantity = Quantity;
		this.BestBefore = BestBefore;
		DateReceived = new java.util.Date();
	}
	
	//set method
	public void setQuantity(int newQuantity) {
		this.Quantity = newQuantity;
	}
	public void setBestBefore(String newBestBefore) {
		this.BestBefore = newBestBefore;
	}
	
	//get method
	public int getQuantity() {
		return this.Quantity;
	}
	public String getBestBefore() {
		return this.BestBefore;
	}
	public java.util.Date getDateReceived() {
		return this.DateReceived;
	}

}
