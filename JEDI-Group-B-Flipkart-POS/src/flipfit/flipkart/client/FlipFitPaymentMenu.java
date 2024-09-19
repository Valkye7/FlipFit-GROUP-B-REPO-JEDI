package flipfit.flipkart.client;
import java.util.Scanner;
public class FlipFitPaymentMenu {

    public static boolean getFlipFitPaymentMenu(){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("\nWe provide the following modes of payment:");
            System.out.println("        1. Credit Card");
            System.out.println("        2. Debit Card");
            System.out.println("        3. UPI");
            System.out.println("        4. NEFT/RTGS");
            System.out.print("Please enter your choice: ");
            int paymentChoice = sc.nextInt();

            System.out.print("Enter Transaction ID:   ");
            String transactionId = sc.next();

            if(transactionId.startsWith("FFGSB")){
                System.out.println("---Transaction Completed---");
                return true;
            } else {
                System.out.println("Invalid TransactionID. Please try again.");
            }
        }
    }
}
