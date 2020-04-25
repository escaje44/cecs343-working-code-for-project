import java.util.ArrayList;

class PayManager{
  private static ArrayList <Payment> payments;
  private static int number;
  private static PayManager payInst = null;

  private PayManager(){
    payments = new ArrayList<Payment>();
    number = 0;
  };

  public static void createPayment(Invoice bill, int bill_num, int[] date, float amnt){
    Payment deposit = new Payment(bill_num, date, amnt);
    bill.processPayment(deposit);
    payments.add(deposit);
    number = number + 1;
  };

  public static int getPayNum(){
    return number;
  }
  
  public static void display_payments(int invoice_num){
    for(int i = 0; i < payments.size(); i++){
      if(invoice_num == payments.get(i).getNumber()){
        payments.get(i).printPayment();
      }//end if()
    }//end for()
  };
  public static PayManager getInstance() {
		if(payInst == null)
			payInst = new PayManager();
		return payInst;
	}
}