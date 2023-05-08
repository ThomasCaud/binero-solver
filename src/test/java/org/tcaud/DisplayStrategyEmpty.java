package org.tcaud;

import org.tcaud.display.DisplayStrategy;
import org.tcaud.grid.Board;

public class DisplayStrategyEmpty implements DisplayStrategy {
    @Override
    public void display(Board board) {
        // do nothing
        // for testing purpose only
    }
}
