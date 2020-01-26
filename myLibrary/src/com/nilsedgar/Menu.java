package com.nilsedgar;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);
    Program program = new Program();

    public Menu() {

    }

    public void showMainMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean active = true;
        System.out.println("Welcome to the Library");
        System.out.println("1. Login as Admin");
        System.out.println("2. Login as Customer");
        System.out.println("3. Exit");
        int selection = scanner.nextInt();

        while (active) {
            switch (selection) {
                case 1:
                    loginAsAdmin();
                    break;
                case 2:
                    showCustomerMenu();
                    break;
                case 3:
                    active = false;
                    break;
            }
        }
    }

    private void showCustomerMenu() {
        System.out.println("1. Show list of all books");
        System.out.println("2. Borrow a book");
        System.out.println("3. Search authors");
        System.out.println("4. Show my borrowed books");
        System.out.println("5. Return books");
        System.out.println("6. Return to main menu");
        int select = scanner.nextInt();
        switch (select) {
            case 1:
                program.showListOfBooks();
                break;
            case 2:
                program.borrowBook();
                break;
            case 3:
                program.searchForAuthor();
            case 4:
                program.showMyBorrowedBooks();
            case 5:
                program.returnBook();
            case 6:
                showMainMenu();
                break;
        }

    }

    private void loginAsAdmin() {
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String pass = scanner.nextLine();

        ArrayList<User> users = (ArrayList<User>) FileUtility.loadObject("users.ser");

        for (User user : users) {
            if (user.getName().equals(username) && user.getPassword().equals(pass)){
                showAdminMenu();
                break;
            }
        }

    }

    private void showAdminMenu() {
        System.out.println("1. Add new book");
        System.out.println("2. Add new customer");
        System.out.println("3. Show all users");
        System.out.println("4. Search for users");
        System.out.println("5. Return to main menu");
        int select = scanner.nextInt();
        switch (select) {
            case 1:
                program.addNewBook();
                break;
            case 2:
                program.addNewCustomer();
                break;
            case 3:
                program.showAllUsers();
                break;
            case 4:
                program.searchForUserName();
                break;
            case 5:
                showMainMenu();
                break;
        }
    }
}
