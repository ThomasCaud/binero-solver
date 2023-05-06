package org.tcaud;

public class Grid {
    private final int[][] grid;

    public Grid(int[][] grid) {
        if(grid.length != grid[0].length) {
            throw new IllegalArgumentException("Grid must be square");
        }
        if(grid.length % 2  == 1) {
            throw new IllegalArgumentException("Grid must have an even number of rows and columns");
        }
        this.grid = grid;
    }

    public void display() {
        for (int[] row : grid) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
