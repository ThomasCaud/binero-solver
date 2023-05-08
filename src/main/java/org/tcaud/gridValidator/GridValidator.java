package org.tcaud.gridValidator;

import org.tcaud.grid.Board;

public abstract class GridValidator {
    public abstract boolean isValid(Board board);

    public abstract int[] getPossibleValues();
}
