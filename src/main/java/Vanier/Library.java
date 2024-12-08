package Vanier;
import java.util.ArrayList;

/**
 * @author Yu Duo Zhang
 */

public class Library {
    private ArrayList<Book> books = new ArrayList<Book>();

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
    public Library(ArrayList<Book> books) {
        this.books = books;
    }
    public Library(Library otherLibrary) {
        this.books = otherLibrary.books;
    }
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
    public boolean equals(ArrayList<Book> otherBooks) {
        return this.books.equals(otherBooks);
    }
    public String toString() {
        String output = "";
        for (int i = 0; i < this.books.size(); i++) {
            String temp = String.format("%s%d:\n%s", "Book",(i+1), this.books.get(i).toString());
            output += temp;
        }
        return output;
    }
    //Getter
    public ArrayList<Book> getArraylist() {
        return this.books;
    }
    //Setter
    public ArrayList<Book> setArrayList(ArrayList<Book> otherBooks) {
        ArrayList<Book> newList = this.books;
        newList.clear();
        newList.addAll(otherBooks);
        return newList;
    }
}
