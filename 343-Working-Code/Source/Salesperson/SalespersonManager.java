/** SALESPERSON MANAGER CLASS **/
/**
 * The Salesperson manager class that manages what happens to a salesperson object
 */
import java.util.ArrayList;
public class SalespersonManager {
	/**
	 * Instance of SalespersonManager
	 */
	private static SalespersonManager salesInst = null;
	/**
	 * The ArrayList/Database of Salesperson
	 */
	private static ArrayList<Salesperson> salesDB;
	/**
	 * Salesperson Constructor
	 */
	private SalespersonManager() {
		salesDB  = new ArrayList<Salesperson>();
	}
	/**
	 * Gets the single instance of SalespersonManager; creates new SalespersonManager
	 * if it does not already exist
	 * @return SalespersonManager instance
	 */
	public static SalespersonManager getInstance() {
		if(salesInst == null)
			salesInst = new SalespersonManager();
		return salesInst;
	}
	/**
	 * Displays all information of a selected Salesperson
	 * @param choice selected index of Salesperson
	 */
	public static void display(int choice) {
		System.out.println(salesDB.get(choice).toString());
	}
	/**
	 * Creates a new Salesperson and adds it into the ArrayList
	 * @param fn first name of the Salesperson
	 * @param ln last name of the Salesperson
	 * @param commp commission percentage of the Salesperson
	 */
	public static void create(String fn, String ln, float commp) {
		Salesperson n = new Salesperson(fn, ln, commp);
		salesDB.add(n);
	}
	/**
	 * Updates the commission percent of a selected Salesperson
	 * @param choice selected index of Salesperson
	 * @param ncommp the new commission percent for Salesperson
	 */
	public static void update(int choice, float ncommp) {
		salesDB.get(choice).setComPercent(ncommp);
	}
	/**
	 * Marks a selected Salesperson as "deleted"
	 * @param choice selected index of Salesperson
	 */
	public static void delete(int choice) {
		salesDB.get(choice).setExistance(false);
	}
	/**
	 * Searches for a prompted Salesperson by name
	 * @param fn requested first name
	 * @param ln requested last name
	 * @return int of where the Salesperson exists inside the ArrayList, -1 if not
	 */
	public static int search(String fn, String ln) {
		for(int i = 0; i < salesDB.size(); i++) {
			if(salesDB.get(i).getFullName().equalsIgnoreCase(fn + " " + ln)) {
				return i;
			}
		}
		return -1;
	}
	/**
	 * Gets the Salesperson at index choice
	 * @param choice selected index of Salesperson
	 * @return the Salesperson at the given index
	 */
	public static Salesperson get(int choice) {
		return salesDB.get(choice);
	}
}
