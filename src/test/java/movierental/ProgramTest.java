package movierental;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ProgramTest {
    private Customer c1 = new Customer("joe");

    @Before
    public void init() {
        Movie m1 = new Movie("movie1", new NewReleasePrice());
        Movie m2 = new Movie("movie2", new ChildrenPrice());
        Rental r1 = new Rental(m1, 10);
        Rental r2 = new Rental(m2, 5);
        c1.addRental(r1);
        c1.addRental(r2);
    }

    @Test
    public void testASCII() {
        String result = "MovieRental.Rental Record for joe\n" +
                "\tTitle\t\tDays\tAmount\n" +
                "\tmovie1\t\t10\t30.0\n" +
                "\tmovie2\t\t5\t4.5\n" +
                "Amount owed is 34.5\n" +
                "You earned 3 frequent renter points";
        System.out.println(c1.statement() + "\n\n");
        assertEquals(result, c1.statement());
    }

    @Test
    public void testHTML() {
        String htmlResult = "<H1>Rentals for <EM>joe</EM></ H1><P>\n" +
                "movie1: 30.0<BR>\n" +
                "movie2: 4.5<BR>\n" +
                "<P>You owe <EM>34.5</EM><P>\n" +
                "On this rental you earned <EM>3</EM> frequent renter points<P>";
        System.out.println(c1.htmlStatement());
        assertEquals(htmlResult, c1.htmlStatement());
    }
}
