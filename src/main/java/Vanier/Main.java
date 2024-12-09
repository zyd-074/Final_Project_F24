package Vanier;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)throws IOException {
        Library mainLib = new Library();    //Create Library
        mainLib.getArraylist().clear();     //Clear Arraylist for next step
        Scanner txtFile = new Scanner(new File("Books.txt"));   //Scan The initial book list
        //Initial Params
        String title;
        String author;
        double price;
        String publisher;
        String isbn;

        ArrayList<Book> mainBooks = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
//Not magic number,
//this is just to initialize the Arraylist with the 5 books in "Books.txt" As Example
            title = txtFile.nextLine();
            author = txtFile.nextLine();
            price = Double.parseDouble(txtFile.nextLine());
            publisher = txtFile.nextLine();
            isbn = txtFile.nextLine();
            mainBooks.add(new Book(title, author, price, publisher, isbn));
        }
        mainLib.setArrayList(mainBooks);

        Scanner user = new Scanner(System.in);
        System.out.println("Library Service\n1. Search for a Book\n2. Add a book\n3. Remove a book\n4. Modify a book\n5. Book list summary\nPress 0 to quit program");
        int choice = user.nextInt();
        user.nextLine();
        while (choice != 0 && choice <= 5) {
            switch (choice) {
                case 1:
                    System.out.print("Search bar:");
                    String searchBar = user.nextLine();
                    Library result = new Library(mainLib.searchBook(searchBar));
                    System.out.println(result.toString());
                    break;
                case 2:
                    Book newBook = new Book();
                    System.out.println("What is the title of the Book?");
                    newBook.setTitle(user.nextLine());
                    System.out.println("Who is the author of the Book?");
                    newBook.setAuthor(user.nextLine());
                    System.out.println("How much is the price of the Book?");
                    newBook.setPrice(user.nextDouble());
                    user.nextLine();
                    System.out.println("What the publisher of the Book?");
                    newBook.setPublisher(user.nextLine());
                    System.out.println("What is the ISBN of the Book?");
                    newBook.setIsbn(user.nextLine());
                    while(newBook.checkIsbnStatus() == -1){
                        System.out.println("Your ISBN is invalid, please verify and try again");
                        newBook.setIsbn(user.nextLine());
                    }
                    System.out.println("A new book has been created: " + newBook.toTitleCase().toString() + "\n");
                    mainBooks.add(newBook.toTitleCase());
                    break;
            }
            System.out.println("Anything else?\n1. Search for a Book\n2. Add a book\n3. Remove a book\n4. Modify a book\n5. Book list summary\nPress 0 to quit program");
            choice = user.nextInt();
            user.nextLine();
        }
    }
}