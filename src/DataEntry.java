import java.security.InvalidParameterException;

/**
 * Represents a datapoint from the csv file
 */
public class DataEntry {
    private String name;
    private double lat;
    private double lon;
    private Enumerations.LocationType type;

    
    public DataEntry(String name, double lat, double lon, Enumerations.LocationType type){
        if (name == null) throw new InvalidParameterException();
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        this.type = type;
    }


    //Getter-Methods


    public String getName() {
        return name;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public Enumerations.LocationType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "" + getName() + ":" + type;
    }
}

