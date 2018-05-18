import java.util.ArrayList;

public class SimpleDataCollection implements IDataCollection{
    private ArrayList<DataEntry> list;
    
    public SimpleDataCollection(){
        list = new ArrayList<>();
    }
    
    public void add(DataEntry entry){
        list.add(entry);
    }
    
    public EntryCount inRange(Vector2D location, double radius){
        EntryCount counter = new EntryCount();
        for (DataEntry e: list) {
            if (location.distanceTo(e.getVec()) <= radius){
                if (e.getType() == Enumerations.LocationType.AIRPORT)
                    counter.incAirportCount();
                else if (e.getType() == Enumerations.LocationType.TRAINSTATION)
                    counter.incTrainstationCount();
            }
        }
        return counter;
    }

    public EntryCount TrainstationsNearAirports(double r, int n){
        EntryCount airportCounter = new EntryCount();
        for (DataEntry e: list) {
            if (e.getType() != Enumerations.LocationType.AIRPORT) continue;
            EntryCount buffer = inRange(e.getVec(), r);
            if (buffer.getTrainstationCount() >= n) airportCounter.incAirportCount();
        }
        return airportCounter;
    }
}
