public interface IDataCollection {
    void add(DataEntry entry);
    EntryCount inRange(Vector2D location, double radius);
    EntryCount TrainstationsNearAirports(double r, int n);
}
