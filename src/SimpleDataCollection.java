import java.util.ArrayList;

/**
 * Represents a data collection which is utilizing a simple ArrayList as data structure
 */
public class SimpleDataCollection implements IDataCollection {
    public ArrayList<DataEntry> list;

    public SimpleDataCollection() {
        list = new ArrayList<>();
    }

    public void add(DataEntry entry) {
        list.add(entry);
    }

    public EntryCount inRange(Vector2D location, double radius) {
        EntryCount counter = new EntryCount();
        for (DataEntry e : list) {
            if (location.distanceTo(e.getVec()) <= radius) {
                if (e.getType() == Enumerations.LocationType.AIRPORT)
                    counter.incAirportCount();
                else if (e.getType() == Enumerations.LocationType.TRAINSTATION)
                    counter.incTrainstationCount();
            }
        }
        return counter;
    }

    public EntryCount TrainstationsNearAirports(double r, int n) {
        EntryCount airportCounter = new EntryCount();
        for (DataEntry e : list) {
            if (e.getType() != Enumerations.LocationType.AIRPORT) continue;
            EntryCount buffer = inRange(e.getVec(), r);
            if (buffer.getTrainstationCount() >= n) airportCounter.incAirportCount();
        }
        return airportCounter;
    }

    /**
     * Gibt den Namen der Collection zurück
     * @return
     */
    @Override
    public String toString() {
        return "SimpleDataCollection";
    }
}
