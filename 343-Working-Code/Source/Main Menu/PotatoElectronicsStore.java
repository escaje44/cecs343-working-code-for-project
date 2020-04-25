// THIS IS THE MAIN METHOD
public class PotatoElectronicsStore {
	public static void main(String args[]) {
		
		/* PASSWORD AUTHENTICATION */
		passwordCheck();

		/* INITIATE MANAGERS/ARRAYLIST DATABASES */
		SalespersonManager salesManage = SalespersonManager.getInstance();
		CustomerManager customerManage = CustomerManager.getInstance();
		Inventory inventoryManage = Inventory.getInstance();
		ProductManager productManage = ProductManager.getProductManager();

		/* INITIATE Sub Menus */
		SalespersonMenu salesMenu = SalespersonMenu.getInstance();
		CustomerMenu customerMenu = CustomerMenu.getInstance();
		InventoryMenu inventoryMenu = InventoryMenu.getInstance();
		
		/* MAIN MENU LOOP */
		boolean quit = false;
		int menuChoice = 0;
		while(!quit) {
			displayMainMenu();
			menuChoice = CheckInput.getIntBetween(1, 6, "Menu Selection");
			System.out.println();
			switch(menuChoice) {
			case 1: // Go to Customer Menu
				customerMenu.custMenu();
				break;
			case 2: // Go to Salesperson Menu
				salesMenu.menu();
				break;
			case 3: // Go to Product Menu
				ProductView.createMenu();
				break;
			case 4: // Go to Inventory Menu
				inventoryMenu.invMenu();
				break;
			case 5: // Go to Invoice Menu
				break;
			case 6: // Quit Program
				quit = true;
				break;
			default: // If somehow some invalid choice gets entered
				System.out.println("Invalid Menu Selection.");
				break;
			}
		}
		
		System.out.println("Goodbye!");
	}
	
	public static void displayMainMenu() {
		System.out.println("Main Menu\n" +
							"1. Customer\n" +
							"2. Salesperson\n" +
							"3. Product\n" +
							"4. Inventory\n" +
							"5. Invoice\n" +
							"6. Quit");
	}

	public static void passwordCheck() {
		while (!CheckInput.getString("Please enter the correct password").equals("potato"));
	}
}
