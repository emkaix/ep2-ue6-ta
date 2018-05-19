/**
 * This interface provides methods for interacting with the different data structures used in this project
 */
public interface IDataCollection {
    /**
     * Inserts an entry into the data structure
     *
     * @param entry
     */
    void add(DataEntry entry);

    /**
     * Retrieves the datapoints which are in a specific radius of a given point
     *
     * @param location the location where nearby datapoints are yet to be found
     * @param radius   the maximum distance from the given location where a datapoint should be within
     * @return an EntryCount object which holds the amount of datapoints found for given parameter values
     */
    EntryCount inRange(Vector2D location, double radius);

    /**
     * Returns the amount of airports of which a given minimal number of trainstations are nearby in a given radius
     *
     * @param r the radius of which the trainstations should be inside of
     * @param n the minimal amount of trainstations an airport should be nearby of
     * @return an EntryCount object which holds the amount of datapoints found for given parameter values
     */
    EntryCount TrainstationsNearAirports(double r, int n);
}
