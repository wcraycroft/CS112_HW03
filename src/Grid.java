/* Grid.java - Defines an x-y grid on which rectangles and triangles will be drawn
 * Author:     Chris Merrill
 * Module:     3
 * Project:    Homework Project #2 (Chapter 8, Project 6)
 *
 *  Class Grid contains the width and height of an x-y grid to display, and
 *     a two-dimensional matrix of characters to display
 *
 *     Points on the grid will be from (0, 0) (bottom left corner) to
 *     (xMaximum, yMaximum) (upper-right corner)
 *
 *  Methods include:
 *     1.  Constructor, which sets maximum width (x direction) and maximum
 *         height (y direction) of grid
 *     2.  drawLine - draw a line on the grid
 *     3.  drawCell - draws a character on the grid at a specific location
 *     4.  getXMaximum and getYMaximum - return x and y maximum values of grid
 *     5.  drawGrid - draws the grid on the console
 */

public class Grid {

    // grid variables
    private int xMaximum ;                // maximum x-coordinate
    private int yMaximum ;                // maximum y-coordinate
    private char[][] outputMatrix ;       // output matrix of characters

    // Constructor (no default constructor).  Parameters are the width (xMaximum)
    // and height (yMaximum) of the grid.  Grid will go from (0, 0) at the lower
    // left corner and (xMaximum, yMaximum) upper-right corner of grid.  Each cell
    // of the grid will contain one char.
    public Grid(int xMaximum, int yMaximum) {
        // Check for values of x and y that aren't positive numbers
        if (xMaximum < 1 || yMaximum < 1) {
            throw new IllegalArgumentException((Math.min(xMaximum, yMaximum) + "")) ;
        }

        this.xMaximum = xMaximum ;        // size of output matrix along x-axis
        this.yMaximum = yMaximum ;        // size of output matrix along y-axis
        // Matrix goes from 0 -> xMaximum horizontally, 0 -> yMaximum vertically
        outputMatrix = new char[xMaximum + 1][yMaximum + 1] ;

        // Set the matrix to all blanks
        for (int x = 0 ; x <= xMaximum ; x++) {
            for (int y = 0 ; y <= yMaximum ; y++) {
                outputMatrix[x][y] = ' ' ;
            }
        }
    }

    // Make only the 'x' and 'y' size of grid available to outside world.
    // The output matrix is hidden -- the user must use the "draw..." methods
    public int getXMaximum() {
       return xMaximum ;
    }
    public int getYMaximum() {
        return yMaximum ;
    }

    // Places a specific character at a designated (x, y) position on the grid
    public void drawPoint(int x, int y, char drawChar) {
        if (x >= 0 && x <= xMaximum) {
            if (y >= 0 && y <= yMaximum) {
                outputMatrix[x][y] = drawChar ;
            }
        }
    }

    // Draw line from postions (x1, y1) to (x2, y2) by placing the character
    // specified by "drawChar" parameter into outputMatrix
    public void drawLine(int x1, int y1, int x2, int y2, char drawChar) {

        // If line is vertical (slope = infinity), then draw straight line up.
        if (x2 == x1) {
            for (int y = Math.max(Math.min(y1, y2), 0) ;
                     y <= Math.min(Math.max(y1, y2), yMaximum) ; y++) {
                drawPoint(x1, y, drawChar) ;
            }
            return ;
        }

        // The line isn't vertical.  If x-axis difference is greater (i.e., the
        // slope is more horizontal than vertical), then increment along x-axis,
        // calculating each corresponding value of y.
        double slope = (double) (y2 - y1) / (x2 - x1) ;
        if (Math.abs(x2 - x1) > Math.abs(y2 - y1)) {
            // The line is more horizontal than vertical.
            for (int x = Math.max(Math.min(x1, x2), 0) ;
                     x <= Math.min(Math.max(x1, x2), xMaximum) ; x++) {
                int y = (int)((double)y1 + (slope * (double)(x - x1)) + 0.5) ;
                drawPoint(x, y, drawChar) ;
            }
            return ;
        }

        // The line is more vertical than horizontal.  Draw points along y-axis,
        // calculating each value of x.
        for (int y = Math.max(Math.min(y1, y2), 0) ;
                 y <= Math.min(Math.max(y1, y2), yMaximum) ; y++) {
            int x = (int)((double)x1 + (double)((y - y1) / slope) + 0.5) ;
            drawPoint(x, y, drawChar) ;
        }
    } // end of drawPoint

    // Draw the grid with all cells on the console.  Also display x-axis and y-axis
    // on the console.
    public void drawGrid() {

        // First, print of y-scale on top of grid and the top-border of the grid
        System.out.printf("\ny=%-4s+", yMaximum) ;
        for (int x = 1 ; x < xMaximum ; x++) {
            System.out.print("-") ;
        }
        System.out.println("+") ;

        // Print detail of each row (outputMatrix[x]...)
        for (int y = yMaximum - 1 ; y > 0 ; y--) {
            System.out.print("      |") ;
            for (int x = 1 ; x < xMaximum ; x++) {
                System.out.print(outputMatrix[x][y]) ;
            }
            System.out.println("|") ;
        }

        // Finally print the bottom of grid, then print x-axis numbers.
        System.out.printf("  y=0 +") ;
        for (int x = 1 ; x < xMaximum ; x++) {
            System.out.print('-') ;
        }
        System.out.println("+") ;
        System.out.printf(("     x=0%" + (xMaximum - 1) + "s\n\n"), xMaximum) ;
    } // end of drawGrid
}