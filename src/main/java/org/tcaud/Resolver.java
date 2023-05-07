package org.tcaud;

public class Resolver {
    public static boolean resolve(Grid grid) {
        return resolve(grid, 0, 0);
    }

    private static boolean resolve(Grid grid, int row, int col) {
        if (row >= grid.getDimension()) {
            return true;
        }

        int rowNextCell;
        int colNextCell;
        if (col == grid.getDimension() - 1) {
            rowNextCell = row + 1;
            colNextCell = 0;
        } else {
            rowNextCell = row;
            colNextCell = col + 1;
        }

        if (grid.isFulfilled(row, col)) {
            return resolve(grid, rowNextCell, colNextCell);
        }

        int[] possibleValues = {0, 1};
        for (int possibleValue : possibleValues) {
            grid.updateCell(row, col, possibleValue);
            if (grid.isValid()) {
                if (resolve(grid, rowNextCell, colNextCell)) {
                    return true;
                }
            }
        }
        grid.updateCell(row, col, -1);

        return false;
    }
}
