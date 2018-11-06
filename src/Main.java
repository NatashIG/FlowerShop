import exceptions.NotFoundInCollection;
import exceptions.ObjectIsNotInizialized;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {

    public static void main(String[] args) throws SQLException {

        Bouquet bouquet = new Bouquet();

        Rose rose = new Rose("gardenFlower", "red", 5, "classic");
        Rose rose1 = new Rose("gardenFlower", "rose", 5, "classic");
        Rose rose2 = new Rose("gardenFlower", "white", 7, "shrubRose");

        Tulip tulip = new Tulip("gardenFlower", "yellow", 3, "NL");
        Tulip tulip1 = new Tulip("gardenFlower", "white", 2, "BY");

        Chamomile chamomile = new Chamomile("wildFlower", "white", 0.75, "small");
        Chamomile chamomile1 = new Chamomile("gardenFlower", "white", 1, "big");

        Asparagus asparagus = new Asparagus("gardenPlant", "green", 0.45, "adultPlant");
        Asparagus asparagus1 = new Asparagus("gardenPlant", "green", 1.35, "shoot");

        Aster aster = new Aster("gardenFlower", "white", 0.9, "classic");
        Aster aster1 = new Aster("gardenFlower", "violet", 1.25, "needle");
        Aster aster2 = new Aster("gardenFlower", "lilac", 1.15, "terry");

        Iris iris = new Iris("gardenFlower", "yellow", 1.5, "long");
        Iris iris1 = new Iris("wildFlower", "multicolour", 1.5, "small");

        Gypsophila gypsophila = new Gypsophila("gardenPlant", "green", 0.8, "fresh");
        Gypsophila gypsophila1 = new Gypsophila("gardenPlant", "green", 0.6, "dry");

        File fXmlFile = new File("Flowers.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;

        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();

            if (doc.hasChildNodes()) {
                ReadXMLFile.printNodes(doc.getChildNodes());
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        DBConnection dbconnection = new DBConnection();

        String query = "select * from Flowers";

        try {
            Statement statement = dbconnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                rose.setFlowerName(resultSet.getString(2));
                rose.setFlowerType(resultSet.getString(3));
                rose.setFlowerColour(resultSet.getString(4));
                rose.setPrice(resultSet.getInt(5));
                System.out.println("This flower is added from DB : " + rose);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            FileOutputStream filestream = new FileOutputStream("FlowerShop.ser");

            ObjectOutputStream os = new ObjectOutputStream(filestream);

            os.writeObject(rose);
            os.writeObject(rose1);
            os.writeObject(rose2);
            os.writeObject(tulip);
            os.writeObject(tulip1);
            os.writeObject(chamomile);
            os.writeObject(chamomile1);
            os.writeObject(asparagus);
            os.writeObject(asparagus1);
            os.writeObject(aster);
            os.writeObject(aster1);
            os.writeObject(aster2);
            os.writeObject(iris);
            os.writeObject(iris1);
            os.writeObject(gypsophila);
            os.writeObject(gypsophila1);
            os.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {
            FileInputStream filestream = new FileInputStream("FlowerShop.ser");

            ObjectInputStream os = new ObjectInputStream(filestream);

            Rose roseRestore = (Rose) os.readObject();
            Rose rose1Restore = (Rose) os.readObject();
            Rose rose2Restore = (Rose) os.readObject();
            Tulip tulipRestore = (Tulip) os.readObject();
            Tulip tulip1Restore = (Tulip) os.readObject();
            Chamomile chamomileRestore = (Chamomile) os.readObject();
            Chamomile chamomile1Restore = (Chamomile) os.readObject();
            Asparagus asparagusRestore = (Asparagus) os.readObject();
            Asparagus asparagus1Restore = (Asparagus) os.readObject();
            Aster asterRestore = (Aster) os.readObject();
            Aster aster1Restore = (Aster) os.readObject();
            Aster aster2Restore = (Aster) os.readObject();
            Iris irisRestore = (Iris) os.readObject();
            Iris iris1Restore = (Iris) os.readObject();
            Gypsophila gypsophilaRestore = (Gypsophila) os.readObject();
            Gypsophila gypsophila1Restore = (Gypsophila) os.readObject();

            System.out.println("These flowers have been written to/read from file using O/I Streams:");
            System.out.println(roseRestore);
            System.out.println(rose1Restore);
            System.out.println(rose2Restore);
            System.out.println(tulipRestore);
            System.out.println(tulip1Restore);
            System.out.println(chamomileRestore);
            System.out.println(chamomile1Restore);
            System.out.println(asparagusRestore);
            System.out.println(asparagus1Restore);
            System.out.println(asterRestore);
            System.out.println(aster1Restore);
            System.out.println(aster2Restore);
            System.out.println(irisRestore);
            System.out.println(iris1Restore);
            System.out.println(gypsophilaRestore);
            System.out.println(gypsophila1Restore);
            os.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // rose=null;   //uncomment this string to check ObjectIsNotInizialized exception handling
        try {
            bouquet.add(rose);
            bouquet.add(rose);
            bouquet.add(rose1);
            bouquet.add(rose2);
            bouquet.add(rose2);

        } catch (ObjectIsNotInizialized oni) {
            //System.out.println ("Exception: " + oni);
            oni.printStackTrace();
        }

        try {
            bouquet.remove(tulip);
        } catch (NotFoundInCollection nfc) {
            //System.out.println ("Exception: " + nfc);
            nfc.printStackTrace();
        }

        System.out.println(bouquet);

        System.out.println("Total amount: " + bouquet.calcPrice());
    }
}






