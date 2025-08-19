package edu.tiago.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellFactoryTest {

    @Test
    void shouldCreateFixedCell() {
        // Arrange
        int row = 0, col = 0, value = 5;
        boolean isFixed = true;

        // Act
        Cell cell = Cell.createCell(row, col, value, isFixed);

        // Assert
        assertInstanceOf(FixedCell.class, cell);
        assertEquals(5, cell.getValue());
        assertFalse(cell.isEditable());
    }

    @Test
    void shouldCreateEditableCell() {
        // Arrange
        int row = 0, col = 0, value = 0;
        boolean isFixed = false;

        // Act
        Cell cell = Cell.createCell(row, col, value, isFixed);

        // Assert
        assertInstanceOf(EditableCell.class, cell);
        assertEquals(0, cell.getValue());
        assertTrue(cell.isEditable());
    }

    @Test
    void shouldThrowExceptionForInvalidValue() {
        // Arrange
        int row = 0, col = 0, value = 10;
        boolean isFixed = false;

        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            Cell.createCell(row, col, value, isFixed);
        });
    }

}