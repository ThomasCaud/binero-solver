package org.tcaud;

public class Grid {
    private final int[][] grid;

    public Grid(int[][] grid) {
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
