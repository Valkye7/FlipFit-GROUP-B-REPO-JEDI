package flipfit.flipkart.business;

import flipfit.flipkart.DAO.FlipFitAdminDAOImpl;
import flipfit.flipkart.bean.*;

import java.util.List;

public class FlipFitAdminBusiness {
    private final FlipFitAdminDAOImpl flipFitAdminDAOImpl;

    public FlipFitAdminBusiness(FlipFitAdminDAOImpl FFAdmin) {
        this.flipFitAdminDAOImpl = FFAdmin;
    }

    //admin login

    public boolean adminLogin(FlipFitAdmin flipFitAdmin) {
        return flipFitAdminDAOImpl.adminLogin(flipFitAdmin);
    }

    //get pending owner list

    public List<FlipFitGymOwner> getPendingOwnerList() {
        return flipFitAdminDAOImpl.getPendingOwnerList();
    }

    //approved owner list

    public List<FlipFitGymOwner> getApprovedOwnerList() {
        return flipFitAdminDAOImpl.getApprovedOwnerList();
    }

    //get user list

    public List<FlipFitCustomer> getUserList() {
        return flipFitAdminDAOImpl.getUserList();
    }

    //validate gym owner

    public boolean validateOwner(int ownerId) {
        return flipFitAdminDAOImpl.validateOwner(ownerId);
    }

    //delete owner

    public boolean deleteOwner(int ownerId) {
        flipFitAdminDAOImpl.deleteOwner(ownerId);
        return true;
    }

    //get center details

    public List<FlipFitGymCentre> getGymCentreUsingOwnerId(int ownerId) {
        return flipFitAdminDAOImpl.getGymCentreUsingOwnerId(ownerId);
    }
}
