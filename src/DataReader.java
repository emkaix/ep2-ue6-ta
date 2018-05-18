import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Provides functionality for parsing the csv data
 */
public class DataReader {
    private Scanner scanner;
    private IDataCollection collection;

    private static final String PATH = System.getProperty("user.dir") + "/data/junctions.csv";

    public DataReader(IDataCollection collection) {
        scanner = new Scanner(System.in);
        this.collection = collection;
    }

    /**
     * Reads the data from the formatted csv file and parses it into a DataEntry list
     * @return a list of DataEntry objects
     */
    public IDataCollection ReadEntriesFromFile() {
        try (Scanner s = new Scanner(
                new File(PATH), "UTF-8")) {
            while(s.hasNext()){
                DataEntry entry = GetEntryData(s.nextLine());
                collection.add(entry);
            }
        } catch (FileNotFoundException e) {
            // junctions.csv not found
            System.exit(1);
        }
        return collection;
    }

    /**
     * Helper method for parsing the formatted csv data
     * @param dataString a single line in the csv file representing a datapoint
     * @return a DataEntry object for given datapoint
     */
    private DataEntry GetEntryData(String dataString){
        String[]dataPoints = dataString.split(";");
        String name = dataPoints[0];
        double x = Double.parseDouble(dataPoints[1]);
        double y = Double.parseDouble(dataPoints[2]);
        Enumerations.LocationType type = Enumerations.LocationType.valueOf(dataPoints[3]);

        return new DataEntry(name, new Vector2D(x, y), type);
    }


}
