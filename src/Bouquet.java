import exceptions.NotFoundInCollection;
import exceptions.ObjectIsNotInizialized;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Bouquet implements Serializable {

    private List<Flower> bouquet = new ArrayList<Flower>();


    public Bouquet() {
    }

    public void add(Flower flower) throws ObjectIsNotInizialized {
        if (flower == null) {
            throw new ObjectIsNotInizialized("Object is not inizialized!");
        }
        bouquet.add(flower);
    }

    public void remove(Flower flower) throws NotFoundInCollection {
        if (!bouquet.contains(flower)) {
            throw new NotFoundInCollection("Not found in collection!");
        }
        bouquet.remove(flower);
    }

    public double calcPrice() {
        double sum = 0;
        for (Flower flower : bouquet) {
            sum += flower.getPrice();
        }
        return sum;
    }

    @Override
    public String toString() {
        return "Bouquet: " + bouquet;
    }
}




















