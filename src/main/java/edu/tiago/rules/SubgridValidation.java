package edu.tiago.rules;

import edu.tiago.model.Cell;

public class SubgridValidation implements ValidationStrategy{

    final int SIZE = 9;



    @Override
    public boolean isValid(int row, int col, int value, Cell[][] grid) {
        int startRow = row - (row % 3);
        int startCol = col - (col % 3);

        for (int r = startRow; r < startRow + 3; r++) {
            for (int c = startCol; c < startCol + 3; c++) {
                if ((r != row || c != col) && grid[r][c].getValue() == value) {
                    return false;
                }
            }
        }
        return true;
    }

}
