public class Aster extends Flower {

    String petalType;

    public Aster(String flowerType, String flowerColour, double price, String petalType) {
        super("aster", flowerType, flowerColour, price);
        this.petalType = petalType;
    }

    @Override
    public String toString() {
        return "Aster(" + flowerType + "," + flowerColour + "," + price + "," + petalType + ")";
    }
}
