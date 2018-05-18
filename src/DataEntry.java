import java.security.InvalidParameterException;

/**
 * Represents a datapoint from the csv file
 */
public class DataEntry {
    private String name;

    public Vector2D getVec() {
        return vec;
    }

    private Vector2D vec;
    private Enumerations.LocationType type;
    
    public DataEntry(String name, Vector2D vec, Enumerations.LocationType type){
        if (name == null) throw new InvalidParameterException();
        this.vec = vec;
        this.name = name;
        this.type = type;
    }


    //Getter-Methods
    public String getName() {
        return name;
    }
    public Enumerations.LocationType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "" + getName() + ":" + type;
    }
}

