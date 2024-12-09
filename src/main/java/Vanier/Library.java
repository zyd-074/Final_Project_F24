package Vanier;
import java.util.ArrayList;

/**
 * @author Yu Duo Zhang
 */

public class Library {
    private ArrayList<Book> books = new ArrayList<Book>();

    /**
     * Default Constructor with 5 blank Books
     * <p>Note: The 5 different books are added in Main file</p>
     */
    public Library() {
        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();
        Book book4 = new Book();
        Book book5 = new Book();
        this.books.add(book1);
        this.books.add(book2);
        this.books.add(book3);
        this.books.add(book4);
        this.books.add(book5);
    }

    /**
     * Constructor with Arraylist
     * @param books Arraylist to use
     */
    public Library(ArrayList<Book> books) {
        this.books = books;
    }

    /**
     * Copy constructor
     * @param otherLibrary The Library to copy from
     */
    public Library(Library otherLibrary) {
        this.books = otherLibrary.books;
    }

    /**
     * searchBook method
     * @param keyword The keyword to find in Title or Author
     * @return An Arraylist with only the Books that contains the keywords
     */
    public ArrayList<Book> searchBook(String keyword) {
        int i;
        ArrayList<Book> withKeyword = new ArrayList<Book>();
        for (i = 0; i < this.books.size(); i++) {
            if (this.books.get(i).getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                withKeyword.add(this.books.get(i));
            }
            if (this.books.get(i).getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                withKeyword.add(this.books.get(i));
            }
        }
        return withKeyword;
    }

    /**
     * equals method
     * @param otherLib The Library to compare with
     * @return True if they are equal, false if they aren't
     */
    public boolean equals(Library otherLib) {
        return this.books.equals(otherLib.books);
    }

    /**
     * toString method
     * @return A String that contains all the Books in the Library
     */
    public String toString() {
        String output = "";
        for (int i = 0; i < this.books.size(); i++) {
            String temp = String.format("%s %d:\n%s\n\n", "Book",i+1, this.books.get(i).toString());
            output += temp;
        }
        return output;
    }

    /**
     * Getter
     * @return The Arraylist that this Library has
     */
    public ArrayList<Book> getArraylist() {
        return this.books;
    }

    /**
     * Setter
     * @param otherBooks Set the new Arraylist to the Library
     */
    public void setArrayList(ArrayList<Book> otherBooks) {
        ArrayList<Book> newList = this.books;
        newList.clear();
        newList.addAll(otherBooks);
    }
}
