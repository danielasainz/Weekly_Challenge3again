package com.Sainz.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        // Created an array list called books that stores multiple "Book" objects
        ArrayList<Book> books = new ArrayList<>();
        Book newBook; //= new Book();
        String answer;
        String bookAnswer;
        //boolean done = false;
        //don't need to assign boolean here - b/c only two values, true or false
        boolean done;
        //keep boolean values consistent **
        //addanother will always be true unless I tell it otherwise
        boolean addanother = true;

        do {
            showMenu();
            System.out.println("Enter a menu number");

            switch (Integer.valueOf(keyboard.nextLine())) {
                case 1:

                    do {
                        // not trying to see into the list, so don't need for (Book eachBook:book)
                        newBook = new Book();
                        System.out.println("Add a book");

                        System.out.println("Enter the book title: ");
                        newBook.setBookTitle(keyboard.nextLine());

                        System.out.println("Enter the book's author: ");
                        newBook.setBookAuthor(keyboard.nextLine());

                        System.out.println("Enter the book's publication year: ");
                        newBook.setPublicationYear(keyboard.nextLine());

                        System.out.println("Enter the book's ISBN number: ");
                        newBook.setIsbnNumber(keyboard.nextLine());

                        System.out.println("Your book information: ");
                        System.out.println("Book title: " + newBook.getBookTitle() + '\n' + "Book author: " + newBook.getBookAuthor()
                                + '\n' + "Book publication year: " + newBook.getPublicationYear() + '\n' + "Book ISBN number: " + newBook.getIsbnNumber()
                                + '\n' + "Is available: " + newBook.isInStock());

                        //need to add the book - I AM ADDING THIS BOOK TO MY LIST OF "books"
                        books.add(newBook);
                        System.out.println('\n' + "Add another book? (Y/N)");
                        bookAnswer = keyboard.nextLine();
                        //you have set the value of addanother to false, so it exits the loop
                        //add another was set to true at the beginning
                        if (bookAnswer.equalsIgnoreCase("no") || bookAnswer.equalsIgnoreCase("n"))
                            addanother = false;
                        //while (addanother) is what keeps the loop running
                    } while (addanother);
                    break;
                case 2:
                    //boolean available = true;

                    // get a list of available books
                    for (Book eachBook : books) {
                        // how do I find out the book is available?
                        //If you set inStock to true. REMEMBER use isInStock instead of getInStock
                        if(eachBook.isInStock()==true) {
                            System.out.println('\n' + "Book title: " + eachBook.getBookTitle() + '\n' + "Book author: " + eachBook.getBookAuthor() +
                                    '\n' + "Publication year: " + eachBook.getPublicationYear() + '\n' + "ISBN Number: " + eachBook.getIsbnNumber()
                                    + '\n' + "Is available: " + eachBook.isInStock());
//                            printMyBook(eachBook);   *This is Diem's code - meant to simplify, ended up confusing me*
                        }
                    }
                    System.out.println("Enter the title of the book you would like to borrow");
                    String borrow = keyboard.nextLine();

                    //set the reference as "eachBook" (Book class "eachBook" : Array List)
                    for (Book eachBook : books) {
                        //Borrow = what the user wants to borrow.
                        //eachBook.getTitle is a book in your list
                        //the ==true is not necessary, Diem included it to make more sense
                        if (borrow.equalsIgnoreCase(eachBook.getBookTitle())==true) {
                            if (eachBook.isInStock()==true) {
                                eachBook.setInStock(false);
                                System.out.println("You have borrowed: " + eachBook.getBookTitle());
                            }
                            else {
                                System.out.println("Sorry that book is checked out!");
                            }
                        }
                        //No need to include
//                        else {
//                            System.out.println("Sorry I can't find a book by that title");
//                        }
                    }

                    break;
                case 3:

                    for (Book eachBook : books) {
                        if (eachBook.isInStock() == false) {
                        System.out.println("Books that are checked out: " + '\n' + "Book title :" + eachBook.getBookTitle());
                        }
                    }
                    System.out.println("Enter the title of the book you would like to return");
                    String returns = keyboard.nextLine();

                    for (Book eachBook : books) {
                        if (returns.equalsIgnoreCase(eachBook.getBookTitle())) {
                            if (eachBook.isInStock() == false) {
                                eachBook.setInStock(true);
                                System.out.println("You have returned: " + eachBook.getBookTitle());
                            }
                            else{
                                System.out.println("Sorry, that book is still available!");
                            }
                        }
                        //No need to include
//                        else{
//                            System.out.println("Sorry I can't find a book by that title");
//
//                            }
                        }
            break;
                case 4:
                    System.out.println("Show everything");
                    System.out.println("------------");
                    System.out.println("*** Books ***");
                    for (Book bk : books) {
                        System.out.println('\n' + "Book title: " + bk.getBookTitle() + '\n' + "Book author: " + bk.getBookAuthor() +
                                '\n' + "Publication year: " + bk.getPublicationYear() + '\n' + "ISBN Number: " + bk.getIsbnNumber()
                                + '\n' + "Is available: " + bk.isInStock());
//                        printMyBook(bk);
                    }
                    break;
            }
            System.out.println('\n' + "Return to main menu? (Y/N)");
            answer = keyboard.nextLine();
            if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
                //If you say "yes," that will fulfill the while condition of }while (done==true); OR }while (done) and rerun the outside loop again
                // else done=false, and you exit the loop
                done = true;
            } else {
                done = false;
            }
            // or } while (done)
        } while (done==true);
    }

    public static void showMenu() {
        System.out.println("Please consider the following menu options:");
        System.out.println("1. Add a book");
        System.out.println("2. Borrow a book");
        System.out.println("3. Return a book");
        System.out.println("4. Show books in the library");
    }

//    public static void printMyBook(Book book) {
//        System.out.println('\n' + "Book title: " + book.getBookTitle() + '\n' + "Book author: " + book.getBookAuthor() +
//                '\n' + "Publication year: " + book.getPublicationYear() + '\n' + "ISBN Number: " + book.getIsbnNumber()
//                + '\n' + "Is available: " + book.isInStock());
//    }
}

