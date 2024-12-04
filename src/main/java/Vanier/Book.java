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
    public Book(String title, String author, double price,
                String publisher, String isbn) {
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
                if (this.isbn.indexOf("-") == 1 &&
                        this.isbn.indexOf("-") == 11 &&
                        this.isbn.indexOf("-") != 3){
                    return 0;
                }
                else {return -1;}
            case 17:
                if (this.isbn.startsWith("978") &&
                        this.isbn.indexOf("-") == 3 &&
                        this.isbn.indexOf("-") == 5 &&
                        this.isbn.indexOf("-") == 15 &&
                        this.isbn.indexOf("-") != 7){
                    return 1;
                }
                else {return -1;}
            default:
                return -1;
        }
    }

    //To Title Case
    public String toTitleCase() {
        int i; //made for the loop
        for (i = 0; i < this.title.length(); i++){
            if (this.title.charAt(i+1) == ' '){
                this.title = Character.toUpperCase(this.title.charAt(i)) +
                        this.title.substring(i+1);
            }
        }
        return this.title;
    }

    //To String
    public String toString() {
        return String.format("%-10s: %s\n%-10s: %s\n%-10s: %.2f\n%-10s: %s\n%-10s: %s",
                "Title", this.title, "Author", this.author, "Price", this.price,
                "Publisher", this.publisher, "ISBN", this.isbn);
    }

    //Equals
    public boolean equals(Book otherBook){
        return this.title.equals(otherBook.title) &&
                this.author.equals(otherBook.author) &&
                this.price == otherBook.price &&
                this.publisher.equals(otherBook.publisher) &&
                this.isbn.equals(otherBook.isbn);
    }

    //Clone
    public Book clones(Book userBook){
        return new Book(userBook);
    }

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
