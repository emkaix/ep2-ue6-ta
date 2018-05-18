public class AABB {
    private Vector2D center;
    double halfLength;

    public AABB(Vector2D center, double halfLength) {
        this.center = center;
        this.halfLength = halfLength;
    }

    public boolean containsPoint(Vector2D point){
        return point.getX() >= center.getX() - halfLength &&
                point.getX() <= center.getX() + halfLength &&
                point.getY() >= center.getY() - halfLength &&
                point.getY() <= center.getY() + halfLength;
    }
}
