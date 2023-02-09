import static java.lang.Math.abs;

public class Apartment {

    private int rooms;
    private int squares;
    private int pricePerSquare;

    public Apartment(int rooms, int squares, int pricePerSquare) {
        this.rooms = rooms;
        this.squares = squares;
        this.pricePerSquare = pricePerSquare;
    }

    public boolean largerThan(Apartment compared) {
        // returns true if apartment has a larger total area than compared apartment
        if (this.squares > compared.squares) {
            return true;
        }
        return false;
    }

    public int priceDifference(Apartment compared) {
        int thisPrice = this.pricePerSquare * squares;
        int compPrice = compared.pricePerSquare * compared.squares;
        int difference = abs(thisPrice - compPrice);
        return difference;
    }

    public boolean moreExpensiveThan(Apartment compared) {
        // returns true if apartment is more expensive than compared apartment
        int thisPrice = this.pricePerSquare * squares;
        int compPrice = compared.pricePerSquare * compared.squares;
        if (thisPrice > compPrice) {
            return true;
        }
        return false;
    }

}
