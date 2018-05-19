public class Node {

        private double x,y;
        private DataEntry entry;
        private Node NW, NE, SW, SE;

        public Node(DataEntry entry) {
            this.x = entry.getVec().getX();
            this.y = entry.getVec().getY();
            this.entry = entry;
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }

    public void setNW(Node NW) {
        this.NW = NW;
    }
    public void setNE(Node NE) {
        this.NE = NE;
    }
    public void setSW(Node SW) {
        this.SW = SW;
    }
    public void setSE(Node SE) {
        this.SE = SE;
    }

    public Node getNW() {
        return NW;
    }
    public Node getNE() {
        return NE;
    }
    public Node getSW() {
        return SW;
    }
    public Node getSE() {
        return SE;
    }
}
