import java.util.Arrays;

class Payment{
  private int invoice_paid; 
  private int pay_num = 0;
  private int date_size = 3;
  private int[] pay_date = new int[date_size];
  private float pay_amnt;

  //constructor
  Payment(int num, int[] date, float amnt){
    this.invoice_paid = num;
    this.pay_date = date.clone();
    this.pay_amnt = amnt; //caps at 32,767
    this.pay_num = pay_num + 1;
  }//end payment

  //get
  public Integer getNumber(){
    return this.invoice_paid;
  };

  public Float getAmnt(){
    return this.pay_amnt;
  };

  public String getDate(){
    //Arrays.toString(array));
    String temp = Arrays.toString(this.pay_date);
    return temp;
  };

  public Integer getMonth(){
    return this.pay_date[0];
  }
  
  public Integer getDay(){
    return this.pay_date[1];
  }

  public Integer getYear(){
    return this.pay_date[2];
  }
  public Integer getInvPaid(){
	    return this.getInvPaid();
	  }
  //display payment
  public void printPayment(){
     System.out.print("PAYMENTS:\n");
     System.out.print(" Date: [" + this.getMonth() + "," + this.getDay() + "," + this.getYear() + "]");
     
     System.out.println(" Invoice Number: " + this.invoice_paid + " <" + pay_num + ">");

     System.out.println(" Amount: $" + this.pay_amnt);
  };
};//end class