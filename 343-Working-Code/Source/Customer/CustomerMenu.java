//place holder todo
public class CustomerMenu {
	
	private static final CustomerMenu instance = new CustomerMenu();
	private int menuChoice;
	private CustomerMenu() { }
	public void custMenu() {

		
		System.out.println("Main Menu\n" +
				"1. Create Customer\n" +
				"2. Update Customer Address\n" +
				"3. Update Customer Sales Tax\n" +
				"4. Delete Customer\n" +
				"5. Display Customer\n" +
				"6. Quit");
		menuChoice = 0;
		menuChoice = CheckInput.getIntBetween(1, 6, "Menu Selection");
		String fname = "";
		String lname = "";
		String address = "";
		float tax = 0;
		int check = 0;
		System.out.println();
		switch(menuChoice) {
		case 1: // create customer
			System.out.println("Create Customer");
			fname = CheckInput.getString("First Name");
			lname = CheckInput.getString("Last Name");
			check = CustomerManager.search(fname, lname);
			if(check >= 0 && CustomerManager.get(check).getExistance()) {
				System.out.println("Customer already exists.\n");
				break;
			}
			CustomerManager.createCustomer(fname, lname, address, tax);
			System.out.println("Customer created.\n");
			break;
		case 2: // update cust address
			
			break;
		case 3: // update customer tax
			System.out.println("Update Customer's Tax");
			fname = CheckInput.getString("First Name");
			lname = CheckInput.getString("Last Name");
			check = CustomerManager.search(fname, lname);
			if(check < 0 || !CustomerManager.get(check).getExistance()) {
				System.out.println("Customer does not exist.\n");
				break;
			}
			tax = CheckInput.getPositiveFloat("New Tax");
			SalespersonManager.update(check, tax);
			System.out.println("Tax percentage upated.\n");
			break;
		case 4: // delete customer
			System.out.println("Delete Customer");
			fname = CheckInput.getString("First Name");
			lname = CheckInput.getString("Last Name");
			check = CustomerManager.search(fname, lname);
			if(check < 0 || !CustomerManager.get(check).getExistance()) {
				System.out.println("Customer does not exist.\n");
				break;
			}
			CustomerManager.delete(check);
			System.out.println("Customer deleted.\n");
			break;
		case 5: // display customer
			System.out.println("Display Customer");
			fname = CheckInput.getString("First Name");
			lname = CheckInput.getString("Last Name");
			check = CustomerManager.search(fname, lname);
			if(check < 0 || !CustomerManager.get(check).getExistance()) {
				System.out.println("Customer does not exist.\n");
				break;
			}
			System.out.println();
			CustomerManager.displayCustomer(check);
			System.out.println();			
			break;
		case 6: //quit
			break;
		default: // If somehow some invalid choice gets entered
			System.out.println("Invalid Menu Selection.");
			break;
		}
	}
	 public static CustomerMenu getInstance(){
	        return instance;
	 }
}
