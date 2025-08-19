package edu.tiago.rules;

import edu.tiago.model.Cell;

public class RowValidation implements ValidationStrategy{

    final int SIZE = 9;

    @Override
    public boolean isValid(int row, int col, int value, Cell[][] grid) {
        for (int c = 0; c < 9; c++) {
            if (c != col && grid[row][c].getValue() == value) {
                return false;
            }
        }
        return true;
    }
}
