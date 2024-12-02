package Vanier;

/**
 * @author Yu Duo Zhang
 */

public class Book {
    //Data field
    private String title;
    private String author;
    private double price;
    private String publisher;
    private String isbn;

    //Default Constructor
    public Book() {}
    //Constructor with title
    public Book(String title) {
        this.title = title;
    }
    public Book(String title, String author, double price, String publisher, String isbn) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.publisher = publisher;
        this.isbn = isbn;
    }
    //Copy Constructor
    public Book(Book copyBook){
        this.title = copyBook.title;
        this.author = copyBook.author;
        this.price = copyBook.price;
        this.publisher = copyBook.publisher;
        this.isbn = copyBook.isbn;
    }

    //Check ISBN Status
    public int checkIsbnStatus() {
        int isbnLength = this.isbn.length();
        switch (isbnLength){
            case 13:
                return 0;
            case 17:
                return 1;
            default:
                return -1;
        }
    }

    //To Title Case
    public String toTitleCase() {}

    //To String
    public String toString() {}

    //Equals
    public boolean equals(){}

    //Clone
    public Book clones(){}

    //Getters
    public String getTitle(){
        return this.title;
    }
    public String getAuthor(){
        return this.author;
    }
    public double getPrice(){
        return this.price;
    }
    public String getPublisher() {
        return this.publisher;
    }
    public String getIsbn(){
        return this.isbn;
    }

    //Setters
    public void setTitle(String title){
        this.title = title;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public void setPublisher(String publisher){
        this.publisher = publisher;
    }
    public void setIsbn(String isbn){
        this.isbn = isbn;
    }
}
