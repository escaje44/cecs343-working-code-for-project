import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.text.*;

class Invoice{

  //V A R I A B L E S
  int invoice_num;
  int date_size = 3;
  int[] purchase_date = new int[date_size];

  ArrayList<Product> product = new ArrayList<>();
  List<Integer> product_qty = new ArrayList<>();
  List<Double> product_extens = new ArrayList<>();

  Salesperson seller;
  Customer client;

  boolean shipping;
  //int freight_charge;
  double totalInvoiceAmount;
  double amountLeftToPay;
  boolean open_stat;

  //Invoice Constructor
   Invoice( int number, int[] date, ArrayList<Product> product_list, List<Integer> qty_list, Salesperson agent, Customer buyer, boolean freight){
    this.invoice_num = number;
    this.purchase_date = date.clone();
    this.product = (ArrayList<Product>)product_list.clone();
    this.product_qty.addAll(qty_list);
    this.product_extens = calculateExtension();
    this.seller = agent;
    this.client = buyer;
    this.shipping = freight;
    this.open_stat = true;
    this.totalInvoiceAmount = calculateTotals();
    this.amountLeftToPay = totalInvoiceAmount;
  };

  //G E T - Functions
  public Integer getNumber(){
    return this.invoice_num;
  };

  public boolean getStatus(){
    return this.open_stat;
  };

  public String getDate(){
    //Arrays.toString(array));
    String temp = Arrays.toString(this.purchase_date);
    return temp;
  };

  //(Private) Calculations
  private List<Double> calculateExtension(){
    List<Double> temp = new ArrayList<Double>();
    double e = 0; 
    int q = 0; double s = 0;
    for(int i = 0; i < product.size(); i++) {
      q = this.product_qty.get(i);
      s = this.product.get(i).getSalesPrice();
      e = q * s;
      temp.add(e);
    }//end for
    return temp;
  };

  public Double calculateTotals(){
    double temp = 0; double e = 0; 
    for(int i = 0; i < product.size(); i++) {
      e = this.product_extens.get(i);
      temp = temp + e;
    }//end for
    temp = temp + this.client.getTax();
    return temp;
  }


   //Process Payment
  public void processPayment(Payment payme){
    double temp_pay = 0;
    if(payme.getInvPaid()== this.invoice_num){

      if(temp_pay == this.amountLeftToPay){
        temp_pay = this.calculateCharges_Discount(payme);
      }else{temp_pay = this.amountLeftToPay;}
      //deny payment if over the amount left
      this.amountLeftToPay = temp_pay - payme.getAmnt();
      if( this.amountLeftToPay <= 0){
        this.amountLeftToPay = 0;
        this.open_stat = false;
      }//if left to pay is negative
    }//if correct invoice
  };

  public Double calculateCharges_Discount(Payment payme){
    int month = (payme.getMonth()) - this.purchase_date[0];
    int day = (payme.getDay()) - this.purchase_date[1];
    int year = (payme.getYear()) - this.purchase_date[2];
    if(month > 0){
      switch(month){
        case 1:day = Math.abs(day) + 30;
        case 2:day = Math.abs(day) + 60;
        case 3:day = Math.abs(day) + 90;
        case 4:day = Math.abs(day) + 120;
        case 5:day = Math.abs(day) + 150;
        case 6:day = Math.abs(day) + 180;
        case 7:day = Math.abs(day) + 210;
        case 8:day = Math.abs(day) + 240;
        case 9:day = Math.abs(day) + 270;
        case 10:day = Math.abs(day) + 300;
        case 11:day = Math.abs(day) + 330;
        case 12:day = Math.abs(day) + 360;
    }//end case(month)
      if(day > 30){
          return (this.amountLeftToPay + (this.amountLeftToPay * 0.02));
      }//end if day > 30
      return this.amountLeftToPay;
    }else{
      if(day < 10){
        return (this.amountLeftToPay - (this.amountLeftToPay * 0.1));
      }//if day < 10
      return this.amountLeftToPay;
    }//end if-else(month>0)
  }//end calc

   //Display Invoice
  public void printInvoice(){
    System.out.print("Date: " +this.getDate() + " ");
    System.out.println(" Invoice Number: " + this.invoice_num);

    

    System.out.println("Salesperson: " + this.seller.toString());
    System.out.println("Customer: " + this.client.getFName() + " " + this.client.getLName());

    for(int i = 0; i < product.size(); i++) {
      System.out.print("Product Num. "+ (i+1) + "\n");
      System.out.print("Name: " + this.product.get(i).getName() + " ");
      System.out.print(" Qty: " + this.product_qty.get(i) + ", ");
      System.out.print(" Retail: $" + this.product.get(i).getSalesPrice()+ " - ");
      System.out.print("Extension: $" + this.product_extens.get(i) + "\n");
    }//end for

    if(this.shipping == true){
      System.out.println("Method: Shipping");
    }//end if
    else{
      System.out.println("Method: In-Store Pickup");
    }//end else
    
    DecimalFormat df = new DecimalFormat("#.##");

    System.out.println("Total: $" + df.format(totalInvoiceAmount));

    if(this.open_stat == true){
      System.out.println("Amount Left: $" + df.format(amountLeftToPay));
    }
    if(PayManager.getPayNum() > 0){
      PayManager.display_payments(this.invoice_num);
    }
  }//end printInvoice()
  
}//end Invoice Class