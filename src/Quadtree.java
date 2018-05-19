public class Quadtree implements IDataCollection{
    private Node root;

    public void add(DataEntry entry) {
        root = add(root, entry);
    }

    private Node add(Node node, DataEntry entry) {
        double x = entry.getVec().getX();
        double y = entry.getVec().getY();

        if (node == null) return new Node(entry);

        else if ( x<node.getX() &&  y< node.getY()) node.setSW(add(node.getSW(),entry));
        else if ( x<node.getX() &&  y> node.getY()) node.setNW(add(node.getNW(),entry));
        else if ( x>node.getX() &&  y< node.getY()) node.setSE(add(node.getSE(),entry));
        else if ( x>node.getX() &&  y> node.getY()) node.setNE(add(node.getNE(),entry));
        return node;
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
