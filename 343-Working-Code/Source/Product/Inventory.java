import java.util.ArrayList;
import java.util.Collections;

public class Inventory {
	private static Inventory inventoryInst = null;
	private Inventory() {} 
	
	
	// decreasing profit percent
	public void displayInventory(ArrayList<Product> list) {
        Collections.sort(list, new CompareProfit());
        for (int counter = 0; counter < list.size(); counter++) { 		      
            System.out.println(list.get(counter)); 		
        }   	

	}
	
	//increasing order quantity on hand
	public void displayInventory5OrFewier(ArrayList<Product> list) {
        Collections.sort(list, new CompareQuantity());
        for (int counter = 0; counter < list.size(); counter++) { 		      
           if(list.get(counter).getQuantity() <= 5) System.out.println(list.get(counter)); 		
        }   	

	}

	
	public static Inventory getInstance() {
		if(inventoryInst == null)
			inventoryInst = new Inventory();
		return inventoryInst;
	}

}
