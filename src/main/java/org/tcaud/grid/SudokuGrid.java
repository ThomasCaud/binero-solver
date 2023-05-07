package org.tcaud.grid;

import org.tcaud.display.DisplayStrategy;
import org.tcaud.display.DisplayStrategyConsole;

import java.util.stream.IntStream;

public class SudokuGrid extends Grid {
    private static final int BOARD_SIZE = 9;
    private static final int SUBSECTION_SIZE = 3;

    public SudokuGrid(int[][] grid, DisplayStrategy displayStrategy) {
        checkDimensions(grid);
        this.grid = grid;
        this.displayStrategy = displayStrategy;
    }

    public SudokuGrid(int[][] grid) {
        checkDimensions(grid);
        this.grid = grid;
        this.displayStrategy = new DisplayStrategyConsole();
    }

    private void checkDimensions(int[][] grid) {
        if (grid.length != BOARD_SIZE || grid[0].length != BOARD_SIZE) {
            throw new IllegalArgumentException("Sudoku grid must be 9x9.");
        }
    }

    @Override
    public boolean isValid() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                if (!isValid(row, col)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int[] getPossibleValues() {
        return new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    }

    @Override
    public GAME getGame() {
        return GAME.SUDOKU;
    }

    private boolean isValid(int row, int column) {
        return rowConstraint(getGrid(), row)
                && columnConstraint(getGrid(), column)
                && subsectionConstraint(getGrid(), row, column);
    }

    private boolean rowConstraint(int[][] board, int row) {
        var constraint = new boolean[BOARD_SIZE];
        return IntStream.range(0, BOARD_SIZE)
                .allMatch(column -> checkConstraint(board, row, constraint, column));
    }

    private boolean columnConstraint(int[][] board, int column) {
        var constraint = new boolean[BOARD_SIZE];
        return IntStream.range(0, BOARD_SIZE)
                .allMatch(row -> checkConstraint(board, row, constraint, column));
    }

    private boolean checkConstraint(
            int[][] board,
            int row,
            boolean[] constraint,
            int column
    ) {
        if (board[row][column] != VALUE_EMPTY_CELL) {
            if (!constraint[board[row][column] - 1]) {
                constraint[board[row][column] - 1] = true;
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean subsectionConstraint(int[][] board, int row, int column) {
        var constraint = new boolean[BOARD_SIZE];
        var subsectionRowStart = (row / SUBSECTION_SIZE) * SUBSECTION_SIZE;
        var subsectionRowEnd = subsectionRowStart + SUBSECTION_SIZE;

        var subsectionColumnStart = (column / SUBSECTION_SIZE) * SUBSECTION_SIZE;
        var subsectionColumnEnd = subsectionColumnStart + SUBSECTION_SIZE;

        for (var r = subsectionRowStart; r < subsectionRowEnd; r++) {
            for (var c = subsectionColumnStart; c < subsectionColumnEnd; c++) {
                if (!checkConstraint(board, r, constraint, c)) return false;
            }
        }
        return true;
    }
}
