package sj223gb_assign1;

/**
* Class Description: This class is about the seventh task of assignment 1.
* Program sets coordinates and moves them, furthermore it also checks if two coordinates are equal.
* 
* @version 1.0 7 September 2021
* @author Sebastian Jonsson
*/
public class Point {
    int X;
    int Y;
    
    /**
     * Constructor for no input.
     */
    public Point() {
        this.X = 0;
        this.Y = 0;
    }

    /**
     * Constructor for two params.
     */
    public Point(int newX, int newY) {
        this.X = newX;
        this.Y = newY;
    }

    /**
     * Transforms values into correct String format.
     * 
     * @return - The proper String format.
     */
    public String toString() {
        return "Point(" + X + "," + Y +")";
    }

    /**
     * Checks if this instance compared to another is equal.
     * 
     * @param p2 - The second instance.
     * @return - A boolean value.
     */
    public boolean isEqualTo(Point p2) {
        return this.X == p2.X && this.Y == p2.Y;
    }

    /**
     * Checks the distance of X and Y coordinates between two instances.
     * 
     * @param p2 - The second instance.
     * @return - The distance between both instances.
     */
    public double distanceTo(Point p2) {
        double distance = Math.sqrt(Math.pow(this.X - p2.X, 2) + Math.pow(this.Y - p2.Y, 2));

        return distance;
    }

    /**
     * Moves the X and Y coordinates the amount of steps sent through the params.
     * 
     * @param x - Input X coordinates.
     * @param y - Input Y coordinates.
     */
    public void move(int x, int y) {
        this.X += x; 
        this.Y += y;
    }

    /**
     * Moves the X and Y coordinates to the points given directly.
     * 
     * @param x - Input X coordinates.
     * @param y - Input Y coordinates.
     */
    public void moveToXY(int x, int y) {
        this.X = x;
        this.Y = y;
    }

}
