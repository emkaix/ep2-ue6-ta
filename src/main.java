import java.util.ArrayList;

public class main {


    public static void main(String[] args) {
        //////// Simple /////////
        System.out.println("\nSimple:");
        DataReader dr_simple = new DataReader(new SimpleDataCollection());
        IDataCollection dc_simple = dr_simple.ReadEntriesFromFile();

        //Junctions less than 575.0 units from x=0.0 y=0.0
        EntryCount counter_simple = dc_simple.inRange(new Vector2D(0, 0), 575.0);
        System.out.println(counter_simple);

        //Junctions less than 100.0 units from x=1818.54657 y=5813.29982
        counter_simple = dc_simple.inRange(new Vector2D(1818.54657, 5813.29982), 100);
        System.out.println(counter_simple);

        //Airports with at least 5 Trainstations less than 1.0 units away
//        counter_simple = dc_simple.TrainstationsNearAirports(1, 5);
//        System.out.println(counter_simple.printAirports());

        //Airports with at least 20 Trainstations less than 15.0 units away
//        counter_simple = dc_simple.TrainstationsNearAirports(15, 20);
//        System.out.println(counter_simple.printAirports());



        //////////// Quadtree ///////////////////
        System.out.println("\nQuadTree:");
        DataReader dr_quad = new DataReader(new QuadTree(new AABB(new Vector2D(0, 0), 50000), 1));
        IDataCollection dc_quad = dr_quad.ReadEntriesFromFile();

        //Junctions less than 575.0 units from x=0.0 y=0.0
        EntryCount counter_quad = dc_quad.inRange(new Vector2D(0, 0), 575);
        System.out.println(counter_quad);

        //Junctions less than 100.0 units from x=1818.54657 y=5813.29982
        counter_quad = dc_quad.inRange(new Vector2D(1818.54657, 5813.29982), 100);
        System.out.println(counter_quad);

        //Airports with at least 5 Trainstations less than 1.0 units away
        counter_quad = dc_quad.TrainstationsNearAirports(1, 5);
        System.out.println(counter_quad.printAirports());

        //Airports with at least 20 Trainstations less than 15.0 units away
        counter_quad = dc_quad.TrainstationsNearAirports(15, 20);
        System.out.println(counter_quad.printAirports());

        //test
//        DataReader dr_quad2 = new DataReader(new QuadTree(new AABB(new Vector2D(0, 0), 50000), 1));
//        IDataCollection dc_quad2 = dr_quad2.ReadEntriesFromFile();
//        QuadTree tree = (QuadTree)dc_quad2;
//        EntryCount test2 = tree.test(15, 20, ((SimpleDataCollection)dc_simple).list );
//        System.out.println(test2);



        //Testing for Quadtree
//        DataReader drr = new DataReader(new Quadtree());
//        IDataCollection dcc = drr.ReadEntriesFromFile();
//        IDataCollection a = dcc;

    }


}
