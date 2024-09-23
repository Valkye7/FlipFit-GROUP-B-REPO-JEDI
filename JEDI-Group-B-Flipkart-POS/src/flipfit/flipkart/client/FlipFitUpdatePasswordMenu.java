package flipfit.flipkart.client;

import flipfit.flipkart.business.FlipFitUpdatePasswordBusiness;

import java.util.Scanner;

public class FlipFitUpdatePasswordMenu {

    private FlipFitUpdatePasswordBusiness updatePasswordBusiness;

    public FlipFitUpdatePasswordMenu() {
        this.updatePasswordBusiness = new FlipFitUpdatePasswordBusiness();
    }


    public void showUpdatePasswordMenu(String email) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n---- FlipFit Password Update Menu ----");
            System.out.println("1. Update Password");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    updatePasswordBusiness.updatePassword(email);
                    break;
                case 2:
                    System.out.println("Exiting Password Update Menu...");
                    break;
                default:
                    System.out.println("Invalid choice! Please select again.");
            }
        } while (choice != 2);
    }
}
