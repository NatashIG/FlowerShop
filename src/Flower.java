import java.io.Serializable;

public class Flower implements Serializable {
    String flowerName;
    String flowerType;
    String flowerColour;
    double price;

    public Flower() {
    }

    public Flower(String flowerName, String flowersType, String flowersColour, double price) {
        this.flowerName = flowerName;
        this.flowerType = flowersType;
        this.flowerColour = flowersColour;
        this.price = price;
    }

    public String getFlowerName() {
        return flowerName;
    }

    public void setFlowerName(String flowerName) {
        this.flowerName = flowerName;
    }

    public String getFlowerType() {
        return flowerType;
    }

    public void setFlowerType(String flowerType) {
        this.flowerType = flowerType;
    }

    public String getFlowerColour() {
        return flowerColour;
    }

    public void setFlowerColour(String flowersColour) {
        this.flowerColour = flowersColour;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Flower(" + flowerType + "," + flowerColour + "," + price + ")";
    }
}
