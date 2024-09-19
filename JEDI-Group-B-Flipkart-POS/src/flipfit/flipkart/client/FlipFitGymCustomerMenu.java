package flipfit.flipkart.client;
import java.util.Scanner;
public class FlipFitGymCustomerMenu {
    public static void getFlipFitCustomerMenu(){


            Scanner sc = new Scanner(System.in);

            int choice = 0;

            do {
                System.out.println(" ");
                System.out.println("===========================");
                System.out.println("    FlipFit Customer Menu   ");
                System.out.println("===========================");

                System.out.println("""
                        Choose an option:
                         1. View Booked Slots
                         2. View Centres
                         3. Logout
                        """);

                choice = sc.nextInt();

                switch (choice) {
                    case 1: {
                        System.out.println("=========== View Booked Slots ===========");
                        System.out.println("---List of Booked Slots---");

                        System.out.println("Type 1. If you wish to cancel");
                        System.out.println("Type 2. To return to main menu");

                        choice = sc.nextInt();

                        if (choice == 1) {
                            System.out.println("Choose the booking ID you wish to cancel:> ");
                            int bookingId = sc.nextInt();
                            System.out.print("---Booking Cancelled---");
                        }

                        break;
                    }
                    case 2: {
                        System.out.println("=========== View Centres ===========");

                        System.out.println("--- Center List with centerID , city , pincode ---");

                        System.out.println("Choose a centreID you want to book a slot in:> ");
                        int centreId = sc.nextInt();


                        System.out.println("These are the available slots:");

                        System.out.println("--- List of available slots with slotID , Timing , centerID ---");

                        System.out.println("Give the start time you wish to book:> ");
                        int startTime = sc.nextInt();

                        System.out.println("Give the centre ID:> ");
                        int centreID = sc.nextInt();

                        System.out.println("--- Slot Booked ---");

                        break;
                    }
                    case 3: {
                        System.out.println("Successfully logged out");
                        return;
                    }
                }
            } while (choice != 4);

    }
}
