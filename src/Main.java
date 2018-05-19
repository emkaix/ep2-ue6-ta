public class Main {
    //global variables
    public static final String PATH = System.getProperty("user.dir") + "/data/junctions.csv";
    public static final int QUADTREE_CAPACITY = 4;
    public static final int QUADTREE_HALFLENGTH = 50000;


    public static void main(String[] args) {
        //////// Simple /////////
        long startTime = System.nanoTime();

        System.out.println("\n----------[ SimpleDataCollection ]----------");
        DataReader dataReaderSimple = new DataReader(new SimpleDataCollection());
        IDataCollection dataCollectionSimple = dataReaderSimple.ReadEntriesFromFile();

        System.out.println("Junctions less than 575.0 units from x=0.0 y=0.0");
        EntryCount counterSimple = dataCollectionSimple.inRange(new Vector2D(0, 0), 575.0);
        System.out.println(counterSimple);

        System.out.println("Junctions less than 100.0 units from x=1818.54657 y=5813.29982");
        counterSimple = dataCollectionSimple.inRange(new Vector2D(1818.54657, 5813.29982), 100);
        System.out.println(counterSimple);

        System.out.println("Airports with at least 5 Trainstations less than 1.0 units away");
        counterSimple = dataCollectionSimple.TrainstationsNearAirports(1, 5);
        System.out.println(counterSimple.printAirports());

        System.out.println("Airports with at least 20 Trainstations less than 15.0 units away");
        counterSimple = dataCollectionSimple.TrainstationsNearAirports(15, 20);
        System.out.println(counterSimple.printAirports());

        long estimatedTime = System.nanoTime() - startTime;
        System.out.println(String.format("----------[ SimpleDataCollection took %d ms to calculate ]----------", estimatedTime/1000000));

        //////////// Quadtree ///////////////////
        startTime = System.nanoTime();

        System.out.println("\n----------[ QuadTree ]----------");
        DataReader dataReaderQuadTree = new DataReader(QuadTree.getROOT());
        IDataCollection dataCollectioQuadTree = dataReaderQuadTree.ReadEntriesFromFile();

        System.out.println("Junctions less than 575.0 units from x=0.0 y=0.0");
        EntryCount counterQuadTree = dataCollectioQuadTree.inRange(new Vector2D(0, 0), 575);
        System.out.println(counterQuadTree);

        System.out.println("Junctions less than 100.0 units from x=1818.54657 y=5813.29982");
        counterQuadTree = dataCollectioQuadTree.inRange(new Vector2D(1818.54657, 5813.29982), 100);
        System.out.println(counterQuadTree);

        System.out.println("Airports with at least 5 Trainstations less than 1.0 units away");
        counterQuadTree = dataCollectioQuadTree.TrainstationsNearAirports(1, 5);
        System.out.println(counterQuadTree.printAirports());

        System.out.println("Airports with at least 20 Trainstations less than 15.0 units away");
        counterQuadTree = dataCollectioQuadTree.TrainstationsNearAirports(15, 20);
        System.out.println(counterQuadTree.printAirports());

        estimatedTime = System.nanoTime() - startTime;
        System.out.println(String.format("----------[ QuadTree took %d ms to calculate ]----------", estimatedTime/1000000));
    }
}
