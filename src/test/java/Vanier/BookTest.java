package Vanier;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Yu Duo Zhang
 */

class BookTest {

    /**
     * Testing if it recognizes an isbn with the valid length but wrong format
     */
    @Test
    void isbn10ShouldBeInvalid() {
        Book testBookInv10 = new Book();
        testBookInv10.setIsbn("1-1-1111111-1");
        assertEquals(-1, testBookInv10.checkIsbnStatus());
    }

    /**
     * Testing if it recognizes and isbn without enough dashes (invalid isbn) for ISBN10
     */
    @Test
    void isbn10ShouldBeValidNum2() {
        Book testBookInv10 = new Book();
        testBookInv10.setIsbn("1-111111111-1");
        assertEquals(-1, testBookInv10.checkIsbnStatus());
    }

    /**
     * Testing if it recognizes a usual isbn 10
     */
    @Test
    void isbn10ShouldBeValid(){
        Book testBookVal10 = new Book();
        testBookVal10.setIsbn("1-11-111111-1");
        assertEquals(0, testBookVal10.checkIsbnStatus());
    }

    /**
     * Testing if it recognizes that the isbn 13 started with the wrong 3 numbers
     */
    @Test
    void isbn13ShouldBeInvalid1() {
        Book testBook1Inv13 = new Book();
        testBook1Inv13.setIsbn("987-2-45-384610-9");
        assertEquals(-1, testBook1Inv13.checkIsbnStatus());
    }

    /**
     * Testing if it recognizes an isbn with the right length and right start but wrong format
     */
    @Test
    void isbn13ShouldBeInvalid2() {
        Book testBook2Inv13 = new Book();
        testBook2Inv13.setIsbn("978-2-4-5384610-9");
        assertEquals(-1, testBook2Inv13.checkIsbnStatus());
    }

    /**
     * Testing if it recognizes an isbn 13 without enough dashes (invalid isbn) for ISBN13
     */
    @Test
    void isbn13ShouldBeInvalid3() {
        Book testBook = new Book();
        testBook.setIsbn("978-1-111111111-1");
        assertEquals(-1, testBook.checkIsbnStatus());
    }

    /**
     * Testing if it recognizes a usual isbn 13
     */
    @Test
    void isbn13ShouldBeValid() {
        Book testBookVal13 = new Book();
        testBookVal13.setIsbn("978-2-4538-4610-9");
        assertEquals(1, testBookVal13.checkIsbnStatus());
    }

    /**
     * Testing if it can turn both Title and Author to Title Case
     */
    @Test
    void testToTitleCase() {
        Book testTitleCase = new Book();
        testTitleCase.setAuthor("pierre trembler");
        testTitleCase.setTitle("the book named book");
        Book expectedTitleCase = new Book();
        expectedTitleCase.setAuthor("Pierre Trembler");
        expectedTitleCase.setTitle("The Book Named Book");
        assertEquals(expectedTitleCase.getAuthor(), testTitleCase.toTitleCase().getAuthor());
        assertEquals(expectedTitleCase.getTitle(), testTitleCase.toTitleCase().getTitle());
    }

    /**
     * Testing if the toString method can give all information of the book
     */
    @Test
    void testToString() {
        String expectation = String.format("%-10s: %s\n%-10s: %s\n%-10s: %.2f\n%-10s: %s\n%-10s: %s", "Title", "Name Of The Book", "Author", "Pierre Trembler", "Price", 9.99, "Publisher", "A Random Publisher", "ISBN", "1-1111-1111-1");
        Book testToString = new Book();
        testToString.setAuthor("pierre trembler");
        testToString.setTitle("name of the book");
        testToString.setIsbn("1-1111-1111-1");
        testToString.setPrice(9.99);
        testToString.setPublisher("A Random Publisher");
        assertEquals(expectation, testToString.toTitleCase().toString());
    }

    /**
     * Testing both Equal and Clone methods
     * <p>Since the clone of a book should be the same as the original one.</p>
     */
    @Test
    void testEqualsAndClone() {
        Book testOriginal = new Book("Title","Author",9.99,"Publisher","1-1111-1111-1");
        Book testClone = testOriginal.clones();
        assertTrue(testClone.equals(testOriginal));
    }

    /**
     * Testing the Getters
     */
    @Test
    void testGetters() {
        Book testGetters = new Book("Title","Author",9.99,"Publisher","1-1111-1111-1");
        assertEquals("Title", testGetters.getTitle());
        assertEquals("Author", testGetters.getAuthor());
        assertEquals(9.99, testGetters.getPrice());
        assertEquals("Publisher", testGetters.getPublisher());
        assertEquals("1-1111-1111-1", testGetters.getIsbn());
    }

    //Setters were tested during other tests
}