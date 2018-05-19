import java.util.ArrayList;

public class main {


    public static void main(String[] args) {
        //das wird mit jeder anderen datenstruktur als parameter auch funktionieren
        DataReader dr = new DataReader(new SimpleDataCollection());
        IDataCollection dc = dr.ReadEntriesFromFile();

        //zweite beispielanfrage laut angabezettel
        EntryCount counter = dc.inRange(new Vector2D(1818.54657, 5813.29982), 100);
        System.out.println(counter);

        //vierte abfrage leuat angabezettel
        //EntryCount counter2 = dc.TrainstationsNearAirports(15, 20);
        //System.out.println(counter2.printAirports());

        /////////////////////////////////////////// quadtree
        DataReader dr2 = new DataReader(new QuadTree(new AABB(new Vector2D(0, 0), 100000), 1));
        IDataCollection dc2 = dr2.ReadEntriesFromFile();

        //zweite beispielanfrage laut angabezettel
        EntryCount counter2 = dc2.inRange(new Vector2D(1818.54657, 5813.29982), 100);
        System.out.println(counter);


    }


}
