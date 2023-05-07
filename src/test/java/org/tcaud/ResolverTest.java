package org.tcaud;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.tcaud.grid.BineroGrid;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ResolverTest {
    @Test
    void resolve_easyGrid() {
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
    void resolve_easyGridWithBacktrack() {
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
    void resolve_mediumGrid() {
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
    void resolve_hardGrid() {
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
        }));

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
}