package org.tcaud.display;

import org.tcaud.grid.Board;

import static org.tcaud.grid.Board.VALUE_EMPTY_CELL;

public class DisplayStrategyConsole implements DisplayStrategy {

    @Override
    public void display(Board board) {
        System.out.println("==============");
        for (int[] row : board.getGrid()) {
            for (int cell : row) {
                System.out.print(cell == VALUE_EMPTY_CELL ? ". " : cell + " ");
            }
            System.out.println();
        }
    }
}
