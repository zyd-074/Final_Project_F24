package Vanier;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Yu Duo Zhang
 */

class LibraryTest {

    /**
     * Test if the Books could be searched properly
     */
    @Test
    void testSearchBook() {
        ArrayList<Book> testList = new ArrayList<>();
        Book book1 = new Book("Apology", "Plato", 5.00, "broadview press", "978-1-55481-258-5");
        Book book2 = new Book("The Shape Of Things", "Neil Labute", 15.00, "Broadway Play Publishing", "978-0-88145-222-8");
        testList.add(book1);
        testList.add(book2);
        Library testLib = new Library(testList);
        ArrayList<Book> expectedList1 = new ArrayList<>();
        expectedList1.add(book2);
        ArrayList<Book> expectedList2 = new ArrayList<>();
        expectedList2.add(book1);
        assertEquals(expectedList1 ,testLib.searchBook("shape"));
        assertEquals(expectedList2 ,testLib.searchBook("plato"));
    }

    /**
     * Test if the equal method works properly, result should be true
     */
    @Test
    void testEquals() {
        ArrayList<Book> testList = new ArrayList<>();
        Book book1 = new Book("Apology", "Plato", 5.00, "broadview press", "978-1-55481-258-5");
        Book book2 = new Book("The Shape Of Things", "Neil Labute", 15.00, "Broadway Play Publishing", "978-0-88145-222-8");
        testList.add(book1);
        testList.add(book2);
        Library testLib = new Library(testList);
        Library testLib2 = new Library(testLib);
        assertTrue(testLib.equals(testLib2));
    }

    /**
     * Test the to String method, result should be the same as expected
     */
    @Test
    void testToString() {
        Library testLib = new Library();
        ArrayList<Book> testList = new ArrayList<>();
        Book book1 = new Book("Apology", "Plato", 5.00, "broadview press", "978-1-55481-258-5");
        Book book2 = new Book("The Shape Of Things", "Neil Labute", 15.00, "Broadway Play Publishing", "978-0-88145-222-8");
        testList.add(book1);
        testList.add(book2);
        testLib.setArrayList(testList);
        String expectedString = String.format("%s%d:\n%s\n%s%d:\n%s\n",
                "Book",1, "Title     : Apology\nAuthor    : Plato\nPrice     : 5.00\nPublisher : broadview press\nISBN      : 978-1-55481-258-5",
                "Book",2, "Title     : The Shape Of Things\nAuthor    : Neil Labute\nPrice     : 15.00\nPublisher : Broadway Play Publishing\nISBN      : 978-0-88145-222-8");
        assertEquals(expectedString, testLib.toString());
    }

    /**
     * Test the Getter by expecting the same String as what it should get
     */
    @Test
    void testGetArraylist() {
        Library testLib = new Library();
        Book book1 = new Book("Apology", "Plato", 5.00, "broadview press", "978-1-55481-258-5");
        Book book2 = new Book("The Shape Of Things", "Neil Labute", 15.00, "Broadway Play Publishing", "978-0-88145-222-8");
        testLib.getArraylist().clear();
        testLib.getArraylist().add(book1);
        testLib.getArraylist().add(book2);
        String expectedString = String.format("%s%d:\n%s\n%s%d:\n%s\n",
                "Book",1, "Title     : Apology\nAuthor    : Plato\nPrice     : 5.00\nPublisher : broadview press\nISBN      : 978-1-55481-258-5",
                "Book",2, "Title     : The Shape Of Things\nAuthor    : Neil Labute\nPrice     : 15.00\nPublisher : Broadway Play Publishing\nISBN      : 978-0-88145-222-8");
        assertEquals(expectedString, testLib.toString());
    }

    //Setter tested in searchBook Method and testToString method
}