import java.util.ArrayList;

public class main {


    public static void main(String[] args) {
        DataReader dr = new DataReader();
        ArrayList<DataEntry> entries = dr.ReadEntriesFromFile(System.getProperty("user.dir") + "/data/junctions.csv");
        ArrayList<DataEntry> result = InRangeEntries.addInRangeEntrys(entries, entries.get(0).getX(), entries.get(0).getY(),300);
        System.out.println(result.toString());
        System.out.println(InRangeEntries.AirportsInTrainstationRange(entries, 10, 30 ));


    }


}
