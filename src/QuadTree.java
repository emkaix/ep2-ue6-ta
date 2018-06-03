import java.util.ArrayList;

/**
 * A QuadTree which represents the "efficient data structure"
 */
public class QuadTree implements IDataCollection {
    public static QuadTree ROOT = new QuadTree(new AABB(new Vector2D(0, 0), Main.QUADTREE_HALFLENGTH), Main.QUADTREE_CAPACITY);
    private ArrayList<DataEntry> entries;
    private QuadTree upperLeft;
    private QuadTree upperRight;
    private QuadTree lowerLeft;
    private QuadTree lowerRight;
    private AABB boundary;
    private int capacity;
    private boolean divided;

    /**
     * Returns the unique root object of the quadtree
     *
     * @return the root of the tree
     */
    public static QuadTree getROOT() {
        return ROOT;
    }

    public QuadTree(AABB boundary, int capacity) {
        this.entries = new ArrayList<>();
        this.boundary = boundary;
        this.capacity = capacity;
        divided = false;
    }

    /**
     * This method performs a subdivision into 4 new quadrants in case the amount of datapoints within
     * a section exceeds QUADTREE_CAPACITY
     */
    public void subdivide() {
        double x = this.boundary.getCenter().getX();
        double y = this.boundary.getCenter().getY();
        double halfLength = this.boundary.getHalfLength();

        AABB ul = new AABB(new Vector2D(x - halfLength / 2, y + halfLength / 2), halfLength / 2);
        upperLeft = new QuadTree(ul, 1);
        AABB ur = new AABB(new Vector2D(x + halfLength / 2, y + halfLength / 2), halfLength / 2);
        upperRight = new QuadTree(ur, 1);
        AABB ll = new AABB(new Vector2D(x - halfLength / 2, y - halfLength / 2), halfLength / 2);
        lowerLeft = new QuadTree(ll, 1);
        AABB lr = new AABB(new Vector2D(x + halfLength / 2, y - halfLength / 2), halfLength / 2);
        lowerRight = new QuadTree(lr, 1);

        divided = true;
    }

    @Override
    public void add(DataEntry entry) {
        if (!boundary.containsPoint(entry.getVec())) return;

        if (entries.size() < capacity) {
            entries.add(entry);
        } else {
            if (!divided)
                subdivide();

            upperLeft.add(entry);
            upperRight.add(entry);
            lowerLeft.add(entry);
            lowerRight.add(entry);
        }
    }

    @Override
    public EntryCount inRange(Vector2D location, double radius) {
        AABB range = new AABB(location, radius);
        return inRangeRec(range, radius);
    }

    /**
     * Helper method for recursive traversal of the tree
     */
    private EntryCount inRangeRec(AABB range, double radius) {
        EntryCount counter = new EntryCount();
        if (!boundary.intersectsAABB(range))
            return counter;

        for (DataEntry e : entries) {
            if (range.containsPointRadius(e.getVec(), radius)) {
                if (e.getType() == Enumerations.LocationType.AIRPORT)
                    counter.incAirportCount();
                else
                    counter.incTrainstationCount();
            }
        }
        if (!divided)
            return counter;

        counter.sum(upperLeft.inRangeRec(range, radius));
        counter.sum(upperRight.inRangeRec(range, radius));
        counter.sum(lowerLeft.inRangeRec(range, radius));
        counter.sum(lowerRight.inRangeRec(range, radius));
        return counter;
    }

    @Override
    public EntryCount TrainstationsNearAirports(double r, int n) {
        EntryCount airportCounter = new EntryCount();
        for (DataEntry e : entries) {
            if (e.getType() != Enumerations.LocationType.AIRPORT) continue;
            EntryCount buffer = ROOT.inRange(e.getVec(), r);
            if (buffer.getTrainstationCount() >= n) airportCounter.incAirportCount();
        }

        if (!divided)
            return airportCounter;

        airportCounter.sum(upperLeft.TrainstationsNearAirports(r, n));
        airportCounter.sum(upperRight.TrainstationsNearAirports(r, n));
        airportCounter.sum(lowerLeft.TrainstationsNearAirports(r, n));
        airportCounter.sum(lowerRight.TrainstationsNearAirports(r, n));
        return airportCounter;
    }

    /**
     * For testing purposes
     *
     * @return
     */
    public ArrayList<DataEntry> toArray() {
        ArrayList<DataEntry> ret = new ArrayList<>();
        for (DataEntry e : entries) {
            ret.add(e);
        }

        if (!divided) return ret;
        ret.addAll(upperLeft.toArray());
        ret.addAll(upperRight.toArray());
        ret.addAll(lowerLeft.toArray());
        ret.addAll(lowerRight.toArray());

        return ret;
    }

    /**
     * Gibt den Namen der Collection zurück
     * @return
     */
    @Override
    public String toString() {
        return "Quadtree";
    }
}
