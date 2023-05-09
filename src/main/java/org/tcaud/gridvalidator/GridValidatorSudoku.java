package org.tcaud.gridvalidator;

import org.tcaud.grid.Board;
import org.tcaud.grid.GameName;

import java.util.stream.IntStream;

import static org.tcaud.grid.Board.VALUE_EMPTY_CELL;

public class GridValidatorSudoku implements GridValidator {
    private static final int BOARD_SIZE = 9;
    private static final int SUBSECTION_SIZE = 3;

    @Override
    public boolean isValid(Board board) {
        checkDimensions(board.getGrid());

        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                if (!isValid(board, row, col)) {
                    return false;
                }
            }
        }
        return true;
    }

    private void checkDimensions(int[][] grid) {
        if (grid.length != BOARD_SIZE || grid[0].length != BOARD_SIZE) {
            throw new IllegalArgumentException("Sudoku grid must be 9x9.");
        }
    }

    private boolean isValid(Board board, int row, int column) {
        return rowConstraint(board.getGrid(), row)
                && columnConstraint(board.getGrid(), column)
                && subsectionConstraint(board.getGrid(), row, column);
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

    @Override
    public int[] getPossibleValues() {
        return new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    }

    @Override
    public boolean isEligible(GameName gameName) {
        return gameName == GameName.SUDOKU;
    }
}
