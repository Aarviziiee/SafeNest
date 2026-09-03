package safenest.model;

public class Alert {

    // variables
    private int alertId;
    private String alertDescription;
    private String alertStatus;
    private String alertLocation;

    // constructor
    public Alert(int id, String description, String location){

        this.alertId = id;
        this.alertDescription = description;
        this.alertStatus = "sent";
        this.alertLocation = location;
    }

    // getters to access the variables

    public int getAlertId(){
        return alertId;
    }

    public String getAlertDescription() {
        return alertDescription;
    }

    public String getAlertStatus() {
        return alertStatus;
    }

    // status's value require dynamic updates
    public void setAlertStatus(String alertStatus) {
        this.alertStatus = alertStatus;
    }

    public String getAlertLocation() {
        return alertLocation;
    }

    // Method to display Alert details
    @Override
    public String toString() {
        return  " Alert ID: " + alertId +
                " | Alert Description: " + alertDescription +
                " | Alert Location: " + alertLocation +
                " | Alert Status: " + alertStatus ;
    }
}
