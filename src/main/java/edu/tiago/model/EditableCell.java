package edu.tiago.model

class EditableCell extends Cell {
    public EditableCell(int row, int col) {
        super(row, col, 0);
    }

    @Override
    public boolean isEditable() {
        return true;
    }

    @Override
    public void setValue(int value) {
        if(value >= 0 && value <= 9) {
            super.setValue(value);
        }
    }
}