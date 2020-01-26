package com.nilsedgar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    Scanner scanner = new Scanner(System.in);
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<User> users = new ArrayList<>();
    User user;

    public Program() {

        showMainMenu();
    }


    public void showListOfBooks(){
        List<Book> books = (List<Book>) FileUtility.loadObject("books.ser");
        for(Book book: books){
            System.out.println(book.getTitle() + " " + book.getAuthor() + " " + book.getGenre() + "\n");
            if(book.getIsAvailable()){
                System.out.println("This book is available");
            }
            else{
                System.out.println("This book is not available");
            }
        }
    }

    public void borrowBook(){
        List<Book> books = (List<Book>) FileUtility.loadObject("books.ser");
        System.out.println("Enter the title of the book you wish to borrow: ");
        String borrowBook = scanner.nextLine();
        for(Book book : books){
            if(book.getTitle().equals(borrowBook) && book.getIsAvailable() == true){
                user.borrowedBooks.add(book);
                book.setIsAvailable(false);
            }
            else{
                System.out.println("Book cannot be found.");
            }
        }
    }

    public void showMyBorrowedBooks(){
        for(Book book: user.borrowedBooks){
            System.out.println(book.getTitle());
        }
    }

    public void returnBook(){

    }

    public void searchForAuthor(){
        List<Book> books = (List<Book>) FileUtility.loadObject("books.ser");
        System.out.println("Enter name of author: ");
        String bookAuthor = scanner.nextLine();
        for(Book book : books){
            if(book.getAuthor().equals(bookAuthor)){
                System.out.println("This author has written: " + book.getTitle());
            }
            else{
                System.out.println("There is no author by that name");
            }
        }

    }

    public void addNewBook(){
        System.out.printf("Enter title: ");
        String bookTitle = scanner.next();
        System.out.printf("Enter author: ");
        String bookAuthor = scanner.next();
        System.out.print("Enter genre: ");
        String bookGenre = scanner.next();
        books.add(new Book(bookTitle, bookAuthor, bookGenre));
    }

    public void addNewCustomer(){
        System.out.printf("Enter name:");
        String customerName = scanner.next();
        users.add(new User(customerName, "customer123"));
    }

    public void showAllUsers(){
        ArrayList<User> users = (ArrayList<User>) FileUtility.loadObject("users.ser");
        for(User user: users){
            System.out.println(user.getName());
        }
    }

    public void searchForUserName(){
        System.out.printf("Enter name: ");
        String nameSearch = scanner.next();
        for(User user: users){
            if(user.getName().equals(nameSearch)){
                System.out.println("There is a user by that name");
            }
            else{
                System.out.println("Could not find user");
            }
        }
    }

    public void createUserList() {
        users.add(new User("Nils Jacobsen", "admin123"));
        users.add(new User("Karin Lennebo", "admin123"));
        users.add(new User("Hej Hejsson", "customer123"));
        users.add(new User("Adjö Adjösson", "customer123"));
        users.add(new User("Läget Lägetsson", "customer123"));
        users.add(new User("Låna Boksson", "customer123"));

        FileUtility.saveObject("users.ser", users);
    }


    public void createBookList() {

        books.add(new Book("Harry Potter", "JK Rowling", "Fantasy"));
        books.add(new Book("Lord Of The Rings", "J.R.R Tolkien", "Fantasy"));
        books.add(new Book("Moby Dick", "Herman Melville", "Drama"));
        books.add(new Book("Hamlet", "William Shakespeare", "Tragedy"));
        books.add(new Book("Huckleberry Finn", "Mark Twain", "Adventure"));
        books.add(new Book("Pride and Prejudice", "Jane Austen", "Periodical"));
        books.add(new Book("The Iliad", "Homer", "Epic"));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee", "Gothic"));

        FileUtility.saveObject("books.ser", books);
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
                showListOfBooks();
                break;
            case 2:
                borrowBook();
                break;
            case 3:
                searchForAuthor();
                break;
            case 4:
                showMyBorrowedBooks();
                break;
            case 5:
                returnBook();
                break;
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
                addNewBook();
                break;
            case 2:
                addNewCustomer();
                break;
            case 3:
                showAllUsers();
                break;
            case 4:
                searchForUserName();
                break;
            case 5:
                showMainMenu();
                break;
        }
    }
}
