package org.tcaud;

import org.tcaud.display.DisplayStrategy;
import org.tcaud.grid.Grid;

public class DisplayStrategyEmpty implements DisplayStrategy {
    @Override
    public void display(Grid grid) {
        // do nothing
        // for testing purpose only
    }
}
