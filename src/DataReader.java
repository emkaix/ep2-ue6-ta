import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Provides functionality for parsing the csv data
 */
public class DataReader {
    private IDataCollection collection;
    private double maxValue = 0;

    /**
     * Returns the maximum value ever occured in the input data set
     * @return the maximum value
     */
    public double getMaxValue() {
        return maxValue;
    }

    public DataReader(IDataCollection collection) {
        this.collection = collection;
    }

    /**
     * Reads the data from the formatted csv file and parses it into a DataEntry list
     *
     * @return a list of DataEntry objects
     */
    public IDataCollection ReadEntriesFromFile() {
        try (Scanner s = new Scanner(
                new File(Main.PATH), "UTF-8")) {
            while (s.hasNext()) {
                DataEntry entry = GetEntryData(s.nextLine());
                if (entry.getVec().getX() > maxValue || entry.getVec().getY() > maxValue) {
                    maxValue = Math.max(entry.getVec().getX(), entry.getVec().getY());
                }
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
     *
     * @param dataString a single line in the csv file representing a datapoint
     * @return a DataEntry object for given datapoint
     */
    private DataEntry GetEntryData(String dataString) {
        String[] dataPoints = dataString.split(";");
        String name = dataPoints[0];
        double x = Double.parseDouble(dataPoints[1]);
        double y = Double.parseDouble(dataPoints[2]);
        Enumerations.LocationType type = Enumerations.LocationType.valueOf(dataPoints[3]);

        return new DataEntry(name, new Vector2D(x, y), type);
    }
}
