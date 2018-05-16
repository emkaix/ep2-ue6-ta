import java.util.ArrayList;

public class main {


    public static void main(String[] args) {
        DataReader dr = new DataReader();
        ArrayList<DataEntry> entries = dr.ReadEntriesFromFile(System.getProperty("user.dir") + "/data/junctions.csv");
        ArrayList<DataEntry> result = InRangeEntries.addDataEntryIfInRange(entries, entries.get(0).getLat(), entries.get(0).getLon(),100);
        System.out.println(result.toString());

    }


}
