public class EntryCount {
    private int TrainstationCount = 0;
    private int AirportCount = 0;

    public int getTrainstationCount() {
        return TrainstationCount;
    }
    public int getAirportCount() {
        return AirportCount;
    }

    public void incTrainstationCount() {
        TrainstationCount++;
    }
    public void incAirportCount() {
        AirportCount++;
    }

    public void resetTrainstationCount() {
        TrainstationCount = 0;
    }
    public void resetAirportCount() {
        AirportCount = 0;
    }

    @Override
    public String toString() {
        return String.format("Airports: %d\tTrainstations: %d", AirportCount, TrainstationCount);
    }

    public String printTrainstations() {
        return String.format("Trainstations: %d", TrainstationCount);
    }

    public String printAirports() {
        return String.format("Airports: %d", AirportCount);
    }
}