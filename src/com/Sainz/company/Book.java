package com.Sainz.company;


import java.util.ArrayList;

public class Book {
    private String bookTitle;
    private String bookAuthor;
    private String publicationYear;
    private String isbnNumber;
    private boolean inStock;
    ArrayList<Book> books;

    //isInStock instead of getInStock
    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }


    //loaded constructor
    public Book(String bookTitle, String bookAuthor, String publicationYear, String isbnNumber) {
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.publicationYear = publicationYear;
        this.isbnNumber = isbnNumber;
        books = new ArrayList<>();
    }

    //default constructor
    public Book() {
        books = new ArrayList<>();
        inStock = true;

    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getIsbnNumber() {
        return isbnNumber;
    }

    public void setIsbnNumber(String isbnNumber) {
        this.isbnNumber = isbnNumber;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookTitle='" + bookTitle + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", publicationYear='" + publicationYear + '\'' +
                ", isbnNumber='" + isbnNumber + '\'' +
                ", inStock=" + inStock +
                ", books=" + books +
                '}';
    }
}