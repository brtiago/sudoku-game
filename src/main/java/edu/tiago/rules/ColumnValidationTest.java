package edu.tiago.rules;

import edu.tiago.model.Cell;

public class ColumnValidationTest implements ValidationStrategy{

    final int SIZE = 9;

    @Override
    public boolean isValid(int row, int col, int value, Cell[][] grid) {
        for (int r = 0; r < SIZE ; r++) {
            if (r != row && grid[r][col].getValue() == value) {
                return false;
            }
        }
        return true;
    }
}
