package edu.tiago.model;

import java.util.List;

public class Board {

    private static final int SIZE = 9;
    private Cell [][] grid;

    public Board() {
        this.grid = new Cell[SIZE][SIZE];
        initializeEmptyBoard();
    }

    private void initializeEmptyBoard() {
        for(int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                grid[row][col] = new EditableCell(row, col, 0);
            }
        }
    }

    public void loadBoard(List<String> fixedCells) {
        for (String cellData : fixedCells) {
            String[] parts = cellData.split(";");
            String[] coords = parts[0].split(",");
            String[] valueFixed = parts[1].split(",");

            int row = Integer.parseInt(coords[0]);
            int col = Integer.parseInt(coords[1]);
            int value = Integer.parseInt(valueFixed[0]);
            boolean isFixed = Boolean.parseBoolean(valueFixed[1]);

            if(isFixed) {
                grid[row][col] = new FixedCell(row, col, value);
            } else {
                grid[row][col].setValue(value);
            }
        }
    }

    public Cell getCell(int row, int col) {
        if(row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
            throw new IllegalArgumentException("Posição inválida!");
        }
        return grid[row][col];
    }

    public boolean isValidValue(int row, int col, int value) {
        for (int i = 0; i < SIZE; i++) {
            if (grid[row][i].getValue() == value && i != col) return false;
            if (grid[i][col].getValue() == value && i != row) return false;
        }

        int subgridStartRow = row - (row % 3);
        int subgridStartCol = col - (col % 3);
        for (int r = subgridStartRow; r < subgridStartRow + 3; r++) {
            for (int c = subgridStartCol; c < subgridStartCol + 3; c++) {
                if (grid[r][c].getValue() == value && r != row && c != col) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                sb.append(grid[row][col].getValue()).append(" ");
                if (col == 2 || col == 5) sb.append("| ");
            }
            sb.append("\n");
            if (row == 2 || row == 5) sb.append("------+-------+------\n");
        }
        return sb.toString();
    }
}
