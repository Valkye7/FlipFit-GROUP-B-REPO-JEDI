package flipfit.flipkart.business;

import java.util.*;

public class CustomerBusiness {


    public void bookSlot(String gym) {
        Map<String, List<String>> gymMap = createGymSlotMap();

        List<String> availableSlots = gymMap.get(gym);
        if (availableSlots == null || availableSlots.isEmpty()) {
            System.out.println("No available slots for " + gym);
            return;
        }

        displayAvailableSlots(gym, availableSlots);

        Scanner in = new Scanner(System.in);
        System.out.println("Choose slot option (enter the number): ");
        int option = in.nextInt();

        if (option > 0 && option <= availableSlots.size()) {
            String bookedSlot = availableSlots.get(option - 1);
            availableSlots.remove(bookedSlot);
            System.out.println("Slot booked successfully: " + bookedSlot);
        } else {
            System.out.println("Invalid option selected.");
        }
    }


    public void searchGym(String location) {
        Map<String, String> gymMap = createGymLocationMap();

        String selectedGym = gymMap.get(location);
        if (selectedGym != null) {
            System.out.println("Gym Found: " + selectedGym);
            bookSlot(selectedGym);
        } else {
            System.out.println("No gym found at the specified location.");
        }
    }


    public String getCustomerDetails() {
        return "Customer details retrieved";
    }


    public boolean viewAllGymCenters(int id) {
        System.out.println("View All Gym Centers for Customer ID: " + id);
        return true;
    }



    public void cancelSlot() {

        System.out.println("Slot Cancelled");
    }


    public void viewAllBookings() {
        System.out.println("View All Bookings");
    }


    private Map<String, List<String>> createGymSlotMap() {
        Map<String, List<String>> gymMap = new HashMap<>();
        gymMap.put("Gym1", new ArrayList<>(Arrays.asList("10:00 AM", "2:00 PM", "5:00 PM")));
        gymMap.put("Gym2", new ArrayList<>(Arrays.asList("9:00 AM", "1:00 PM", "4:00 PM")));
        return gymMap;
    }

    private Map<String, String> createGymLocationMap() {
        Map<String, String> gymMap = new HashMap<>();
        gymMap.put("Location1", "Gym1");
        gymMap.put("Location2", "Gym2");
        return gymMap;
    }

    private void displayAvailableSlots(String gym, List<String> slots) {
        System.out.println("Available slots at " + gym + ":");
        int option = 1;
        for (String slot : slots) {
            System.out.println("Option " + option + ": " + slot);
            option++;
        }
    }


}
