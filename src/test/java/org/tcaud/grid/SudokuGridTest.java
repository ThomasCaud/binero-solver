package org.tcaud.grid;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class SudokuGridTest {
    @Test
    void isValid_not9x9_throwsException() {
        var sudokuGrid = new SudokuGrid();
        assertThrows(IllegalArgumentException.class, () -> sudokuGrid.isValid(new Board(new int[][]{
                {0, 1, 2, 3},
                {1, 1, 0, 0},
                {0, 1, 0, 1},
                {0, 1, 0, 1},
        })));
    }
}