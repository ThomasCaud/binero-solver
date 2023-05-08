package org.tcaud;

import org.tcaud.display.DisplayStrategyFrame;
import org.tcaud.grid.Board;
import org.tcaud.grid.GameName;

public class Main {
    public static void main(String[] args) {
        /*
        var bineroBoard = (new Board(new int[][]{
                {-1, 0, -1, 1, -1, -1, -1, 1, -1, 0},
                {-1, 0, 0, -1, -1, -1, 0, -1, -1, -1},
                {-1, -1, -1, -1, -1, 0, -1, -1, 0, 1},
                {-1, -1, -1, 0, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, 1, -1, 0, -1, 1, -1},
                {-1, 0, -1, -1, -1, -1, -1, -1, 1, -1},
                {-1, -1, -1, -1, 1, 1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, 1, -1, -1, 0, 0},
                {1, 1, -1, -1, 0, -1, -1, -1, -1, 0},
                {-1, -1, -1, -1, 0, -1, 0, 0, -1, -1}
        }));
        var existResult = Resolver.resolve(GameName.BINERO, bineroBoard, new DisplayStrategyFrame());
        */

        var sudokuBoard = new Board(new int[][]{
                {8, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, 3, 6, -1, -1, -1, -1, -1},
                {-1, 7, -1, -1, 9, -1, 2, -1, -1},
                {-1, 5, -1, -1, -1, 7, -1, -1, -1},
                {-1, -1, -1, -1, 4, 5, 7, -1, -1},
                {-1, -1, -1, 1, -1, -1, -1, 3, -1},
                {-1, -1, 1, -1, -1, -1, -1, 6, 8},
                {-1, -1, 8, 5, -1, -1, -1, 1, -1},
                {-1, 9, -1, -1, -1, -1, 4, -1, -1}
        });

        var existResult = Resolver.resolve(GameName.SUDOKU, sudokuBoard, new DisplayStrategyFrame());
        if (existResult) {
            System.out.println("Solution: ");
            sudokuBoard.display(new DisplayStrategyFrame());
        } else {
            System.out.println("No existing valid result.");
        }
    }
}