/**
 * This class provides functionality for counting occurences of trainstations
 * and airports when traversing the data structures
 */
public class EntryCount {
    private int TrainstationCount = 0;
    private int AirportCount = 0;

    /**
     * Returns the sum of the trainstation occurences
     *
     * @return the total amount of trainstations
     */
    public int getTrainstationCount() {
        return TrainstationCount;
    }

    /**
     * Returns the sum of the airport occurences
     *
     * @return the total amount of airports
     */
    public int getAirportCount() {
        return AirportCount;
    }

    /**
     * Increments the counter by one
     */
    public void incTrainstationCount() {
        TrainstationCount++;
    }

    /**
     * Increments the counter by one
     */
    public void incAirportCount() {
        AirportCount++;
    }

    /**
     * Takes the sum of the input parameter and adds the amounts to itself
     *
     * @param counter the EntryCount object which amounts should be added to this one
     */
    public void sum(EntryCount counter) {
        this.AirportCount += counter.AirportCount;
        this.TrainstationCount += counter.TrainstationCount;
    }

    /**
     * Returns a readable representation of the counter
     */
    @Override
    public String toString() {
        return String.format("-> Airports: %d\tTrainstations: %d", AirportCount, TrainstationCount);
    }

    /**
     * Returns a readable representation of the trainstation count
     */
    public String printTrainstations() {
        return String.format("-> Trainstations: %d", TrainstationCount);
    }

    /**
     * Returns a readable representation of the airport count
     */
    public String printAirports() {
        return String.format("-> Airports: %d", AirportCount);
    }
}