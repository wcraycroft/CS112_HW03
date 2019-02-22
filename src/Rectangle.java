/* Rectangle.java
 * Author:  William Craycroft
 * Module:  3
 * Project: Homework 3
 * Description: This class is used to store and manipulate data for a Rectangle figure. It uses the Grid class to draw
 *              a representation of it to the console.
 *
 *      Methods:
 *          Constructors:
 *              Parameterized constructor that takes in origin's x and y coordinates, the length of the figure,
 *              its height, and the Grid object for it to be drawn in.
 *          Helper methods:
 *              draw()  - User can call this method to add the current rectangle to the grid.
 *              erase() - User can call this method to erase the current rectangle from the grid. In effect, it will
 *                  redraw the figure using blank space character.
 *              drawRectangle() - Private method used to handle shared code between draw() and erase(). Draws the
 *                  appropriate lines using the Grid class methods.
 *              center() - User can call this method to center the rectangle in the middle of the grid.
 *          Other methods:
 *              toString() - displays origin's coordinates, length and height of the Rectangle.
 *              equals(Object) - checks two Rectangle objects for equal coordinates, height, width and Grid.
 */


import java.util.Objects;

public class Rectangle extends Figure {

    // The character that will be used by Grid to draw Rectangles
    public static final char RECTANGLE_DRAW_CHAR = '#';

    // Parameterized Constructor
    // Takes in the x,y coordinates for the bottom left corner of the Rectangle, length, height
    // and the Grid for it to be drawn in.
    public Rectangle(int x, int y, int length, int height, Grid grid) {
        super(x, y, length, height, grid);
    }

    // User can call this method to add the current rectangle to the grid.
    public void draw() {
        drawRectangle(RECTANGLE_DRAW_CHAR);
    }

    // User can call this method to erase the current rectangle from the grid.
    // Effectively works the same as draw() but uses blank space character.
    public void erase() {
        drawRectangle(' ');
    }

    // Will draw (or erase) a rectangle outline made up of the character it is passed.
    private void drawRectangle(char drawChar) {
        // Draw bottom line [(x, y) => (x + length, y)]
        getGrid().drawLine(getX(), getY(), getX() + getLength(), getY(), drawChar);
        // Draw top line [(x, y + height) => (x + length, y + height)]
        getGrid().drawLine(getX(), getY() + getHeight(), getX() + getLength(), getY() + getHeight(), drawChar);
        // Draw left line [(x, y) => (x, y + height)]
        getGrid().drawLine(getX(), getY(), getX(), getY() + getHeight(), drawChar);
        // Draw right line [(x + length, y) => (x + length, y + height)]
        getGrid().drawLine(getX() + getLength(), getY(), getX() + getLength(), getY() + getHeight(), drawChar);
    }

    // User can call this method to center the rectangle in the middle of the grid
    public void center() {
        erase();
        setCenter();
        draw();
    }

    // Returns a String representation of current Rectangle
    public String toString() {
        return String.format("Rectangle[Origin=(%d, %d), Length=%d, Height=%d]", getX(), getY(), getLength(), getHeight());
    }

    // Returns the equality of two Rectangle objects
    public boolean equals(Object otherObject) {
        if (otherObject == null || getClass() != otherObject.getClass()) {
            return false;
        }
        Rectangle otherRectangle = (Rectangle) otherObject;
        return getX() == otherRectangle.getX() &&
                getY() == otherRectangle.getY() &&
                getLength() == otherRectangle.getLength() &&
                getHeight() == otherRectangle.getHeight() &&
                Objects.equals(getGrid(), otherRectangle.getGrid());
    }

}