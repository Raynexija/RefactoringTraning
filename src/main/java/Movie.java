public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private String name;
    private Price price;

    public Movie(String name, Price price) {
        this.name = name;
        setPrice(price);
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price arg) {
        price = arg;
    }

    public String getName() {
        return name;
    }

    public double getCharge(int daysRented) {
        return price.getCharge(daysRented);
    }


    int getFrequentRenterPoints(int daysRented) {
        return price.getFrequentRenterPoints(daysRented);
    }
}