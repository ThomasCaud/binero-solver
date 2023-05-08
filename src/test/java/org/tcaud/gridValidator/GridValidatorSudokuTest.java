package org.tcaud.gridValidator;

import org.junit.jupiter.api.Test;
import org.tcaud.grid.Board;

import static org.junit.jupiter.api.Assertions.assertThrows;

class GridValidatorSudokuTest {
    @Test
    void isValid_not9x9_throwsException() {
        var sudokuGrid = new GridValidatorSudoku();
        assertThrows(IllegalArgumentException.class, () -> sudokuGrid.isValid(new Board(new int[][]{
                {0, 1, 2, 3},
                {1, 1, 0, 0},
                {0, 1, 0, 1},
                {0, 1, 0, 1},
        })));
    }
}