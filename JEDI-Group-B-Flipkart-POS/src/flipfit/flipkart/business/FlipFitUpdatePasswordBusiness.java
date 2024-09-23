package flipfit.flipkart.business;

import flipfit.flipkart.DAO.FlipFitUpdatePasswordDAOImpl;

import java.util.Scanner;

public class FlipFitUpdatePasswordBusiness {

    private FlipFitUpdatePasswordDAOImpl flipFitUpdatePasswordDAO;

    public FlipFitUpdatePasswordBusiness() {
        flipFitUpdatePasswordDAO = new FlipFitUpdatePasswordDAOImpl();
    }


    public void updatePassword(String email) {
        Scanner sc = new Scanner(System.in);


        System.out.print("Enter your old password: ");
        String oldPassword = sc.nextLine();


        if (flipFitUpdatePasswordDAO.validateOldPassword(email, oldPassword)) {

            System.out.print("Enter your new password: ");
            String newPassword = sc.nextLine();


            if (newPassword == null || newPassword.length() < 6) {
                System.out.println("New password must be at least 6 characters long. ");
            } else {

                boolean isUpdated = flipFitUpdatePasswordDAO.updateUserPassword(email, oldPassword, newPassword);
                if (isUpdated) {
                    System.out.println("Password updated successfully.");
                } else {
                    System.out.println("Failed to update password.");
                }
            }
        } else {

            System.out.println("Incorrect old password. Please try again.");
        }
    }
}
