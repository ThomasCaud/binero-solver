package org.tcaud;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {
    @Test
    void grid_notSquare_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> new Grid(new int[][]{
                {0, 0, 1, 1},
                {1, 1, 0, 0},
                {0, 1, 0, 1}
        }));
    }

    @Test
    void grid_oddDimension_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> new Grid(new int[][] {
            { 0, 0, 1 },
            { 1, 1, 0 },
            { 0, 1, 0 },
        }));
    }
}