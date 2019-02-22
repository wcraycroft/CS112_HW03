/* Figure.java
 * Author:  William Craycroft
 * Module:  3
 * Project: Homework 3
 * Description: Abstract parent class which manipulates data about a two dimensional figure.
 *
 *      Instance variables:
 *          mX (int) - point of origin x-coordinate
 *          mY (int) - point of origin y-coordinate
 *          mLength (int) - length of the figure
 *          mHeight (int) - height of the figure
 *          mGrid (Grid) - point of origin x-coordinate
 *
 *      Methods:
 *          Constructors
 *               Parameterized constructor that takes in the origin's x and y coordinates, the length  and height
 *               of the figure and the Grid object for it to be drawn in.
 *          Setters and Getters for all instance variables
 *          Helper methods
 *              setCenter() - sets the origin coordinates so that the figure will be centered on the Grid
 *          Abstract methods
 *              draw() - sends instructions to Grid object on how to construct the appropriate figure.
 *              erase() - sends instructions to Grid object on how to remove the figure.
 *              center() - moves the figure to approximately the center of the Grid
 *              toString() - returns a String representation of the figure.
 *              equals(Object) - returns the equality of two objects of the same type.
 */


public abstract class Figure {

    // Instance variables
    private int mX;         // point of origin x-coordinate
    private int mY;         // point of origin y-coordinate
    private int mLength;    // horizontal length of figure
    private int mHeight;    // vertical height of figure
    private Grid mGrid;     // current Grid object being drawn on

    public Figure(int x, int y, int length, int height, Grid grid) {
        mX = x;
        mY = y;
        mLength = length;
        mHeight = height;
        mGrid = grid;
    }

    //  Getters and Setters for Instance variables
    public int getX() {
        return mX;
    }

    public void setX(int x) {
        mX = x;
    }

    public int getY() {
        return mY;
    }

    public void setY(int y) {
        mY = y;
    }

    public int getLength() {
        return mLength;
    }

    public void setLength(int length) {
        mLength = length;
    }

    public int getHeight() {
        return mHeight;
    }

    public void setHeight(int height) {
        mHeight = height;
    }

    public Grid getGrid() {
        return mGrid;
    }

    public void setGrid(Grid grid) {
        mGrid = grid;
    }

    // Helper methods

    // Sets the origin x, y coordinates as such that the shape will be centered on the grid.
    // Coordinates are determined by halving the Grid's maximum x and y coordinates, then subtracting half of the
    // figure's length and height to get it approximately to the center.
    public void setCenter() {
        setX((mGrid.getXMaximum() / 2) - (mLength / 2));
        setY((mGrid.getYMaximum() / 2) - (mHeight / 2));
    }

    // Abstract methods

    // draw() will send instructions to Grid object on how to construct the appropriate figure.
    public abstract void draw();
    // erase() will send instructions to Grid object on how to remove the figure.
    public abstract void erase();
    // center() will center the figure by calling the erase method, the parent setCenter() method, and then draw()
    public abstract void center();
    // Returns the equality of two objects of the same type.
    public abstract boolean equals(Object otherObject);
    // Returns a String representation of the appropriate figure.
    public abstract String toString();

}