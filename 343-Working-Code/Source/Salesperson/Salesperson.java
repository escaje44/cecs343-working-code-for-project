/** SALESPERSON ENTITY CLASS **/
/**
 * The Salesperson entity class that creates a Salesperson object
 */
public class Salesperson {
	/**
	 * First name of Salesperson
	 */
	private String fName;
	/**
	 * Last name of Salesperson
	 */
	private String lName;
	/**
	 * Commission percent of Salesperson
	 */
	private float comPercent;
	/**
	 * Commission total of Salesperson
	 */
	private float comTotal;
	/**
	 * Sales total of Salesperson
	 */
	private float salesTotal;
	/**
	 * Existence of the salesperson
	 */
	private boolean exists;
	/**
	 * Default Salesperson constructor
	 */
	public Salesperson(){
		fName = "";
		lName = "";
		comPercent = 0f;
		comTotal = 0f;
		salesTotal = 0f;
		exists = true;
	}
	/**
	 * Overflowed Salesperson constructor
	 * @param fName first name of salesperson
	 * @param lName last name of salesperson
	 * @param comPercent commission percent that the salesperson receives
	 */
	public Salesperson(String fName, String lName, float comPercent){
		this.fName = fName;
		this.lName = lName;
		this.comPercent = comPercent;
		comTotal = 0f;
		salesTotal = 0f;
		exists = true;
	}
	/**
	 * Returns the first name of the Salesperson
	 * @return fname first name
	 */
	public String getFName() {
		return fName;
	}
	/**
	 * Sets the first name of the Salesperson to the given string
	 * @param fn first name to be updated to
	 */
	public void setFName(String fn) {
		fName = fn;
	}
	/**
	 * Returns the last name of the Salesperson
	 * @return lname last name
	 */
	public String getLName() {
		return lName;
	}
	/**
	 * Sets the last name of the Salesperson to the given string
	 * @param ln last name to be updated to
	 */
	public void setLName(String ln) {
		lName = ln;
	}
	/**
	 * Returns the commission percent of the Salesperson
	 * @return comPercent commission percent
	 */
	public float getComPercent() {
		return comPercent;
	}
	/**
	 * Sets the commission percent of the Salesperson to the given commission percent
	 * @param cp new commission percent
	 */
	public void setComPercent(float cp) {
		comPercent = cp;
	}
	/**
	 * Returns the total sales that the Salesperson has sold
	 * @return salesTotal total amount in sales
	 */
	public float getSalesTotal() {
		return salesTotal;
	}
	/**
	 * Adds to the total amount that the salesperson has sold
	 * @param sold the amount to add onto the total amount of sales
	 */
	public void addToSales(float sold) {
		salesTotal += sold;
	}
	/**
	 * Returns to total amount that the Salesperson has made in commission
	 * @return comTotal total earned through commission
	 */
	public float getComTotal() {
		return comTotal;
	}
	/**
	 * Adds to the total amount that the salesperson has earned through commission
	 * @param earned total earned through commission to add through the total commission earned
	 */
	public void addToComTotal(float earned) {
		comTotal += earned;
	}
	/**
	 * Returns the existence of the Salesperson
	 * @return exists whether the Salesperson 
	 */
	public boolean getExistance() {
		return exists;
	}
	/**
	 * Sets the existence of the salesperson to the given boolean
	 * @param ex boolean that defines the salesperson's existence
	 */
	public void setExistance(boolean ex) {
		exists = ex;
	}
	/**
	 * Gets the full name of the Salesperson
	 * @return a string of both the first and last name
	 */
	public String getFullName() {
		return fName + " " + lName;
	}
	
	/**
	 * The string representation of all of Salesperson's data
	 * FirstName LastName - Commission %: x.xx
	 * Total Sold: $xx.xx
	 * Total Earned in Commissions: $x.xx
	 */
	@Override
	public String toString() {
		return fName + " " + lName + " - Commission %: " + comPercent +
				"\nTotal Sold: $" + salesTotal +
				"\nTotal Earned in Commissions: $" + comTotal;
	}
}
