/**
 * Represents a 2D Vector
 */
public class Vector2D {
    private double X;
    private double Y;

    /**
     * Returns the X coordinate of this vector
     *
     * @return the X coordinate
     */
    public double getX() {
        return X;
    }

    /**
     * Returns the Y coordinate of this vector
     *
     * @return the Y coordinate
     */
    public double getY() {
        return Y;
    }

    /**
     * Sets the X coordinate of this vector
     *
     * @param x the new X coordinate
     */
    public void setX(double x) {
        X = x;
    }

    /**
     * Sets the Y coordinate of this vector
     *
     * @param y the new X coordinate
     */
    public void setY(double y) {
        Y = y;
    }

    public Vector2D(double x, double y) {
        X = x;
        Y = y;
    }

    /**
     * Returns the magnitude (length) of this Vector
     *
     * @return Length of this Vector
     */
    public double magnitude() {
        return Math.sqrt(Math.pow(X, 2) + Math.pow(Y, 2));
    }

    /**
     * Calculates the distance in units between this vector and a given one
     *
     * @param to the vector which distance to is calculated
     * @return the distance in units
     */
    public double distanceTo(Vector2D to) {
        double dx = to.X - this.X;
        double dy = to.Y - this.Y;
        Vector2D v = new Vector2D(dx, dy);
        return v.magnitude();
    }
}


