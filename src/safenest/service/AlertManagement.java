package safenest.service;

import safenest.model.Alert;

public class AlertManagement {

    private Alert[] alert;
    private int alertCount = 0;

    public AlertManagement(int size) {
        alert = new Alert[size];
    }

    public boolean addAlert(String description, String location) {

        if (alertCount < alert.length) {
            int newId = alertCount + 1;
            alert[alertCount++] = new Alert(newId, description, location);
            return true;
        }
        return false;
    }

    public Alert[] displayAllAlerts() {

        return alert;
    }

    public void filterByLocation(String location) {

        StringBuilder locationList = new StringBuilder();
        for (int i = 0; i < alertCount; i++) {
            if (alert[i].getAlertLocation().contains(location)) {
                locationList.append("\n" + alert[i]);
            }
        }

        if(locationList.isEmpty()){
            System.out.println("No matches found.");
        } else
            System.out.println(locationList);
    }

    private boolean updateStatus(int id,String status, int i){

        if( i >= alertCount ){
            return false;
        }
        if(alert[i].getAlertId() == id){
            alert[i].setAlertStatus(status);
            return true;
        }
        if( alert[i].getAlertId() != id)
            return updateStatus(id, status, i + 1);

        return false;
    }

    public boolean updateStatus(int id, String status) {

        boolean update = updateStatus(id,status,0);
        return update;
    }

    public void filterByStatus(String status){

        for(int i = 0; i < alertCount - 1; i++){
            for(int j = 0; j < alertCount - i - 1; j++){

                if(alert[j].getAlertId() > alert[j+1].getAlertId()){
                    Alert temp = alert[j];
                    alert[j] = alert[j+1];
                    alert[j+1] = temp;
                }
            }
        }

        StringBuilder filteredAlerts = new StringBuilder();
        for(int i = 0; i < alertCount; i++){
            if(alert[i].getAlertStatus().contains(status)){
                filteredAlerts.append("\n" +  alert[i]);
            }
        }

        if(filteredAlerts.isEmpty()){
            System.out.println("No matches found");
        }
        else{
            System.out.println(filteredAlerts);
        }
    }
}

