//place holder todo
public class InventoryMenu {
	private static final InventoryMenu instance = new InventoryMenu();

	private int menuChoice;
	private InventoryMenu() {}
	
	public void invMenu() {
		Inventory inventoryManage = Inventory.getInstance();

		System.out.println("Main Menu\n" +
				"1. Display Inventory\n" +
				"2. Update inventory" +
				"3. Display Inventory less than 5\n" +
				"4. Quit");
		menuChoice = 0;
		menuChoice = CheckInput.getIntBetween(1, 2, "Menu Selection");
		System.out.println();
		switch(menuChoice) {
		case 1: // display Inventory
			System.out.println("Display Inventory");
			inventoryManage.displayInventory(ProductManager.getProductManager().getProductsList());
			break;
		case 2: // update inventory
			break;
		case 3://display 5 or fewier
			System.out.println("Display Inventory with 5 or fewier");
			inventoryManage.displayInventory5OrFewier(ProductManager.getProductManager().getProductsList());
			break;
		case 4: // quit
			break;
		default: // If somehow some invalid choice gets entered
			System.out.println("Invalid Menu Selection.");
			break;
		}
	}
	 public static InventoryMenu getInstance(){
	        return instance;
	 }
}
