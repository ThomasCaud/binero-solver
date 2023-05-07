package org.tcaud;

import org.tcaud.display.DisplayStrategyFrame;
import org.tcaud.grid.BineroGrid;
import org.tcaud.grid.SudokuGrid;

public class Main {
    public static void main(String[] args) {

        var bineroGrid = (new BineroGrid(new int[][]{
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
        }, new DisplayStrategyFrame()));

        var sudokuGrid = (new SudokuGrid(new int[][]{
                {8, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, 3, 6, -1, -1, -1, -1, -1},
                {-1, 7, -1, -1, 9, -1, 2, -1, -1},
                {-1, 5, -1, -1, -1, 7, -1, -1, -1},
                {-1, -1, -1, -1, 4, 5, 7, -1, -1},
                {-1, -1, -1, 1, -1, -1, -1, 3, -1},
                {-1, -1, 1, -1, -1, -1, -1, 6, 8},
                {-1, -1, 8, 5, -1, -1, -1, 1, -1},
                {-1, 9, -1, -1, -1, -1, 4, -1, -1}
        }, new DisplayStrategyFrame()));

        var existResult = Resolver.resolve(sudokuGrid);
        if (existResult) {
            System.out.println("Solution: ");
            sudokuGrid.display();
        } else {
            System.out.println("No existing valid result.");
        }
    }
}