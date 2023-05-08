package org.tcaud.gridValidator;

import org.junit.jupiter.api.Test;
import org.tcaud.grid.Board;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GridValidatorBineroTest {
    private final GridValidator bineroGridValidator = new GridValidatorBinero();

    @Test
    void isValid_boardDotSquare_throwsException() {
        var board = new Board(new int[][]{
                {0, 0, 1, 1},
                {1, 1, 0, 0},
                {0, 1, 0, 1}
        });
        assertThrows(IllegalArgumentException.class, () -> bineroGridValidator.isValid(board));
    }

    @Test
    void grid_oddDimension_throwsException() {
        var board = new Board(new int[][]{
                {0, 0, 1},
                {1, 1, 0},
                {0, 1, 0},
        });
        assertThrows(IllegalArgumentException.class, () -> bineroGridValidator.isValid(board));
    }

    @Test
    void isValid_withValidGrid_returnTrue() {
        var board = new Board(new int[][]{
                {0, 0, 1, 1},
                {1, 1, 0, 0},
                {0, 1, 0, 1},
                {1, 0, 1, 0}
        });
        assertTrue(bineroGridValidator.isValid(board));
    }

    @Test
    void isValid_gridWithTooMuchOneInARow_returnFalse() {
        var board = new Board(new int[][]{
                {0, 0, 1, 1},
                {1, 1, 0, 1},
                {0, 1, 0, 1},
                {1, 0, 1, 0}
        });
        assertFalse(bineroGridValidator.isValid(board));
    }

    @Test
    void isValid_gridWithTooMuchZeroInARow_returnFalse() {
        var board = new Board(new int[][]{
                {0, 0, 1, 1},
                {1, 1, 0, 1},
                {0, 0, 0, 1},
                {1, 0, 1, 0}
        });
        assertFalse(bineroGridValidator.isValid(board));
    }

    @Test
    void isValid_gridWithTooMuchOneInAColumn_returnFalse() {
        var board = new Board(new int[][]{
                {0, 0, 1, 1},
                {1, 1, 0, 0},
                {0, 1, 0, 1},
                {1, -1, -1, 1}
        });
        assertFalse(bineroGridValidator.isValid(board));
    }

    @Test
    void isValid_gridWithTooMuchZeroInAColumn_returnFalse() {
        var board = new Board(new int[][]{
                {0, 0, 1, 0},
                {1, -1, 0, 1},
                {0, -1, -1, 0},
                {1, 0, 1, 0}
        });
        assertFalse(bineroGridValidator.isValid(board));
    }

    @Test
    void isValid_gridWithMoreThanTwoIdenticalValuesInARowInARow_returnFalse() {
        var board = new Board(new int[][]{
                {0, 0, 0, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1}
        });
        assertFalse(bineroGridValidator.isValid(board));
    }

    @Test
    void isValid_gridWithMoreThanTwoIdenticalValuesInARowInAColumn_returnFalse() {
        var board = new Board(new int[][]{
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 0, -1, -1, -1, -1},
                {-1, 0, -1, -1, -1, -1},
                {-1, 0, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1}
        });
        assertFalse(bineroGridValidator.isValid(board));
    }

    @Test
    void isValid_twoIdenticalLines_returnFalse() {
        var board = new Board(new int[][]{
                {1, 1, 0, 0, 1, 0},
                {1, 1, 0, 0, 1, 0},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1}
        });
        assertFalse(bineroGridValidator.isValid(board));
    }

    @Test
    void isValid_twoIdenticalColumns_returnFalse() {
        var board = new Board(new int[][]{
                {0, 0, -1, -1, -1, -1},
                {0, 0, -1, -1, -1, -1},
                {1, 1, -1, -1, -1, -1},
                {1, 1, -1, -1, -1, -1},
                {0, 0, -1, -1, -1, -1},
                {1, 1, -1, -1, -1, -1}
        });
        assertFalse(bineroGridValidator.isValid(board));
    }
}