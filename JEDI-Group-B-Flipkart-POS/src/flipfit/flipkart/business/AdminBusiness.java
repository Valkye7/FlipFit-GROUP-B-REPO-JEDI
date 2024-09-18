package flipfit.flipkart.business;

import flipfit.flipkart.bean.Admin;
import flipfit.flipkart.DAO.AdminDAO;
import flipfit.flipkart.DAO.CustomerDAO;

public class AdminBusiness {
    private AdminDAO adminDatabase;
    private CustomerDAO custDatabase;

    // Constructor to initialize DAO objects
    public AdminBusiness() {
        this.adminDatabase = new AdminDAO();
        this.custDatabase = new CustomerDAO();
    }


    public void createAdmin(int id, String name, String emailAddress, String password) {
        Admin admin = new Admin();
        admin.setAdminId(id);
        admin.setAdminName(name);
        admin.setAdminEmailAddress(emailAddress);
        admin.setPassword(password);

        adminDatabase.add(admin);
        System.out.println("Admin Details Added");
    }


    public boolean approveGymOwnerRegistration(int id) {
        System.out.println("Approved Gym Owner Registration for ID: " + id);

        return true;
    }


    public String viewPendingGymRequests() {
        System.out.println("View Pending Gym Requests");
        return "List of pending gym requests";
    }


    public boolean approveGymRegistrations(int id) {
        System.out.println("Approve Gym Registrations for ID: " + id);

        return true;
    }


    public void viewAllApprovedGymOwners() {
        System.out.println("View All Approved Gym Owners");

    }
}
