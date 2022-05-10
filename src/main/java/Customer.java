import java.util.Enumeration;
import java.util.Vector;

class Customer {
    private String name;
    private Vector rentals = new Vector();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.addElement(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        Enumeration enum_rentals = rentals.elements();
        String result = "Rental Record for " + this.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (enum_rentals.hasMoreElements()) {
            Rental each = (Rental) enum_rentals.nextElement();
            //show figures for this rental
            result += "\t" + each.getMovie().getName() + "\t" + "\t" + each.getDaysRented() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }
        //add footer lines
        result += "Amount owed is " + getTotalCharge() + "\n";
        result += "You earned " + getTotalFrequentRenterPoints() + " frequent renter points";
        return result;
    }

    private double getTotalCharge() {
        double result = 0;
        Enumeration eRentals = rentals.elements();
        while (eRentals.hasMoreElements()) {
            Rental each = (Rental) eRentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration eRentals = rentals.elements();
        while (eRentals.hasMoreElements()) {
            Rental each = (Rental) eRentals.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }

    public String htmlStatement() {
        Enumeration eRentals = rentals.elements();
        String result = "<H1>Rentals for <EM>" + getName() + "</EM></ H1><P>\n";
        while (eRentals.hasMoreElements()) {
            Rental each = (Rental) eRentals.nextElement();
            //show figures for each rental
            result += each.getMovie().getName() + ": " +
                    each.getCharge() + "<BR>\n";
        }
        //add footer lines
        result += "<P>You owe <EM>" + getTotalCharge() +
                "</EM><P>\n";
        result += "On this rental you earned <EM>" +
                getTotalFrequentRenterPoints() +
                "</EM> frequent renter points<P>";
        return result;
    }
}

    