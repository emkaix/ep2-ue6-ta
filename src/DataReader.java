import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataReader {
    private Scanner scanner;

    public DataReader() {
        scanner = new Scanner(System.in);
    }

    public ArrayList<DataEntry> ReadEntriesFromFile(String path) {
        ArrayList<DataEntry> entries = new ArrayList<DataEntry>();
        try (Scanner s = new Scanner(
                new File(path), "UTF-8")) {
            while(s.hasNext()){
                DataEntry entry = GetEntryData(s.nextLine());
                entries.add(entry);
            }
        } catch (FileNotFoundException e) {
            // junctions.csv not found
            System.exit(1);
        }
        return entries;
    }

    private DataEntry GetEntryData(String dataString){
        String[]dataPoints = dataString.split(";");
        String name = dataPoints[0];
        double lat = Double.parseDouble(dataPoints[1]);
        double lon = Double.parseDouble(dataPoints[2]);
        Enumerations.LocationType type = Enumerations.LocationType.valueOf(dataPoints[3]);

        return new DataEntry(name, lat, lon, type);
    }


}
