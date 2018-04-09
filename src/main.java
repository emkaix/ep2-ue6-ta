import java.util.ArrayList;

public class main {


    public static void main(String[] args) {
        DataReader dr = new DataReader();
        ArrayList<DataEntry> entries = dr.ReadEntriesFromFile(System.getProperty("user.dir") + "/data/junctions.csv");
    }
}
