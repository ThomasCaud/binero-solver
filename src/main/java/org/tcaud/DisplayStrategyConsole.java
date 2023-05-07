package org.tcaud;

import org.tcaud.grid.BineroGrid;

import static org.tcaud.grid.BineroGrid.VALUE_EMPTY_CELL;

public class DisplayStrategyConsole implements DisplayStrategy {

    @Override
    public void display(BineroGrid grid) {
        System.out.println("==============");
        for (int[] row : grid.getGrid()) {
            for (int cell : row) {
                System.out.print(cell == VALUE_EMPTY_CELL ? ". " : cell + " ");
            }
            System.out.println();
        }
    }
}
