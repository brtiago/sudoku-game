package edu.tiago.model;

public abstract class Cell {
    private final int row;
    private final int col;
    private int value;

    public Cell(int row, int col, int value) {
        this.row = row;
        this.col = col;
        this.value = value;
    }

    public int getRow() { return row; }

    public int getCol() { return col; }

    public int getValue() { return value; }

    public void setValue(int value) {
        this.value = value;
    }

    public abstract boolean isEditable();
}
