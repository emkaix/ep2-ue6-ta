import java.util.ArrayList;

public class QuadTree implements IDataCollection{
    ArrayList<DataEntry> entries;
    QuadTree upperLeft;
    QuadTree upperRight;
    QuadTree lowerLeft;
    QuadTree lowerRight;
    AABB boundary;
    int capacity;
    boolean divided;

    public QuadTree(AABB boundary, int capacity) {
        this.entries = new ArrayList<>();
        this.boundary = boundary;
        this.capacity = capacity;
        divided = false;
    }

    public void subdivide(){
        double x = this.boundary.getCenter().getX();
        double y = this.boundary.getCenter().getY();
        double halfLength = this.boundary.getHalfLength();

        AABB ul = new AABB(new Vector2D(x - halfLength/2, y + halfLength/2), halfLength/2);
        upperLeft = new QuadTree(ul, 1);
        AABB ur = new AABB(new Vector2D(x + halfLength/2, y + halfLength/2), halfLength/2);
        upperRight = new QuadTree(ur, 1);
        AABB ll = new AABB(new Vector2D(x - halfLength/2, y - halfLength/2), halfLength/2);
        lowerLeft = new QuadTree(ll, 1);
        AABB lr = new AABB(new Vector2D(x + halfLength/2, y - halfLength/2), halfLength/2);
        lowerRight = new QuadTree(lr, 1);

        divided = true;
    }

    @Override
    public void add(DataEntry entry){
        if (!boundary.containsPoint(entry.getVec())) return;

        if (entries.size() < capacity){
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
        return null;
    }

    @Override
    public EntryCount TrainstationsNearAirports(double r, int n) {
        return null;
    }
}