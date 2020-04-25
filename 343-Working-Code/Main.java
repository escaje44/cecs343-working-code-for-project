import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main {
  public static void main(String[] args) {

    //creating managers
    InvoiceUI bills = InvoiceUI.getInvoiceUi();
    PayManager deposits = PayManager.getInstance();

    CustomerManager guests = CustomerManager.getInstance();
    ProductManager products = ProductManager.getProductManager();
    SalespersonManager workers = SalespersonManager.getInstance();

    //creating variables for testing
    String pName1 = "Red Pill"; double cost1 = 5.00; double retail1 = 20.45; int qty1 = 20;
    String pName2 = "Blue Pill"; double cost2 = 2.00; double retail2 = 11.45; int qty2 = 10;
    String pName3 = "Yello Pill"; double cost3 = 7.00; double retail3 = 7.45; int qty3 = 5;

    String fn1 = "Bob"; String ln1 = "Marley"; 
    float commp1 = 0.756f;
    String fn2 = "Dallas"; String ln2 = "Bigley"; 
    float commp2 = 0.34f;

    String cf1 = "Joe"; String cl1 = "Townshend";
    String ad1 = "55555 Bridges St.";
    float taxi1 = 1.35f;
    String cf2 = "Charlie"; String cl2 = "Del Toro";
    String ad2 = "55555 Benson Ross Ave.";
    float taxi2 = 1.35f;

    //preparing products for testing
    products.addProduct(pName1, cost1, retail1);
    Product RedPill = products.returnMatchingProduct(pName1);
    RedPill.adjustQuantity(qty1);
    //System.out.println(RedPill.getQuantity());

    products.addProduct(pName2, cost2, retail2);
    Product BluePill = products.returnMatchingProduct(pName2);
    BluePill.adjustQuantity(qty2);
    //System.out.println(BluePill.getQuantity());

    products.addProduct(pName3, cost3, retail3);
    Product YelloPill = products.returnMatchingProduct(pName3);
    YelloPill.adjustQuantity(qty3);
    //System.out.println(YelloPill.getQuantity());
    
    //preparing salespersons
    workers.create(fn1, ln1, commp1);
    workers.create(fn2, ln2, commp2);
    Salesperson BobMarley = workers.get(0);
    Salesperson DallasBigley = workers.get(1);

    //System.out.println(BobMarley.toString());
    //System.out.println(DallasBigley.toString());

    //preparing customers
    guests.createCustomer(cf1, cl1, ad1, taxi1);
    guests.createCustomer(cf2, cl2, ad2, taxi2);
    Customer JoeTownshend = guests.get(0);
    Customer CharlieDelToro = guests.get(1);
    //System.out.println(JoeTownshend.toString());
    //System.out.println(CharlieDelToro.toString());

    bills.invoiceMenu();
  };
}//end class