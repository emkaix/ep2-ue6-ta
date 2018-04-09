import com.sun.javaws.exceptions.InvalidArgumentException;

import java.security.InvalidParameterException;

/**
 * Represents a datapoint from the csv file
 */
public class DataEntry {
    private String name;
    private double x;
    private double y;
    private Enumerations.LocationType type;

    
    public DataEntry(String name, double x, double y, Enumerations.LocationType type){
        if (name == null) throw new InvalidParameterException();
        this.name = name;
        this.x = x;
        this.y = y;
        this.type = type;
    }
}
