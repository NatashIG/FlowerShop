public class Chamomile extends Flower {
    String size;

    public Chamomile(String flowerType, String flowerColour, double price, String size) {
        super("chamomile", flowerType, flowerColour, price);
        this.size = size;
    }

    @Override
    public String toString() {
        return "Chamomile(" + flowerType + "," + flowerColour + "," + price + "," + size + ")";
    }
}
