public class Customer {
	private String fName;
	private String lName;
	private String address;
	private float tax;
	private boolean exists;

	public Customer(){
		fName = "";
		lName = "";
		address = "";
		tax = 0;
		exists = true;
	}
	public Customer(String fName, String lName, String address, float tax){
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.tax = tax;
		this.exists = true;

	}
	public String getFName(){return fName;}
	public void setFName(String name) {fName = name;}
	
	public String getLName(){return lName;}
	public void setLName(String name) {lName = name;}
	
	public String getAddress(){return address;}
	public void setAddress(String addr) {address = addr;}
	
	public float getTax(){return tax;}
	public void setTax(float tax) {this.tax = tax;}
	
	public boolean getExistance() {
		return exists;
	}
	public void setExistance(boolean ex) {
		exists = ex;
	}
	
	public String getFullName() {
		return fName + " " + lName;
	}
	
	public String toString(){
		return fName + lName + ", "+ address + " :: " + tax;
	}
}
