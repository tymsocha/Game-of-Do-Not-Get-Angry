package com.kodilla.donotgetangy;

public class Field {
    private int column;
    private int row;
    private static boolean occupied = false;

    public Field(int column, int row) {
        this.column = column;
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public boolean changeFieldStatus() {
        if (occupied == false) {
            occupied = true;
        } else {
            occupied = false;
        }
        return occupied;
    }

    // Field should also have a method that returns if it is occupied or not
    // if field iss occupied then return old pawn to start field and put new pawn here unless both pawns are the same color
}
