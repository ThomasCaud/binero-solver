package org.tcaud.gridValidator;

import org.junit.jupiter.api.Test;
import org.tcaud.grid.Board;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GridValidatorSudokuTest {
    private final GridValidator sudokuGridValidator = new GridValidatorSudoku();

    @Test
    void isValid_not9x9_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> sudokuGridValidator.isValid(new Board(new int[][]{
                {0, 1, 2, 3},
                {1, 1, 0, 0},
                {0, 1, 0, 1},
                {0, 1, 0, 1},
        })));
    }

    @Test
    void isValid_twoIdenticalDigitsOnSameLine_returnsFalse() {
        var board = new Board(new int[][]{
                {8, 8, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1}
        });
        assertFalse(sudokuGridValidator.isValid(board));
    }

    @Test
    void isValid_twoIdenticalDigitsOnSameColumn_returnsFalse() {
        var board = new Board(new int[][]{
                {8, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1},
                {8, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1}
        });
        assertFalse(sudokuGridValidator.isValid(board));
    }

    @Test
    void isValid_twoIdenticalDigitsInSameRegion_returnsFalse() {
        var board = new Board(new int[][]{
                {8, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, 8, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1}
        });
        assertFalse(sudokuGridValidator.isValid(board));
    }

    @Test
    void isValid_validFulfilledBoard_returnsTrue() {
        var board = new Board(new int[][]{
                {2, 6, 4, 8, 5, 9, 7, 3, 1},
                {9, 8, 1, 7, 3, 4, 6, 5, 2},
                {7, 5, 3, 6, 2, 1, 8, 4, 9},
                {1, 3, 5, 2, 9, 6, 4, 8, 7},
                {8, 9, 2, 5, 4, 7, 3, 1, 6},
                {4, 7, 6, 3, 1, 8, 9, 2, 5},
                {3, 1, 8, 9, 7, 5, 2, 6, 4},
                {6, 4, 9, 1, 8, 2, 5, 7, 3},
                {5, 2, 7, 4, 6, 3, 1, 9, 8}
        });
        assertTrue(sudokuGridValidator.isValid(board));
    }
}