package flipfit.flipkart.business;

public class GymOwnerBusiness {
    public String getOwnerDetails(){
        return "Get Owner Details";
    }

    public boolean viewAllSlots(int id) {
        System.out.println("view All Slots");
        return true;
    }

    public boolean isApprovedGymOwner(int id) {
        System.out.println("is Approved Gym Owner");
        return true;
    }

    public boolean isApprovedGymCenter() {
        System.out.println("is Approved Gym Center");
        return true;
    }

    public void addSlots() {
        System.out.println("Add slots");
    }

    public boolean addGym(int id) {
        System.out.println("Add gym");
        return true;
    }

    public boolean createSlot(int id) {
        System.out.println("Create slot");
        return true;
    }

}
