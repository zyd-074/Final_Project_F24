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
    //Constructor with all data
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
        int numOfDash = this.isbn.length() - this.isbn.replaceAll("-","").length();
        switch (isbnLength){
            case 13:
                if (numOfDash == 3 &&
                        this.isbn.charAt(1) == '-' &&
                        this.isbn.charAt(11) == '-' &&
                        this.isbn.charAt(2) != '-' &&
                        this.isbn.charAt(3) != '-'){
                    return 0;
                }
                else {return -1;}
            case 17:
                if (numOfDash == 4 &&
                        this.isbn.startsWith("978") &&
                        this.isbn.charAt(3) == '-' &&
                        this.isbn.charAt(5) == '-' &&
                        this.isbn.charAt(15) == '-' &&
                        this.isbn.charAt(7) != '-'){
                    return 1;
                }
                else {return -1;}
            default:
                return -1;
        }
    }

    //To Title Case
    public Book toTitleCase() {
        int i; //made for the loop
        Book tempBook = this.clones();
        for (i = 1; i < this.title.length(); i++){
            if (this.title.charAt(i) == ' '){
                tempBook.title = tempBook.title.substring(0,i+1) + Character.toUpperCase(this.title.charAt(i+1)) +
                        this.title.substring(i+2);
            }
            else if(i-1 == 0){
                tempBook.title = Character.toUpperCase(this.title.charAt(0)) +
                        this.title.substring(1);
            }
        }
        int j; //made for loop
        for (j = 1; j < this.author.length(); j++){
            if (this.author.charAt(j) == ' '){
                tempBook.author = tempBook.author.substring(0,j+1) + Character.toUpperCase(this.author.charAt(j+1)) +
                        this.author.substring(j+2);
            }
            else if(j-1 == 0){
                tempBook.author = Character.toUpperCase(this.author.charAt(0)) +
                        this.author.substring(1);
            }
        }
        return tempBook;
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
    public Book clones(){
        Book cloneBook = new Book();
        cloneBook.title = this.title;
        cloneBook.author = this.author;
        cloneBook.price = this.price;
        cloneBook.publisher = this.publisher;
        cloneBook.isbn = this.isbn;
        return cloneBook;
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
