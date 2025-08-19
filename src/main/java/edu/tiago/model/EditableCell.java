package edu.tiago.model;

public class EditableCell extends Cell {
    public EditableCell(int row, int col, int value) {
        super(row, col, value);
    }

    @Override
    public boolean isEditable() {
        return true;
    }

    @Override
    public void setValue(int value) {
        super.setValue(value);
    }
}