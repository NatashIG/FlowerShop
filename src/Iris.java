public class Iris extends Flower {
    String length;

    public Iris(String flowerType, String flowerColour, double price, String length) {
        super("iris", flowerType, flowerColour, price);
        this.length = length;
    }

    @Override
    public String toString() {
        return "Iris(" + flowerType + "," + flowerColour + "," + price + "," + length + ")";
    }
}
