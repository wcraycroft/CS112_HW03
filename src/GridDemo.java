/* GridDemo.java
 * Authors: William Craycroft
 * Module:  3
 * Project: Homework 3
 * Problem Statement: This demo class will demonstrate the functionality of the Figure parent class and its children
 *      Rectangle and Triangle. It will also use the Grid class to draw these objects to the console.
 *
 * Algorithm / Plan:
 *      1. Create an array of size 4 with variable type Figure.
 *      2. Instantiate 2 Rectangle objects and 2 Triangle objects.
 *      3. For each element in figures array, call their draw() method
 *      4. Draw the grid.
 *      5. Call the center() method for the second rectangle in the array (element 1)
 *      6. Draw the grid
 *      7. Call the erase() method for the second rectangle, and the center() method for the first triangle in the array.
 *      8. Draw the grid

 */

public class GridDemo {

    public static void main (String[] args) {

        // Declare Figure array
        Figure[] figures = new Figure[4];

        // Instantiate new grid
        Grid currentGrid = new Grid(50, 15);

        // Instantiate a large rectangle in the bottom part of the grid
        figures[0] = new Rectangle(10, 1, 22, 6, currentGrid);
        // Instantiate a small rectangle inside the first rectangle
        figures[1] = new Rectangle(22, 3, 3, 2, currentGrid);
        // Instantiate a right-based triangle in top left of grid
        figures[2] = new Triangle(12, 8, -10, 5, currentGrid);
        // Instantiate a left-based triangle in top right of grid
        figures[3] = new Triangle(35, 7, 7, 7, currentGrid);

        // Loop through array, call draw() method
        for (Figure currentFigure : figures) {
            currentFigure.draw();
        }
        // Draw current grid to console.
        System.out.println("Initial grid with two Rectangles and two Triangles.");
        currentGrid.drawGrid();

        // Call the center() method for the second rectangle
        figures[1].center();
        // Draw current grid to console.
        System.out.println("The grid after second rectangle is centered.");
        currentGrid.drawGrid();

        // erase() second rectangle
        figures[1].erase();
        // center() first second triangle
        figures[2].center();
        // Draw current grid to console.
        System.out.println("The grid after second rectangle is erased and first triangle is centered.");
        currentGrid.drawGrid();
    }
}
