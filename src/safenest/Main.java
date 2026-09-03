package safenest;

import safenest.exceptions.InvalidAlertException;
import safenest.userinterface.SenderMenu;
import safenest.userinterface.VolunteerMenu;
import safenest.service.AlertManagement;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

     static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        AlertManagement alertManager = new AlertManagement(100);

        SenderMenu sender = new SenderMenu(alertManager);
        VolunteerMenu volunteer = new VolunteerMenu(alertManager);

        int userChoice = 0;

        do{

            System.out.println("Welcome to SafeNest!");
            System.out.println("Select your role: ");
            System.out.println("1. Sender");
            System.out.println("2. Volunteer");
            System.out.println("3. Exit");

            try{
                userChoice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid Choice. Input needs to be a number from the menu.");
                scanner.nextLine();
            }

            switch (userChoice){

                case 1:

                    sender.showMenu();
                    break;

                case 2:

                    volunteer.showMenu();
                    break;

                case 3:

                    System.out.println("Exiting SafeNest...");
                    break;

                default:
                    System.out.println("Invalid Choice. Enter a valid choice.");
            }

        }while(userChoice != 3);


    }
}
