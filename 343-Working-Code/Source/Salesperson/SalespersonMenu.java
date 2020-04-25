/** SALESPERSON MENU CLASS **/
/**
 * The Salesperson menu class that displays what can be done to a salesperson object
 */ 
public class SalespersonMenu {
	/**
	 * Instance of the SalespersonMenu object
	 */
	private static SalespersonMenu salesInst = null;
	/**
	 * Integer holder of user input for menu choice 
	 */
	private int choice;
	/**
	 * SalespersonMenu constructor
	 */
	private SalespersonMenu() {
		choice = -1;
	}
	/**
	 * Gets the instance of SalespersonMenu; instantiates if null
	 * @return instances of SalespersonMenu
	 */
	public static SalespersonMenu getInstance() {
		if(salesInst == null){
			salesInst = new SalespersonMenu();
		}
		return salesInst;
	}
	/**
	 * Displays the menu and calls the respected functionalities based on user selections
	 */
	public void menu() {
		System.out.println("Salesperson Menu\n"+
							"1. Create\n"
							+ "2. Display\n"
							+ "3. Update Commission Percentage\n"
							+ "4. Delete");
		choice = CheckInput.getIntBetween(1, 4, "Salesperson Selection");
		String fname = "";
		String lname = "";
		int check = 0;
		float comm = 0f;
		System.out.println();
		switch(choice) {
		case 1: // Create
			System.out.println("Create Salesperson");
			fname = CheckInput.getString("First Name");
			lname = CheckInput.getString("Last Name");
			check = SalespersonManager.search(fname, lname);
			if(check >= 0 && SalespersonManager.get(check).getExistance()) {
				System.out.println("Salesperson already exists.\n");
				break;
			}
			comm = CheckInput.getPositiveFloat("Commission Percentage");
			SalespersonManager.create(fname, lname, comm);
			System.out.println("Salesperson created.\n");
			break;
		case 2: // Display
			System.out.println("Display Salesperson");
			fname = CheckInput.getString("First Name");
			lname = CheckInput.getString("Last Name");
			check = SalespersonManager.search(fname, lname);
			if(check < 0 || !SalespersonManager.get(check).getExistance()) {
				System.out.println("Salesperson does not exist.\n");
				break;
			}
			System.out.println();
			SalespersonManager.display(check);
			System.out.println();
			break;
		case 3: // Update Commission %
			System.out.println("Update Commission Percentage");
			fname = CheckInput.getString("First Name");
			lname = CheckInput.getString("Last Name");
			check = SalespersonManager.search(fname, lname);
			if(check < 0 || !SalespersonManager.get(check).getExistance()) {
				System.out.println("Salesperson does not exist.\n");
				break;
			}
			comm = CheckInput.getPositiveFloat("New Commission Percent");
			SalespersonManager.update(check, comm);
			System.out.println("Commission percentage upated.\n");
			break;
		case 4: // Delete
			System.out.println("Delete Salesperson");
			fname = CheckInput.getString("First Name");
			lname = CheckInput.getString("Last Name");
			check = SalespersonManager.search(fname, lname);
			if(check < 0 || !SalespersonManager.get(check).getExistance()) {
				System.out.println("Salesperson does not exist.\n");
				break;
			}
			SalespersonManager.delete(check);
			System.out.println("Salesperson deleted.\n");
			break;
		default:
			System.out.println("Invalid Selection.\n");
			break;
		}
	}
}
