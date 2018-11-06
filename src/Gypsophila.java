public class Gypsophila extends Flower {
    String state;

    public Gypsophila(String flowerType, String flowerColour, double price, String state) {
        super("gypsophila", flowerType, flowerColour, price);
        this.state = state;
    }

    @Override
    public String toString() {
        return "Gypsophila(" + flowerType + "," + flowerColour + "," + price + "," + state + ")";
    }
}
