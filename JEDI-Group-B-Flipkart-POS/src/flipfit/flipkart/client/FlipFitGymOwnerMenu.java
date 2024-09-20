package flipfit.flipkart.client;

import java.util.Scanner;

public class FlipFitGymOwnerMenu {
    public static void getFlipFitGymOwnerView(){

        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println(" ");
            System.out.println("------------------------------------------------");
            System.out.println(" --------- FlipFit owner view --------- ");
            System.out.println("------------------------------------------------");
            System.out.println(" ");

            System.out.println("""
                        Choose an option:
                         1. Add Centre
                         2. View Centres
                         3. Add Slot
                         4. Delete Slot
                         5. Logout
                        """);

            choice = sc.nextInt();
            switch (choice){
                case 1: {
                    System.out.println(" -------- Add Centre -------- ");
                    Scanner scanner = new Scanner(System.in);

                    System.out.print("Enter Capacity");
                    int capacity = scanner.nextInt();

                    System.out.print("Enter City");
                    String city = scanner.next();

                    System.out.print("Enter State");
                    String state = scanner.next();

                    System.out.print("Enter Pincode");
                    String pincode = scanner.next();

                    System.out.println("Gym Centre created successfully at "+ city + " with pincode: "+ pincode);

                }
                case 2: {
                    System.out.println("------------- View Centres for the owner ------------ ");
                    break;
                }
                case 3: {
                    System.out.println(" ------------ Add Slot in a Gym ------------ ");

                    System.out.print("Enter gym centre ID");
                    int centreId = sc.nextInt();

                    System.out.print("Enter slot time");
                    int slotTime = sc.nextInt();

                    System.out.print("Enter the max capacity of the slot");
                    int maxCapacity = sc.nextInt();

                    System.out.println("Slot created successfully with Slot Time: "+ slotTime + " and maximum Capacity: " + maxCapacity);
                    break;
                }
                case 4: {
                    System.out.println(" ------------ Delete Slot ------------ ");

                    System.out.print("Enter centre ID");
                    int centreId = sc.nextInt();

                    System.out.print("Enter slot ID");
                    int slotId = sc.nextInt();

                    System.out.println("Slot deleted successfully.");
                    break;
                }

                case 5: {
                    System.out.println("Successfully logged out.");
                    return;
                }
            }

        } while (true);

    }
}
