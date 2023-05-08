package org.tcaud.gridValidator;

import org.tcaud.grid.Board;
import org.tcaud.grid.GameName;

public abstract class GridValidator {
    public abstract boolean isValid(Board board);

    public abstract int[] getPossibleValues();

    public abstract boolean isEligible(GameName gameName);
}
