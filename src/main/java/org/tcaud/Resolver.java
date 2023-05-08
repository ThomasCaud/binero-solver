package org.tcaud;

import org.tcaud.display.DisplayStrategy;
import org.tcaud.grid.Board;
import org.tcaud.gridValidator.GridValidator;

public class Resolver {
    public static boolean resolve(GridValidator gridValidator, Board board, DisplayStrategy displayStrategy) {
        return resolve(gridValidator, board, new Cell(0, 0), displayStrategy);
    }

    private static boolean resolve(GridValidator gridValidator, Board board, Cell cell, DisplayStrategy displayStrategy) {
        board.display(displayStrategy);
        if (cell.row() >= board.getDimension()) {
            return true;
        }

        var nextCell = getNextCell(board, cell.row(), cell.col());

        if (board.isFulfilled(cell.row(), cell.col())) {
            return resolve(gridValidator, board, nextCell, displayStrategy);
        }

        int[] possibleValues = gridValidator.getPossibleValues();
        for (int possibleValue : possibleValues) {
            board.updateCell(cell.row(), cell.col(), possibleValue);
            if (gridValidator.isValid(board) && resolve(gridValidator, board, nextCell, displayStrategy)) {
                return true;
            }
        }

        board.reinitializeCell(cell.row(), cell.col());
        return false;
    }

    private static Cell getNextCell(Board board, int row, int col) {
        if (col == board.getDimension() - 1) {
            return new Cell(row + 1, 0);
        } else {
            return new Cell(row, col + 1);
        }
    }
}
