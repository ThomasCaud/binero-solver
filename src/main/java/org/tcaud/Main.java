package org.tcaud;

public class Main {
    public static void main(String[] args) {
        var grid = new Grid(new int[][] {
            { 0, 0, 1, 1 },
            { 1, 1, 0, 0 },
            { 0, 1, 0, 1 },
            { 1, 0, 1, 0 }
        });
        grid.display();
    }
}