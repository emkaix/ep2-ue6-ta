import java.security.InvalidParameterException;

/**
 * Represents a datapoint from the csv file
 */
public class DataEntry {
    private String name;
    private Vector2D vec;
    private Enumerations.LocationType type;

    /**
     * Returns the name of this datapoint
     *
     * @return the name of this datapoint
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the type of this datapoint, whether it's an airport or trainstation (as specified in the LocationType enum)
     *
     * @return the type of this datapoint
     */
    public Enumerations.LocationType getType() {
        return type;
    }

    /**
     * Returns the location represented by a 2D Vector
     *
     * @return the location of this datapoint
     */
    public Vector2D getVec() {
        return vec;
    }

    public DataEntry(String name, Vector2D vec, Enumerations.LocationType type) {
        if (name == null) throw new InvalidParameterException();
        this.vec = vec;
        this.name = name;
        this.type = type;
    }

    /**
     * Returns a readable representation of this datapoint
     */
    @Override
    public String toString() {
        return "" + getName() + ":" + type;
    }
}

