package edu.tiago.rules;

import edu.tiago.model.Cell;

public interface ValidationStrategy {
    boolean isValid(int row, int col, int value, Cell[][] grid);
}
