package flipfit.flipkart.DAO;

import flipfit.flipkart.bean.FlipFitGymCentre;
import flipfit.flipkart.bean.FlipFitGymOwner;
import flipfit.flipkart.bean.FlipFitRole;

import java.util.List;

public class FlipFitGymOwnerDAOImpl {
    public List<FlipFitGymCentre> viewCentresByOwnerID(FlipFitGymOwner flipFitGymOwner) {
        return List.of();
    }

    public FlipFitGymOwner editDetails(FlipFitGymOwner owner) {
        return owner;
    }

    public FlipFitRole addUser(FlipFitRole user) {
        return user;
    }

    public FlipFitGymOwner addGymOwner(FlipFitGymOwner gymOwner, FlipFitRole user) {
        return gymOwner;
    }

    public FlipFitGymCentre addCentre(FlipFitGymCentre flipFitGymCentre) {
        return flipFitGymCentre;
    }
}
