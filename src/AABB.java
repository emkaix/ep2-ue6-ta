/**
 * Represents an axis-aligned-bounding-box
 */
public class AABB {
    private Vector2D center;
    private double halfLength;

    public AABB(Vector2D center, double halfLength) {
        this.center = center;
        this.halfLength = halfLength;
    }

    /**
     * Checks whether a given point lies inside this AABB
     * @param point the point which should be checked whether it is inside this AABB
     * @return returns true if the point is inside, false if it is not
     */
    public boolean containsPoint(Vector2D point){
        return point.getX() >= center.getX() - halfLength &&
                point.getX() <= center.getX() + halfLength &&
                point.getY() >= center.getY() - halfLength &&
                point.getY() <= center.getY() + halfLength;
    }

    /**
     * Checks whether a given point lies inside this AABB, and is within a given radius from the center
     * @param point the point which should be checked whether it is inside this AABB
     * @param radius the radius the point should be within
     * @return returns true if the point is inside the AABB and the radius, false otherwise
     */
    public boolean containsPointRadius(Vector2D point, double radius){
        return containsPoint(point) && center.distanceTo(point) <= radius;
    }

    public boolean intersectsAABB(AABB box){
        return !(box.center.getX() - box.halfLength >= this.center.getX() + this.halfLength ||
                box.center.getX() + box.halfLength <= this.center.getX() - this.halfLength ||
                box.center.getY() - box.halfLength >= this.center.getY() + this.halfLength ||
                box.center.getY() + box.halfLength <= this.center.getY() - this.halfLength);
    }

    public Vector2D getCenter() {
        return center;
    }
    public double getHalfLength() {
        return halfLength;
    }
}
