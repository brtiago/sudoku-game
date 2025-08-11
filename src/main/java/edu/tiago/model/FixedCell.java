package edu.tiago.model;

public class FixedCell extends Cell{
    public FixedCell(int row, int col, int value) {
        super(row, col, value);
    }

    @Override
    public boolean isEditable() {
        return false;
    }
}
