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
                    System.out.print(result);
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
                    System.out.println("A new book has been created: \n" + newBook.toTitleCase().toString() + "\n");
                    mainLib.getArraylist().add(newBook.toTitleCase());
                    break;
                case 3:
                    System.out.println("Current book list:\n");
                    System.out.print(mainLib);
                    System.out.println("Which book would you like to remove?");
                    int removeChoice = (user.nextInt());
                    user.nextLine();
                    mainLib.getArraylist().remove((removeChoice - 1));
                    System.out.println("Book " + removeChoice + " has been removed");
                    break;
                case 4:
                    System.out.println("Current book list:\n");
                    System.out.print(mainLib);
                    System.out.println("Which book would you like to update?");
                    int updateChoice = (user.nextInt());
                    user.nextLine();
                    System.out.println("Which information would you like to update?");
                    String infoUpdate = user.nextLine().toLowerCase();
                    switch (infoUpdate) {
                        case "title":
                            System.out.println("What is the new title of the Book?");
                            String newTitle = user.nextLine();
                            Book updateTitle = new Book(mainLib.getArraylist().get(updateChoice - 1));
                            updateTitle.setTitle(newTitle);
                            mainLib.getArraylist().set((updateChoice - 1), updateTitle.toTitleCase());
                            System.out.println("Title updated successfully");
                            break;
                        case "author":
                            System.out.println("What is the new author of the Book?");
                            String newAuthor = user.nextLine();
                            Book updateAuthor = new Book(mainLib.getArraylist().get(updateChoice - 1));
                            updateAuthor.setAuthor(newAuthor);
                            mainLib.getArraylist().set((updateChoice - 1), updateAuthor.toTitleCase());
                            System.out.println("Author updated successfully");
                            break;
                        case "price":
                            System.out.println("What is the new price of the Book?");
                            double newPrice = user.nextDouble();
                            user.nextLine();
                            Book updatePrice = new Book(mainLib.getArraylist().get(updateChoice - 1));
                            updatePrice.setPrice(newPrice);
                            mainLib.getArraylist().set((updateChoice - 1), updatePrice.toTitleCase());
                            System.out.println("Price updated successfully");
                            break;
                        case "publisher":
                            System.out.println("What is the new publisher of the Book?");
                            String newPublisher = user.nextLine();
                            Book updatePublisher = new Book(mainLib.getArraylist().get(updateChoice - 1));
                            updatePublisher.setPublisher(newPublisher);
                            mainLib.getArraylist().set((updateChoice - 1), updatePublisher.toTitleCase());
                            System.out.println("Publisher updated successfully");
                            break;
                        case "isbn":
                            System.out.println("What is the new isbn of the Book?");
                            String newIsbn = user.nextLine();
                            Book updateIsbn = new Book(mainLib.getArraylist().get(updateChoice - 1));
                            updateIsbn.setIsbn(newIsbn);
                            mainLib.getArraylist().set((updateChoice - 1), updateIsbn.toTitleCase());
                            System.out.println("Isbn updated successfully");
                            break;
                        default:
                            break;
                    }
                    break;
                case 5:
                    System.out.println("Current book list:\n");
                    System.out.print(mainLib);
                    break;
                default:
                    break;
            }
            System.out.println("Anything else?\n1. Search for a Book\n2. Add a book\n3. Remove a book\n4. Modify a book\n5. Book list summary\nPress 0 to quit program");
            choice = user.nextInt();
            user.nextLine();
        }
    }
}