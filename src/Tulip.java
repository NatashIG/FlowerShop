public class Tulip extends Flower {
    private String origin;

    public Tulip(String flowerType, String flowerColour, double price, String origin) {
        super("tulip", flowerType, flowerColour, price);
        this.origin = origin;
    }

    @Override
    public String toString() {
        return "Tulip(" + flowerType + "," + flowerColour + "," + price + "," + origin + ")";
    }
}
