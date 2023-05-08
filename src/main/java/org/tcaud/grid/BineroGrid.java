package org.tcaud.grid;

import java.util.Arrays;

import static org.tcaud.grid.Board.VALUE_EMPTY_CELL;

public class BineroGrid extends Grid {

    private void checkDimensions(int[][] grid) {
        if (grid.length != grid[0].length) {
            throw new IllegalArgumentException("Grid must be square");
        }
        if (grid.length % 2 == 1) {
            throw new IllegalArgumentException("Grid must have an even number of rows and columns");
        }
    }

    @Override
    public boolean isValid(Board board) {
        checkDimensions(board.getGrid());

        var dimension = board.getDimension();

        for (int i = 0; i < dimension; i++) {
            if (!isRowValid(board, i)) {
                return false;
            }
            if (!isColumnValid(board, i)) {
                return false;
            }
        }

        return !existsTwoFulfilledRowsIdentical(board) && !existsTwoFulfilledColumnsIdentical(board);
    }

    @Override
    public int[] getPossibleValues() {
        return new int[]{0, 1};
    }

    private boolean isRowValid(Board board, int row) {
        return getNumberOfOnRow(board, row, 0) <= board.getDimension() / 2
                && getNumberOfOnRow(board, row, 1) <= board.getDimension() / 2
                && !existsMoreThanTwoIdenticalValueInARow(board, row);
    }

    private boolean existsTwoFulfilledRowsIdentical(Board board) {
        for (int i = 0; i < board.getDimension(); i++) {
            for (int j = i + 1; j < board.getDimension(); j++) {
                if (Arrays.equals(board.grid[i], board.grid[j]) && Arrays.stream(board.grid[i]).noneMatch(cell -> cell == VALUE_EMPTY_CELL)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean existsTwoFulfilledColumnsIdentical(Board board) {
        for (int i = 0; i < board.getDimension(); i++) {
            for (int j = i + 1; j < board.getDimension(); j++) {
                if (Arrays.equals(getColumn(board, i), getColumn(board, j)) && Arrays.stream(getColumn(board, i)).noneMatch(cell -> cell == VALUE_EMPTY_CELL)) {
                    return true;
                }
            }
        }
        return false;
    }

    private int[] getColumn(Board board, int column) {
        return Arrays.stream(board.grid).mapToInt(row -> row[column]).toArray();
    }

    private int getNumberOfOnRow(Board board, int row, int value) {
        return Arrays.stream(board.grid[row]).filter(cell -> cell == value).toArray().length;
    }

    private boolean existsMoreThanTwoIdenticalValueInARow(Board board, int row) {
        var previousValue = board.grid[row][0];
        var count = 1;
        for (int i = 1; i < board.getDimension(); i++) {
            if (board.grid[row][i] == previousValue) {
                count++;
            } else {
                count = 1;
            }
            if (count > 2 && previousValue != VALUE_EMPTY_CELL) {
                return true;
            }
            previousValue = board.grid[row][i];
        }
        return false;
    }

    private boolean isColumnValid(Board board, int column) {
        return getNumberOfOnColumn(board, column, 0) <= board.getDimension() / 2
                && getNumberOfOnColumn(board, column, 1) <= board.getDimension() / 2
                && !existsMoreThanTwoIdenticalValueInAColumn(board, column);
    }

    private int getNumberOfOnColumn(Board board, int column, int value) {
        return Arrays.stream(board.grid).mapToInt(row -> row[column]).filter(cell -> cell == value).toArray().length;
    }

    private boolean existsMoreThanTwoIdenticalValueInAColumn(Board board, int column) {
        var previousValue = board.grid[0][column];
        var count = 1;
        for (int i = 1; i < board.getDimension(); i++) {
            if (board.grid[i][column] == previousValue) {
                count++;
            } else {
                count = 1;
            }
            if (count > 2 && previousValue != VALUE_EMPTY_CELL) {
                return true;
            }
            previousValue = board.grid[i][column];
        }
        return false;
    }
}
