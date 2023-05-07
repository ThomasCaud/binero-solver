package org.tcaud;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.tcaud.grid.BineroGrid;
import org.tcaud.grid.SudokuGrid;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ResolverTest {
    @Test
    void resolve_bineroEasyGrid() {
        // given
        var grid = (new BineroGrid(new int[][]{
                {0, 1},
                {-1, -1}
        }));

        var expectedResult = new int[][]{
                {0, 1},
                {1, 0}
        };

        // when
        var existResult = Resolver.resolve(grid);

        // then
        assertTrue(existResult);

        for (int i = 0; i < grid.getDimension(); i++) {
            Assertions.assertArrayEquals(expectedResult[i], grid.getGrid()[i]);
        }
    }

    @Test
    void resolve_bineroEasyGridWithBacktrack() {
        // given
        var grid = (new BineroGrid(new int[][]{
                {-1, -1},
                {1, 0}
        }));

        var expectedResult = new int[][]{
                {0, 1},
                {1, 0}
        };

        // when
        var existResult = Resolver.resolve(grid);

        // then
        assertTrue(existResult);

        for (int i = 0; i < grid.getDimension(); i++) {
            Assertions.assertArrayEquals(expectedResult[i], grid.getGrid()[i]);
        }
    }

    @Test
    void resolve_bineroMediumGrid() {
        // given
        var grid = (new BineroGrid(new int[][]{
                {-1, 0, -1, -1, 1, -1},
                {-1, -1, 0, -1, -1, 1},
                {0, -1, -1, -1, 0, -1},
                {-1, 0, -1, -1, -1, -1},
                {1, -1, 1, -1, -1, 1},
                {0, -1, -1, -1, 1, -1},
        }));

        // to complete
        var expectedResult = new int[][]{
                {1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1},
                {0, 1, 1, 0, 0, 1},
                {1, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 0, 1},
                {0, 1, 0, 1, 1, 0},
        };

        // when
        var existResult = Resolver.resolve(grid);

        // then
        assertTrue(existResult);

        for (int i = 0; i < grid.getDimension(); i++) {
            Assertions.assertArrayEquals(expectedResult[i], grid.getGrid()[i]);
        }
    }

    @Test
    void resolve_bineroHardGrid() {
        // given
        var grid = (new BineroGrid(new int[][]{
                {-1, 0, -1, 1, -1, -1, -1, 1, -1, 0},
                {-1, 0, 0, -1, -1, -1, 0, -1, -1, -1},
                {-1, -1, -1, -1, -1, 0, -1, -1, 0, 1},
                {-1, -1, -1, 0, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, 1, -1, 0, -1, 1, -1},
                {-1, 0, -1, -1, -1, -1, -1, -1, 1, -1},
                {-1, -1, -1, -1, 1, 1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, 1, -1, -1, 0, 0},
                {1, 1, -1, -1, 0, -1, -1, -1, -1, 0},
                {-1, -1, -1, -1, 0, -1, 0, 0, -1, -1},
        }, new DisplayStrategyEmpty()));

        var expectedResult = new int[][]{
                {1, 0, 0, 1, 1, 0, 1, 1, 0, 0},
                {1, 0, 0, 1, 0, 1, 0, 1, 1, 0},
                {0, 1, 1, 0, 1, 0, 1, 0, 0, 1},
                {0, 1, 1, 0, 0, 1, 1, 0, 0, 1},
                {1, 0, 0, 1, 1, 0, 0, 1, 1, 0},
                {0, 0, 1, 1, 0, 0, 1, 0, 1, 1},
                {0, 1, 0, 0, 1, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 1, 0, 1, 0, 0},
                {1, 1, 0, 1, 0, 0, 1, 0, 1, 0},
                {0, 1, 1, 0, 0, 1, 0, 0, 1, 1},
        };

        // when
        var existResult = Resolver.resolve(grid);

        // then
        assertTrue(existResult);

        for (int i = 0; i < grid.getDimension(); i++) {
            Assertions.assertArrayEquals(expectedResult[i], grid.getGrid()[i]);
        }
    }

    @Test
    void resolve_sudoku() {
        // given
        var grid = (new SudokuGrid(new int[][]{
                {-1, -1, 4, -1, 5, -1, -1, -1, -1},
                {9, -1, -1, 7, 3, 4, 6, -1, -1},
                {-1, -1, 3, -1, 2, 1, -1, 4, 9},
                {-1, 3, 5, -1, 9, -1, 4, 8, -1},
                {-1, -1, -1, -1, -1, -1, 3, -1, -1},
                {-1, 7, 6, -1, 1, -1, 9, 2, -1},
                {3, 1, -1, 9, 7, -1, 2, -1, -1},
                {-1, -1, 9, 1, 8, 2, -1, -1, 3},
                {-1, -1, -1, -1, 6, -1, 1, -1, -1}
        }, new DisplayStrategyEmpty()));

        var expectedResult = new int[][]{
                {2, 6, 4, 8, 5, 9, 7, 3, 1},
                {9, 8, 1, 7, 3, 4, 6, 5, 2},
                {7, 5, 3, 6, 2, 1, 8, 4, 9},
                {1, 3, 5, 2, 9, 6, 4, 8, 7},
                {8, 9, 2, 5, 4, 7, 3, 1, 6},
                {4, 7, 6, 3, 1, 8, 9, 2, 5},
                {3, 1, 8, 9, 7, 5, 2, 6, 4},
                {6, 4, 9, 1, 8, 2, 5, 7, 3},
                {5, 2, 7, 4, 6, 3, 1, 9, 8}
        };

        // when
        var existResult = Resolver.resolve(grid);

        // then
        assertTrue(existResult);

        for (int i = 0; i < grid.getDimension(); i++) {
            Assertions.assertArrayEquals(expectedResult[i], grid.getGrid()[i]);
        }
    }
}