package org.tcaud.grid;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class SudokuGridTest {
    @Test
    void grid_not9x9_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> new SudokuGrid(new int[][]{
                {0, 1, 2, 3},
                {1, 1, 0, 0},
                {0, 1, 0, 1},
                {0, 1, 0, 1},
        }));
    }
}