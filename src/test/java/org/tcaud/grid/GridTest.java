package org.tcaud.grid;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GridTest {
    @Test
    void grid_notSquare_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> new BineroGrid(new int[][]{
                {0, 0, 1, 1},
                {1, 1, 0, 0},
                {0, 1, 0, 1}
        }));
    }

    @Test
    void grid_oddDimension_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> new BineroGrid(new int[][]{
                {0, 0, 1},
                {1, 1, 0},
                {0, 1, 0},
        }));
    }

    @Test
    void isValid_withValidGrid_returnTrue() {
        var grid = new BineroGrid(new int[][]{
                {0, 0, 1, 1},
                {1, 1, 0, 0},
                {0, 1, 0, 1},
                {1, 0, 1, 0}
        });
        assertTrue(grid.isValid());
    }

    @Test
    void isValid_gridWithTooMuchOneInARow_returnFalse() {
        var grid = new BineroGrid(new int[][]{
                {0, 0, 1, 1},
                {1, 1, 0, 1},
                {0, 1, 0, 1},
                {1, 0, 1, 0}
        });
        assertFalse(grid.isValid());
    }

    @Test
    void isValid_gridWithTooMuchZeroInARow_returnFalse() {
        var grid = new BineroGrid(new int[][]{
                {0, 0, 1, 1},
                {1, 1, 0, 1},
                {0, 0, 0, 1},
                {1, 0, 1, 0}
        });
        assertFalse(grid.isValid());
    }

    @Test
    void isValid_gridWithTooMuchOneInAColumn_returnFalse() {
        var grid = new BineroGrid(new int[][]{
                {0, 0, 1, 1},
                {1, 1, 0, 0},
                {0, 1, 0, 1},
                {1, -1, -1, 1}
        });
        assertFalse(grid.isValid());
    }

    @Test
    void isValid_gridWithTooMuchZeroInAColumn_returnFalse() {
        var grid = new BineroGrid(new int[][]{
                {0, 0, 1, 0},
                {1, -1, 0, 1},
                {0, -1, -1, 0},
                {1, 0, 1, 0}
        });
        assertFalse(grid.isValid());
    }

    @Test
    void isValid_gridWithMoreThanTwoIdenticalValuesInARowInARow_returnFalse() {
        var grid = new BineroGrid(new int[][]{
                {0, 0, 0, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1}
        });
        assertFalse(grid.isValid());
    }

    @Test
    void isValid_gridWithMoreThanTwoIdenticalValuesInARowInAColumn_returnFalse() {
        var grid = new BineroGrid(new int[][]{
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 0, -1, -1, -1, -1},
                {-1, 0, -1, -1, -1, -1},
                {-1, 0, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1}
        });
        assertFalse(grid.isValid());
    }

    @Test
    void isValid_twoIdenticalLines_returnFalse() {
        var grid = new BineroGrid(new int[][]{
                {1, 1, 0, 0, 1, 0},
                {1, 1, 0, 0, 1, 0},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1}
        });
        assertFalse(grid.isValid());
    }

    @Test
    void isValid_twoIdenticalColumns_returnFalse() {
        var grid = new BineroGrid(new int[][]{
                {0, 0, -1, -1, -1, -1},
                {0, 0, -1, -1, -1, -1},
                {1, 1, -1, -1, -1, -1},
                {1, 1, -1, -1, -1, -1},
                {0, 0, -1, -1, -1, -1},
                {1, 1, -1, -1, -1, -1}
        });
        assertFalse(grid.isValid());
    }
}