package org.tcaud.gridvalidator;

import org.tcaud.grid.Board;
import org.tcaud.grid.GameName;

public interface GridValidator {
    public boolean isValid(Board board);

    public int[] getPossibleValues();

    public boolean isEligible(GameName gameName);
}
