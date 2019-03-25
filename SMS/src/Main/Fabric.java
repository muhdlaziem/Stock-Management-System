package Main;

public class Fabric extends Stock{
	private int Quantity;
	Fabric(){
		
	}
	
	Fabric(String Name, String ProductID, double Price, int Quantity){
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
		return "Fabric";
	}
	
	public String toString() {
	    return super.toString() + "<br>Quantity: " + getQuantity() + "<br>Type: " + getType() +"</span></html>";
	}

}
