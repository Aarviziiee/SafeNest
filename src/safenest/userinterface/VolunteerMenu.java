package safenest.userinterface;

import safenest.model.Alert;
import safenest.service.AlertManagement;

import java.util.InputMismatchException;

public class VolunteerMenu extends UserMenu implements MenuConstraints{


    // constructor
    public VolunteerMenu(AlertManagement alertManager) {
        super(alertManager);
    }


    // to display volunteer a  menu of tasks under their authority
    public void displayActions(){

        System.out.println("Enter your choice: ");
        System.out.println("1. View all Alerts");
        System.out.println("2. Filter Alerts By Location");
        System.out.println("3. Update Alert Status");
        System.out.println("4. Filter Alerts By Status");
        System.out.println("5. Exit");

    }

    // method: to display all alerts if any were received else return a message
    public void displayAllAlerts(){

        System.out.println("All Alerts:");
        Alert [] alertList = alertManager.displayAllAlerts();

        if(alertList[0] == null){
            System.out.println("No alerts received.");
        } else {
            for (int i = 0; i < alertList.length - 1; i++ ){
                if(alertList[i] == null){
                    break;
                } else
                    System.out.println(alertList[i]);
            }
        }
    }


    // method: to filter alerts through location
    public void filterByLocation(){

        System.out.println("Enter Location: ");
        String alertLocation = scanner.nextLine();

        alertManager.filterByLocation(alertLocation);


    }

    // method: take updated status input and update the status
    public void updateStatus(){

        System.out.println("Enter Alert ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();


        System.out.println("What's the status: ");
        System.out.println("1. Alert in Process");
        System.out.println("2. Alert Processed Successfully");
        System.out.println("3. Failed to process the Alert");
        System.out.println("4. Quit");
        int choice = scanner.nextInt();
        scanner.nextLine();
        String status = null;

        switch(choice){

            case 1:

                status = "In Process";
                break;

            case 2:

                status = "Successful";
                break;

            case 3:

                status = "Failed";
                break;

            case 4:
                System.out.println("Redirecting to status Menu...");
                break;

            default:
                System.out.println("Please select a valid option.");
        }


        boolean updateStatus = alertManager.updateStatus(id, status);

        if(updateStatus){
            System.out.println("Alert status has been updated!");
        } else {
            System.out.println("Failed to update the status.");
        }
    }


    // method: to filter alerts through status n return a list of them
    public void filterAlertByStatus(){

        System.out.println("Enter the status you want to filter through: ");
        System.out.println("1. Alert in Process");
        System.out.println("2. Alert Processed Successfully");
        System.out.println("3. Failed to process the Alert");
        System.out.println("4. Quit");
        int choice = scanner.nextInt();
        String status = null;

        switch(choice){

            case 1:

                status = "In Process";
                break;

            case 2:

                status = "Successful";
                break;

            case 3:

                status = "Failed";
                break;

            case 4:
                System.out.println("Redirecting to status Menu...");
                break;

            default:
                System.out.println("Please select a valid option.");
        }

        alertManager.filterByStatus(status);
    }

// method: to handle invalid exception to prevent breaking program flow and call methods according to users input
    public void showMenu(){

        int volunteerChoice = 0;

        do{

            displayActions();

            try{
                volunteerChoice = scanner.nextInt();
            } catch(InputMismatchException e){

                System.out.println("Invalid Choice. Input needs to be a number from the menu.");
                scanner.nextLine();
            }
            scanner.nextLine();

            switch (volunteerChoice){

                case 1:
                    displayAllAlerts();
                    break;

                case 2:
                    filterByLocation();
                    break;

                case 3:
                    updateStatus();
                    break;

                case 4:
                    filterAlertByStatus();
                    break;

                case 5:

                    System.out.println("Redirecting to Main Menu...");
                    break;

                default:
                    System.out.println("Invalid Choice. Please select an option from the menu itself.");
            }

        }while(volunteerChoice != 5);
    }


}
