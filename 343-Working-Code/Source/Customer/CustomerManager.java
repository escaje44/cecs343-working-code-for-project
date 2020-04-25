import java.util.ArrayList;

public class CustomerManager {
	private static CustomerManager customerInst = null;
	private static ArrayList<Customer> customerList;
	
	private CustomerManager(){
		customerList = new ArrayList<Customer>();
	}
	private CustomerManager(ArrayList<Customer> custList){
		customerList = new ArrayList<Customer>();
		customerList.addAll(custList);
	}
	
	public static void createCustomer(String fName, String lName, String address, float tax){
		customerList.add(new Customer(fName,lName, address, tax));
	}
	
	public void updateAddr(int customerIndex, String addr){
		customerList.get(customerIndex).setAddress(addr);
	}
	
	public void updateTax(int customerIndex, float addr){
		customerList.get(customerIndex).setTax(addr);
	}
	
	public static void delete(int choice) {
		customerList.get(choice).setExistance(false);
	}
	
	public static int search(String fn, String ln) {
		for(int i = 0; i < customerList.size(); i++) {
			if(customerList.get(i).getFullName().equalsIgnoreCase(fn + " " + ln)) {
				return i;
			}
		}
		return -1;
	}
	
	public ArrayList<Customer> getCustomerList() { return customerList; }
	
	public static Customer get(int choice) { return customerList.get(choice); }
	public static void displayCustomers(){
		for( int i = 0; i < customerList.size(); i++){
			System.out.println(customerList.get(i).toString());
		}
	}
	public static void displayCustomer(int i){
		System.out.println(customerList.get(i).toString());
	}
	public static CustomerManager getInstance() {
		if(customerInst == null)
			customerInst = new CustomerManager();
		return customerInst;
	}
	
}
