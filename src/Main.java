import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    //global variables
    public static final String PATH = System.getProperty("user.dir") + "/data/junctions.csv";
    public static final int QUADTREE_CAPACITY = 4;
    public static final int QUADTREE_HALFLENGTH = 50000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {

            //Parameter eingeben
            double[] junctionVars = new double[3];
            System.out.println("[Junctions]\nBitte Radius [Enter], X [Enter] und Y [Enter] Koordinate eingeben");
            if (scanner.hasNextDouble()) {
                for (int i = 0; i < junctionVars.length; i++) {
                    junctionVars[i] = scanner.nextDouble();
                }
            }

            //set up data collections
            DataReader dataReaderSimple = new DataReader(new SimpleDataCollection());
            IDataCollection dataCollectionSimple = dataReaderSimple.ReadEntriesFromFile();

            QuadTree.ROOT = new QuadTree(new AABB(new Vector2D(0, 0), dataReaderSimple.getMaxValue() + 10), Main.QUADTREE_CAPACITY);
            DataReader dataReaderQuadTree = new DataReader(QuadTree.getROOT());
            IDataCollection dataCollectionQuadTree = dataReaderQuadTree.ReadEntriesFromFile();

            //calculcate junctions with naive method and quadtree
            System.out.println(String.format("Junctions less than %f units from x=%f y=%f", junctionVars[0], junctionVars[1], junctionVars[2]));
            junctionsCalculate(junctionVars, dataCollectionSimple);
            System.out.println();
            junctionsCalculate(junctionVars, dataCollectionQuadTree);

            //---------------------------------------------------------------

            //Parameter eingeben
            int numTrainstations = 0;
            double radius = 0.0;
            System.out.println("[Airports]\nBitte Anzahl der Bahnhöfe eingeben [Enter] und dann den Radius [Enter]");
            if (scanner.hasNextInt())
                numTrainstations = scanner.nextInt();
            if (scanner.hasNextDouble())
                radius = scanner.nextDouble();

            //calculate airports with naive method and quadtree
            System.out.println(String.format("Airports with at least %d Trainstations less than %f units away", numTrainstations, radius));
            airportNumCalculate(numTrainstations, radius, dataCollectionSimple);
            System.out.println();
            airportNumCalculate(numTrainstations, radius, dataCollectionQuadTree);
        }
    }

    /**
     * Helper method for calculating the junctions with given parameters
     *
     * @param vars       a double array consisting of radius, x and y values
     * @param collection the datacollection object on which the calculation is performed
     */
    private static void junctionsCalculate(double[] vars, IDataCollection collection) {
        String collectionName = collection.toString();
        System.out.println(String.format("----------[ %s Junctions]----------", collectionName));
        long startTime = System.nanoTime();
        EntryCount counter = collection.inRange(new Vector2D(vars[1], vars[2]), vars[0]);
        long endTime = System.nanoTime() - startTime;
        System.out.println(counter);
        System.out.println(String.format("----------[ %s Junctions took %d ms to calculate ]----------", collectionName, endTime / 1000000));
    }

    /**
     * Helper method for calculating the airport count with given parameters
     *
     * @param numTrainstations
     * @param radius
     * @param collection
     */
    private static void airportNumCalculate(int numTrainstations, double radius, IDataCollection collection) {
        String collectionName = collection.toString();
        System.out.println(String.format("----------[ %s Airport Count]----------", collectionName));
        long startTime = System.nanoTime();
        EntryCount counter = collection.TrainstationsNearAirports(radius, numTrainstations);
        long endTime = System.nanoTime() - startTime;
        System.out.println(counter.printAirports());
        System.out.println(String.format("----------[ %s Airport Count took %d ms to calculate ]----------", collectionName, endTime / 1000000));
    }
}
