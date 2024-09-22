package flipfit.flipkart.business;

import flipfit.flipkart.bean.FlipFitSlots;
import flipfit.flipkart.DAO.FlipFitSlotDAOImpl;

public class FlipFitSlotsBusiness {

    public boolean updateAvailability(FlipFitSlots flipFitSlots) {
        System.out.println("Updating Slot Availability");
        FlipFitSlotDAOImpl flipFitSlotDAO = new FlipFitSlotDAOImpl();
        flipFitSlotDAO.changeSlot(flipFitSlots);
        return true;
    }

    public void getSlotDetails() {
        System.out.println("Getting Slot Details");
        FlipFitSlotDAOImpl flipFitSlotDAO = new FlipFitSlotDAOImpl();

    }

}
