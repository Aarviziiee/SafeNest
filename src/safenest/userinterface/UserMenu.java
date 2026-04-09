package safenest.userinterface;

import safenest.service.AlertManagement;

import java.util.Scanner;

public abstract class UserMenu {

    Scanner scanner = new Scanner(System.in);

    AlertManagement alertManager;

    UserMenu(AlertManagement alertManager){

        this.alertManager = alertManager;
    }

    abstract void displayActions();

}
