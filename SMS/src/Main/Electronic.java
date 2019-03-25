package Main;


public class Electronic extends Stock{
	private int Quantity;
	Electronic(){
		
	}
	
	Electronic(String Name, String ProductID, double Price, int Quantity){
		super(Name,ProductID,Price);
		this.Quantity = Quantity;
		
	}
	
	//set method
	public void setQuantity(int newQuantity) {
		this.Quantity = newQuantity;
	}
	//get method
	public int getQuantity() {
		return this.Quantity;
	}
	public String getType() {
		return "Electronic";
	}
	
	public String toString() {
	    return super.toString() + "<br>Quantity: " + getQuantity() + "<br>Type: " + getType() +"</span></html>";
	}

}

