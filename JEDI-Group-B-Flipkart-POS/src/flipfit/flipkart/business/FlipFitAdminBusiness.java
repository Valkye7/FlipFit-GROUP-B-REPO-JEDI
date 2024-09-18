package flipfit.flipkart.business;

public class FlipFitAdminBusiness {

    public void adminLogin(){
        System.out.println("Login");
    }
    public void validateOwner(){
        System.out.println("Validating owner");
    }

    public void deleteOwner(){
        System.out.println("Deleting owner");
    }
    public void getPendingOwnerList(){
        System.out.println("Viewing pending owner List");
    }

    public void getApprovedOwnerList(){
        System.out.println("Viewing pending owner List");
    }

    public void getCustomerList(){
        System.out.println("Viewing FlipFit Customer List");
    }
    public void getGymCentreByOwnerId(int ownerId){
        System.out.println("Viewing FlipFit Gym Centre of OwnerID " + ownerId);
    }




}
