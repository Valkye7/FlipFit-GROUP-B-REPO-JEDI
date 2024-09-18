package flipfit.flipkart.bean;

public class FlipFitGymOwner extends FlipFitUser {
    private String PAN;
    private int Aadhaar;
    private String GSTIN;
    public boolean isApproved;


    public String getPAN() {
        return PAN;
    }

    public void setPAN(String PAN) {
        this.PAN = PAN;
    }

    public int getAadhaar() {
        return Aadhaar;
    }

    public void setAadhaar(int aadhaar) {
        Aadhaar = aadhaar;
    }

    public String getGSTIN() {
        return GSTIN;
    }

    public void setGSTIN(String GSTIN) {
        this.GSTIN = GSTIN;
    }
}
