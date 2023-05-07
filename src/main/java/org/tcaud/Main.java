package org.tcaud;

public class Main {
    public static void main(String[] args) {

        var grid = (new Grid(new int[][]{
                {-1, 0, -1, 1, -1, -1, -1, 1, -1, 0},
                {-1, 0, 0, -1, -1, -1, 0, -1, -1, -1},
                {-1, -1, -1, -1, -1, 0, -1, -1, 0, 1},
                {-1, -1, -1, 0, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, 1, -1, 0, -1, 1, -1},
                {-1, 0, -1, -1, -1, -1, -1, -1, 1, -1},
                {-1, -1, -1, -1, 1, 1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, 1, -1, -1, 0, 0},
                {1, 1, -1, -1, 0, -1, -1, -1, -1, 0},
                {-1, -1, -1, -1, 0, -1, 0, 0, -1, -1}
        }));
        var existResult = Resolver.resolve(grid);
        if (existResult) {
            System.out.println("Solution: ");
            grid.display();
        } else {
            System.out.println("No existing valid result.");
        }
    }
}