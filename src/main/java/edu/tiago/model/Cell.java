package edu.tiago.model;

import java.util.Objects;

public abstract class Cell {
    private final int row;
    private final int col;
    private int value;

    public Cell(int row, int col, int value) {
        validateCoordinates(row, col);
        validateValue(value);
        this.row = row;
        this.col = col;
        this.value = value;
    }

    private void validateCoordinates(int row, int col) {
        if(row < 0 || row > 8 || col < 0 || col > 8) {
            throw new IllegalArgumentException("Invalid coordinates: (" + row + ", " + col + ")");
        }
    }

    protected boolean validateValue(int value) {
        if(value < 0 || value > 9) {
            throw new IllegalArgumentException("Value must be between 0-9!");
        }
        return true;
    }

    public int getRow() { return row; }
    public int getCol() { return col; }
    public int getValue() { return value; }

    protected void setValue(int value) {
        validateValue(value);
        this.value = value;
    }

    public abstract boolean isEditable();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cell cell = (Cell) obj;
        return row == cell.row && col == cell.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }

    @Override
    public String toString() {
        return String.format("Cell[%d,%d]=%d", row, col, value);
    }


}
