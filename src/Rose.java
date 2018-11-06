public class Rose extends Flower {
    private String roseType;

    public Rose(String flowerType, String flowerColour, double price, String roseType) {
        super("rose", flowerType, flowerColour, price);
        this.roseType = roseType;
    }

    @Override
    public String toString() {
        return "Rose(" + flowerType + "," + flowerColour + "," + price + "," + roseType + ")";
    }
}



