import java.security.InvalidParameterException;

/**
 * Represents a datapoint from the csv file
 */
public class DataEntry {
    private String name;
    private double x;
    private double y;
    private Enumerations.LocationType type;

    
    public DataEntry(String name, double lat, double lon, Enumerations.LocationType type){
        if (name == null) throw new InvalidParameterException();
        this.name = name;
        this.x = lat;
        this.y = lon;
        this.type = type;
    }


    //Getter-Methods


    public String getName() {
        return name;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Enumerations.LocationType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "" + getName() + ":" + type;
    }
}

