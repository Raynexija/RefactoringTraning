import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;


public class ProgramTest {

    @Test
    public void test(){
        Movie m1 = new Movie("movie1", 1);
        Movie m2 = new Movie("movie2", 2);
        Rental r1 = new Rental(m1, 10);
        Rental r2 = new Rental(m2, 5);
        Customer c1 = new Customer("joe");
        c1.addRental(r1);
        c1.addRental(r2);
        String result = "Rental Record for joe\n" +
                "\tTitle\t\tDays\tAmount\n" +
                "\tmovie1\t\t10\t30.0\n" +
                "\tmovie2\t\t5\t4.5\n" +
                "Amount owed is 34.5\n" +
                "You earned 3 frequent renter points";
        System.out.println(c1.statement() + "\n\n");
        assertEquals(result, c1.statement());
        String httpResult ="<H1>Rentals for <EM>joe</EM></ H1><P>\n" +
                "movie1: 30.0<BR>\n" +
                "movie2: 4.5<BR>\n" +
                "<P>You owe <EM>34.5</EM><P>\n" +
                "On this rental you earned <EM>3</EM> frequent renter points<P>";
        System.out.println(c1.htmlStatement());
        assertEquals(httpResult, c1.htmlStatement());
    }
}
