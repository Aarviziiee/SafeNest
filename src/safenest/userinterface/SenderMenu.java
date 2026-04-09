package safenest.userinterface;

import safenest.exceptions.InvalidAlertException;
import safenest.service.AlertManagement;

import java.util.InputMismatchException;


public class SenderMenu extends UserMenu implements MenuConstraints{


    public SenderMenu(AlertManagement alertManager) {
        super(alertManager);
    }

    public void displayActions(){

        System.out.println("Please select your choice: ");
        System.out.println("1. Add Alert");
        System.out.println("2. Exit");

    }
    public void addAlert() throws InvalidAlertException  {

           System.out.println("Enter Alert Description: ");
           String description = scanner.nextLine();
           if(description.isBlank()){
               throw new InvalidAlertException("Description cannot be blank. Please enter valid input!");
           }

           System.out.println("Enter your current Location: ");
           String location = scanner.nextLine();
           if(location.isBlank()){
               throw new InvalidAlertException("Location cannot be blank. Please enter valid input!");
           }

       boolean alertAdded = alertManager.addAlert(description, location);

       if(alertAdded){
           System.out.println("Alert has successfully been sent. A volunteer will respond soon.");
       } else {
           System.out.println("Couldn't send the alert. Please try again.");
       }

   }

   public void showMenu(){

        int senderChoice = 0;

        do{
            displayActions();
            try{
                senderChoice = scanner.nextInt();
            } catch (InputMismatchException e){

                System.out.println("Invalid Choice. Input needs to be a number from the menu.");
                scanner.nextLine();
            }

            switch (senderChoice){

                case 1:
                    try{
                        addAlert();
                    } catch (InvalidAlertException e){

                        System.out.println("Exception Caught: " + e.getMessage());
                    }
                    break;

                case 2:

                    System.out.println("Redirecting to the Main Menu...");
                    break;

                default:

                    System.out.println("Invalid Choice. Please select an option from the menu itself. ");

            }

        } while(senderChoice != 2);
   }



}


