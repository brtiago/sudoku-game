package edu.tiago.rules;

import edu.tiago.model.Cell;
import edu.tiago.model.EditableCell;
import edu.tiago.model.FixedCell;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubgridValidationTest {

    @Test
    void shouldDetectSubgridConflict() {
        // ARRANGE
        Cell[][] grid = createTestGrid();
        grid[0][0] = new FixedCell(0, 0, 5);

        SubgridValidation validator = new SubgridValidation();

        // ACT
        boolean isValid = validator.isValid(1, 1, 5, grid);

        // ASSERT
        assertFalse(isValid, "Deveria detectar conflito na subgrade");

    }


    private Cell[][] createTestGrid() {
        Cell[][] grid = new Cell[9][9];

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                grid[row][col] = new EditableCell(row, col, 0);

            }
        }
        return grid;
    }

}