package flipfit.flipkart.client;
import java.util.Scanner;
public class FlipFitGymAdminMenu {
    public static void getAdminView(){
//        System.out.println("Admin View");
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("===========================");
            System.out.println("        Admin Menu          ");
            System.out.println("===========================");

            System.out.println("""
                        Choose an option:
                         1. View Pending Requests
                         2. View Approved Owners
                         3. View all FlipFit Customers
                         4. View all Centres Using OwnerId
                         5. Logout
                        """);

            choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("=========== View Pending Requests =========== ");

                    System.out.println("---Pending Requests List with respective owner IDs---");

                    System.out.print("Type the ownerId of the owner you wish to approve:> ");
                    int ownerId = sc.nextInt();
                    System.out.println("GymOwner with ID " + ownerId + " approved");

                    break;
                }

                case 2: {
                    System.out.println("=========== View Approved Owners =========== ");

                    System.out.println("---Approved Owners List with respective owner IDs---");

                    break;
                }

                case 3: {
                    System.out.println("=========== View all FlipFit Customers =========== ");

                    System.out.println("---All FlipFit Customers List---");

                    break;
                }

                case 4: {
                    System.out.println("=========== View Centres Using OwnerId =========== ");

                    System.out.print("Type the ownerId of the owner for which you wish to view Centres:> ");
                    Scanner in = new Scanner(System.in);
                    int ownerId = in.nextInt();


                    System.out.println("---Printing All Centres of Owner---");



                    break;
                }

                case 5: {
                    System.out.println("Successfully logged out");
                    return;
                }
            }
        } while (choice != 6);
    }
}

