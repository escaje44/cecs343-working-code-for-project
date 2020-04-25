import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.*;
import java.text.*;

class InvoiceUI{
  //
  private static Scanner myObj = new Scanner(System.in);
  private static CheckInput checker = new CheckInput();
  private static InvoiceUI singleton = null;

  //input/output variables
  private static int input_integer = 0;
  private static float input_float = 0;
  private static String input_String;
  private static String prompt;
  private InvoiceUI() {
	  input_integer = 0;
	  input_float = 0;
	  input_String = "";
	  prompt = "";
    InvoiceManager bills = InvoiceManager.getInstance();
  }

   void invoiceMenu(){
  boolean back = false;

  do{
    System.out.print("\n");
    System.out.println("::: INVOICE MENU :::");
    System.out.println("(1) - Create Invoice");
    System.out.println("(2) - Display Open Invoices");
    System.out.println("(3) - Display Closed Invoices");
    System.out.println("(4) - Display Invoice");
    System.out.println("(5) - Pay Invoice");
    System.out.println("(6) - Return to Main Menu");
    System.out.print("\n");

    prompt = "Please enter option";
    input_integer = CheckInput.getIntBetween(1, 6, prompt);

    if(input_integer == 1){
      InvoiceManager.createInvoice(ProductManager.getProductManager(), SalespersonManager.getInstance(), CustomerManager.getInstance()); 
      input_integer = 0;
    }else if(input_integer == 2){
      InvoiceManager.displayOpenInvoices(); 
      input_integer = 0;
    }else if(input_integer == 3){
      InvoiceManager.displayClosedInvoices(); 
      input_integer = 0;
    }else if(input_integer == 4){
      InvoiceManager.displayInvoiceShell(); 
      input_integer = 0;
    }else if(input_integer == 5){
      InvoiceManager.payInvoice(); 
      input_integer = 0;
    }else if(input_integer == 6){
      back = true; input_integer = 0;
    }//else if
    System.out.print("\n");
  }while(back == false);
  //enter return-to-main here
  };

  public static int[] getDate(){
    int[] date = new int[3];
    prompt = "Enter Month: ";
    date[0] = CheckInput.getIntBetween(1,12,prompt);
    prompt = "Enter Day: ";
    date[1] = CheckInput.getIntBetween(1,30,prompt);
    prompt = "Enter Year: ";
    date[2] = CheckInput.getPositiveInt(prompt);
    return date;
  };

  public static int setInvoiceNumber(){
    prompt = "Enter Invoice Number as an Integer: ";
    input_integer = CheckInput.getPositiveInt(prompt);
    return input_integer;
  };

  public static ArrayList<Product> setProduct(ProductManager manager){
    boolean stop = false; boolean exist = false;
    Product item; ArrayList<Product> product_list = new ArrayList<Product>();

    do{

      System.out.println("Enter Product Name: ");
      input_String = myObj.nextLine();
      exist = manager.searchForMatchingProduct(input_String);
      if(exist == true){
        item = manager.returnMatchingProduct(input_String);
        product_list.add(item);
      }
      System.out.println("Finished adding products? Type 'END' if yes. If not, press Enter.");
      input_String = myObj.nextLine();
      stop = input_String.equals("END");
    }while(stop == false);
    return product_list;
  };//end set product

  public static List<Integer> setQuantity(ProductManager ProductManager, ArrayList<Product> items, int size){
    boolean stop = false; boolean exist = false;
    List<Integer> prod_qty = new ArrayList<Integer>();
    for(int i = 0; i < items.size(); i = i + 1){
      do{
        prompt = "Enter Product Quantity as a positive integer: ";
        input_integer = CheckInput.getPositiveInt(prompt);
      }while( (input_integer > items.get(i).getQuantity()) | (input_integer < 0) );

      items.get(i).adjustQuantity((-1*input_integer));
      prod_qty.add(input_integer);
    }//end for
    return prod_qty;
  };//end set quantities

   public static Salesperson setPeople1(SalespersonManager SalespersonManager){
    boolean exist = false; int iexist = 0;
    do{
      System.out.println("Enter Salesperson Name in the following format... ");
      System.out.println("<FIRST NAME> <SPACE> <LAST NAME>");
      String fname = CheckInput.getString("First Name");
      String lname = CheckInput.getString("Last Name");
      iexist = SalespersonManager.search(fname, lname);
      if(iexist >= 0 && SalespersonManager.get(iexist).getExistance()){
        exist = true;
      }
    }while(exist == false);
    return SalespersonManager.get(iexist);
  };//end set people(1)

  public static Customer setPeople2(CustomerManager CustomerManager){
    boolean exist = false; int iexist = 0;
    do{
      System.out.println("Enter Customer Name in the following format... ");
      String fname = CheckInput.getString("First Name");
      String lname = CheckInput.getString("Last Name");
      iexist = CustomerManager.search(fname, lname);
      if(iexist >= 0 && CustomerManager.get(iexist).getExistance()){
          exist = true;
        }
    }while(exist == false);
    return CustomerManager.get(iexist);
  };//end set people(1)

  public static boolean setMethod(){
    boolean valid = false; boolean method = false;
    do{
      System.out.println("Which method will you use to receive the product?");
      System.out.println("Type 'A' for Shipping, 'B' for In-Store Pickup");
      input_String = myObj.nextLine();
      valid = (input_String.equals("A") | input_String.equals("a") | input_String.equals("B") | input_String.equals("b"));
      if(valid == true){
        if(input_String.equals("A") | input_String.equals("a")){
          method = true; //shipping 
        }else if(input_String.equals("B") | input_String.equals("b")){
          method = false; //in-store
        }
      }
    }while(valid == false);
    return method;
  };

  public static Float getAmountPaid(){
    int compare = 0; int[] date = new int[3];

    System.out.println("Enter Amount Paid to Invoice, ");
    prompt = ("Please enter: $");
    input_float = checker.getPositiveFloat(prompt);
    return input_float;
  };
  public static InvoiceUI getInvoiceUi(){
      if (singleton == null) {
          singleton = new InvoiceUI();
      }
      return singleton;
  }
}//