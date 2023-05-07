package org.tcaud;

import static org.tcaud.Grid.VALUE_EMPTY_CELL;

public class DisplayStrategyConsole implements DisplayStrategy {

    @Override
    public void display(Grid grid) {
        System.out.println("==============");
        for (int[] row : grid.getGrid()) {
            for (int cell : row) {
                System.out.print(cell == VALUE_EMPTY_CELL ? ". " : cell + " ");
            }
            System.out.println();
        }
    }
}
