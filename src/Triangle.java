/* Triangle.java
 * Author:  William Craycroft
 * Module:  3
 * Project: Homework 3
 * Description: This class is used to store and manipulate data for a Triangle figure. It uses the Grid class to draw
 *              a representation of it to the console.
 *
 *      Methods:
 *          Constructors:
 *              Parameterized constructor that takes in origin's x and y coordinates, the length of the figure,
 *              its height, and the Grid object for it to be drawn in.
 *          Helper methods:
 *              draw()  - User can call this method to add the current Triangle to the grid.
 *              erase() - User can call this method to erase the current Triangle from the grid. In effect, it will
 *                  redraw the figure using blank space character.
 *              drawTriangle() - Private method used to handle shared code between draw() and erase(). Draws the
 *                  appropriate lines using the Grid class methods.
 *              center() - User can call this method to center the Triangle in the middle of the grid.
 *          Other methods:
 *              toString() - displays origin's coordinates, length and height of the Triangle.
 *              equals(Object) - checks two Triangle objects for equal coordinates, height, width and Grid.
 */


import java.util.Objects;

public class Triangle extends Figure {

    // The character that will be used by Grid to draw Triangles
    public static final char TRIANGLE_DRAW_CHAR = '*';

    // Parameterized Constructor
    // Takes in the x,y coordinates for the bottom left corner of the Triangle, length, height
    // and the Grid for it to be drawn in.
    public Triangle(int x, int y, int length, int height, Grid grid) {
        super(x, y, length, height, grid);
    }

    // User can call this method to add the current Triangle to the grid.
    public void draw() {
        drawTriangle(TRIANGLE_DRAW_CHAR);
    }

    // User can call this method to erase the current Triangle from the grid.
    // Effectively works the same as draw() but uses blank space character.
    public void erase() {
        drawTriangle(' ');
    }

    // Will draw (or erase) a Triangle outline made up of the character it is passed.
    private void drawTriangle(char drawChar) {
        // Draw adjacent line [(x, y) => (x + length, y)]
        getGrid().drawLine(getX(), getY(), getX() + getLength(), getY(), drawChar);
        // Draw opposite line [(x, y) => (x, y + height)]
        getGrid().drawLine(getX(), getY(), getX(), getY() + getHeight(), drawChar);
        // Draw hypotenuse [(x, y + height) => (x + length, y)]
        getGrid().drawLine(getX(), getY() + getHeight(), getX() + getLength(), getY(), drawChar);
    }

    // User can call this method to center the Triangle in the middle of the grid
    public void center() {
        erase();
        setCenter();
        draw();
    }

    // Returns a String representation of current Triangle
    public String toString() {
        return String.format("Triangle[Origin=(%d, %d), Length=%d, Height=%d]", getX(), getY(), getLength(), getHeight());
    }

    // Returns the equality of two Triangle objects
    public boolean equals(Object otherObject) {
        if (otherObject == null || getClass() != otherObject.getClass()) {
            return false;
        }
        Triangle otherTriangle = (Triangle) otherObject;
        return getX() == otherTriangle.getX() &&
                getY() == otherTriangle.getY() &&
                getLength() == otherTriangle.getLength() &&
                getHeight() == otherTriangle.getHeight() &&
                Objects.equals(getGrid(), otherTriangle.getGrid());
    }
}