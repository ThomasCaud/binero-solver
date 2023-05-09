package org.tcaud.grid;

import org.tcaud.display.DisplayStrategy;

public class Board {
    public static final int VALUE_EMPTY_CELL = -1;
    protected int[][] grid;

    public Board(int[][] grid) {
        this.grid = grid;
    }

    public int getDimension() {
        return grid.length;
    }

    public boolean isFulfilled(int row, int col) {
        return grid[row][col] != VALUE_EMPTY_CELL;
    }

    public void updateCell(int row, int col, int value) {
        grid[row][col] = value;
    }

    public void reinitializeCell(int row, int col) {
        grid[row][col] = VALUE_EMPTY_CELL;
    }

    public int[][] getGrid() {
        return grid;
    }

    public void display(DisplayStrategy displayStrategy) {
        displayStrategy.display(this);
    }
}
