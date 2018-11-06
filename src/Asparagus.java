public class Asparagus extends Flower {
    String state;

    public Asparagus(String flowerType, String flowerColour, double price, String state) {
        super("asparagus", flowerType, flowerColour, price);
        this.state = state;
    }

    @Override
    public String toString() {
        return "Asparagus(" + flowerType + "," + flowerColour + "," + price + "," + state + ")";
    }
}
