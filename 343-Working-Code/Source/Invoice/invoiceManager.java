
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class InvoiceManager{
  private static InvoiceManager invInst = null;
  private static ArrayList <Invoice> invoices;
  private static Scanner myObj = new Scanner(System.in);
  private static String temp;
  private int number;
  CheckInput checker = new CheckInput();

  private InvoiceManager(){
    invoices = new ArrayList<Invoice>();
    number = 0;
  };

  public int getSize(){
    return invoices.size();
  }

  public static void createInvoice(ProductManager ProductManager, SalespersonManager SalesPersonManager, CustomerManager CustomerManager){
    
    int invoice_num = InvoiceUI.setInvoiceNumber();
    int[] date = new int[3];
    date = InvoiceUI.getDate();
    
    
    ArrayList<Product> products = InvoiceUI.setProduct(ProductManager);
    List<Integer> product_qty = InvoiceUI.setQuantity(ProductManager, products, products.size());

    Salesperson seller = InvoiceUI.setPeople1(SalesPersonManager); 
    Customer buyer = InvoiceUI.setPeople2(CustomerManager);

    boolean shipping = InvoiceUI.setMethod();

    Invoice bill = new Invoice(invoice_num, date, products, product_qty, seller, buyer, shipping);
    invoices.add(bill);
  };

  public void printInvoice(int num){
    for (Invoice c : invoices) {
      //System.out.println(c.getNumber() + " == " + num); (debug)
      if (c.getNumber() == num){
        c.printInvoice();
      }
    }
  };//end print invoice shell function

  public static void displayOpenInvoices(){
    System.out.println("OPEN INVOICES:");
    boolean open = false;
    for(int i = 0; i < invoices.size(); i++) {
      open = invoices.get(i).getStatus();
      if(open == true){
        temp = invoices.get(i).getDate();
        System.out.print("Date: " + temp + " ");
        System.out.println("Invoice: " + invoices.get(i).getNumber());
      }
    }//for
  }//displayOpen

  public static void displayClosedInvoices(){
    System.out.println("CLOSED INVOICES:");
    boolean open = true;
    for(int i = 0; i < invoices.size(); i++) {
      open = invoices.get(i).getStatus();
      if(open == false){
        temp = invoices.get(i).getDate();
        System.out.print("Date: " + temp + " ");
        System.out.println("Invoice: " + invoices.get(i).getNumber());
      }
    }//for
  }//displayOpen

  public static void displayInvoiceShell(){
    int compare = 0; int temp_num = 0;
    System.out.println("DISPLAY INVOICE:");
    System.out.println("Enter Invoice Number: ");
    temp = myObj.nextLine();
    temp_num = Integer.valueOf(temp);
    for(int i = 0; i < invoices.size(); i++) {
      compare = invoices.get(i).getNumber();
      if(temp_num == compare){
        invoices.get(i).printInvoice();
      }
    }//end for
  }//end display shell

  public static void payInvoice(){
    boolean exist = false;
    int compare = 0; int number = 0; float pay_num = 0;
    int[] date = new int[3];

    do{
      if(invoices.size() == 0){
        exist = true;
      }else{
        number = InvoiceUI.setInvoiceNumber();

        for(int i = 0; i < invoices.size(); i++) {
          compare = invoices.get(i).getNumber();
          if(number == compare){

          //get amount
          pay_num = InvoiceUI.getAmountPaid();
          //get date
          date = InvoiceUI.getDate();
          PayManager.createPayment(invoices.get(i), number, date, pay_num);
          exist = true;
          }//if number matches
        }//for
      }//else
    }while(exist == false);//do-while
  };//pay invoice
  public static InvoiceManager getInstance() {
		if(invInst == null)
			invInst = new InvoiceManager();
		return invInst;
	}
  

}//end invoice manager
