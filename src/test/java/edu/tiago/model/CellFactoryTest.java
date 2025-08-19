package edu.tiago.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellFactoryTest {

    @Test
    void shouldCreateFixedCell() {
        Cell cell = Cell.createCell(0, 0, 5, true);
        assertInstanceOf(FixedCell.class, cell);
        assertEquals(5, cell.getValue());
        assertFalse(cell.isEditable());
    }

}