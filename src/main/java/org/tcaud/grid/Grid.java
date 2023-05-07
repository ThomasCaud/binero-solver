package org.tcaud.grid;

import org.tcaud.display.DisplayStrategy;

import static java.lang.Thread.sleep;

public abstract class Grid {
    public static final int VALUE_EMPTY_CELL = -1;
    protected int[][] grid;
    protected DisplayStrategy displayStrategy;

    public abstract boolean isValid();

    public abstract int[] getPossibleValues();

    public abstract GAME getGame();

    public void display() {
        try {
            sleep(5L);
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }

        displayStrategy.display(this);
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
}
