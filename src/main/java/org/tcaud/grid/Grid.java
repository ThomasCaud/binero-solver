package org.tcaud.grid;

public abstract class Grid {
    public abstract boolean isValid(Board board);

    public abstract int[] getPossibleValues();
}
