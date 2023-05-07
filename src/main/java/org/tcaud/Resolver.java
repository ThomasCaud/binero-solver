package org.tcaud;

public class Resolver {
    public static boolean resolve(Grid grid) {
        return resolve(grid, new Cell(0, 0));
    }

    private static boolean resolve(Grid grid, Cell cell) {
        grid.display();
        if (cell.row() >= grid.getDimension()) {
            return true;
        }

        var nextCell = getNextCell(grid, cell.row(), cell.col());

        if (grid.isFulfilled(cell.row(), cell.col())) {
            return resolve(grid, nextCell);
        }

        int[] possibleValues = {0, 1};
        for (int possibleValue : possibleValues) {
            grid.updateCell(cell.row(), cell.col(), possibleValue);
            if (grid.isValid() && resolve(grid, nextCell)) {
                return true;
            }
        }

        grid.reinitializeCell(cell.row(), cell.col());
        return false;
    }

    private static Cell getNextCell(Grid grid, int row, int col) {
        if (col == grid.getDimension() - 1) {
            return new Cell(row + 1, 0);
        } else {
            return new Cell(row, col + 1);
        }
    }
}
