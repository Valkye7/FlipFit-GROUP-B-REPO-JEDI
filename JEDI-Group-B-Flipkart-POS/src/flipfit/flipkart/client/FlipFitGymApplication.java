package flipfit.flipkart.client;

import java.util.Scanner;

import static flipfit.flipkart.client.FlipFitGymAdminMenu.getAdminView;
import static flipfit.flipkart.client.FlipFitGymCustomerMenu.getFlipFitCustomerMenu;
import static flipfit.flipkart.client.FlipFitGymOwnerMenu.getFlipFitGymOwnerView;

public class FlipFitGymApplication {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true){
            System.out.println(" ");
            System.out.println("------------------------------------------------");
            System.out.println("------ Welcome To FlipFit Gym Application ------");
            System.out.println("------------------------------------------------");
            System.out.println(" ");
            System.out.println("1 -> Login");
            System.out.println("2 -> Registration of Customer");
            System.out.println("3 -> Registration of Gym Owner");
            System.out.println("4 -> Update Password");
            System.out.println("5 -> Exit");
            int decision = in.nextInt();
            switch (decision) {
                case 1: {
                    System.out.println("Welcome To FlipFit");
                    System.out.println("Enter your emailId:> ");
                    String username = in.next();
                    System.out.println("Enter your password:> ");
                    String password = in.next();
                    System.out.println("Enter your role :-> Customer/Admin/GymOwner ");
                    String role = in.next();
                    switch (role) {
                        case "Customer": {
                            if (username != null && password != null) {
                                System.out.println("------  Customer Menu --------");
                                getFlipFitCustomerMenu();
                                break;
                            }
                        }
                        case "GymOwner": {
                            if (username != null && password != null) {
                                System.out.println("------  Gym Owner Menu --------");
                                getFlipFitGymOwnerView();
                                break;
                            }
                        }
                        case "Admin": {
                            if (username != null && password != null) {
                                System.out.println("------  Admin Menu --------");
                                getAdminView();
                                break;
                            }
                        }
                        default: {
                            System.out.println("Please enter a Valid Role");
                        }
                    }
                    break;
                }
                case 2: {
                    System.out.println("--------- Registration of Gym Customer ---------");
                    System.out.print("Enter your email address:");
                    String emailID = in.next();

                    System.out.println("Enter your phone number:> ");
                    String phoneNumber = in.next();

                    System.out.println("Enter your city");
                    String city = in.next();

                    System.out.println("Enter your pin code");
                    String pinCode = in.next();

                    System.out.println("Enter your password");
                    String password = in.next();

                    System.out.println("Enter username");
                    String username = in.next();

                    System.out.println("Registration completed for " + username);
                    System.out.println("-------- Customer Menu --------");
                    getFlipFitCustomerMenu();
                    break;
                }
                case 3: {
                    System.out.println("--------- Registration of Gym Owner ---------");
                    System.out.println("Enter your email address");
                    String emailID = in.next();

                    System.out.println("Enter your phone number");
                    String phoneNumber = in.next();

                    System.out.println("Enter your city");
                    String city = in.next();

                    System.out.println("Enter your pin code");
                    String pinCode = in.next();

                    System.out.println("Enter your password");
                    String password = in.next();

                    System.out.println("Enter username");
                    String username = in.next();

                    System.out.println("Enter your panId");
                    String panId = in.next();

                    System.out.println("Enter your gstNum:");
                    String gstNum = in.next();

                    System.out.println("Enter your aadharNumber");
                    String aadharNumber = in.next();

                    System.out.println("Successfully registered " + username);

                    System.out.println("------  Gym Owner Menu --------");
                    getFlipFitGymOwnerView();
                    break;
                }
                case 4: {
                    int maxRetry = 3;
                    int currentRetry = 0;
                    while (currentRetry != maxRetry) {
                        System.out.println("--------- Update Password ---------");
                        System.out.print("Enter your role :-> Customer/GymOwner ");
                        String role = in.next();
                        System.out.println("Enter your Username");
                        String username = in.next();
                        System.out.print("Enter your old password:");
                        String oldPassword = in.next();
                        if (oldPassword != null) {
                            System.out.print("Enter your new password:");
                            String newPassword = in.next();
                            System.out.print("Your password has been updated");
                            switch (role) {
                                case "Customer": {
                                    System.out.println("------  Customer Menu --------");
                                    getFlipFitCustomerMenu();
                                    break;
                                }
                                case "GymOwner": {
                                    System.out.println("------  Gym Owner Menu --------");
                                    getFlipFitGymOwnerView();
                                    break;
                                }
                            }
                            break;
                        } else {
                            System.out.print("Invalid Old Password, Please try again");
                            currentRetry++;
                        }
                    }
                    if (currentRetry == maxRetry) {
                        System.out.println("-------- Please try again later after some time --------");
                    }
                    break;
                }
                case 5: {
                    System.out.println("-------- EXIT --------");
                    return;
                }
                default: {
                    System.out.println("-------- Invalid choice entered: --------");
                    break;
                }
            }
        }
    }
}
