package Vanier;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
     * Testing if it recognizes a usual isbn 13
     */
    @Test
    void isbn13ShouldBeValid() {
        Book testBookVal13 = new Book();
        testBookVal13.setIsbn("978-2-4538-4610-9");
        assertEquals(1, testBookVal13.checkIsbnStatus());
    }

}