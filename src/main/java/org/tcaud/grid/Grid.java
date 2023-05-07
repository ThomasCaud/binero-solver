package org.tcaud.grid;

public interface Grid {
    boolean isValid();

    void display();

    int getDimension();

    boolean isFulfilled(int row, int col);

    void updateCell(int row, int col, int value);

    void reinitializeCell(int row, int col);
}
