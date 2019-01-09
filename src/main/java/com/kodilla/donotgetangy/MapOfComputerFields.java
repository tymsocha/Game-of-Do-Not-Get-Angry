package com.kodilla.donotgetangy;

import java.util.ArrayList;
import java.util.List;

public class MapOfComputerFields {
    private static ArrayList<Field> listOfUserMovements = new ArrayList<>();

    public static void addListOfUserMovements() {
        listOfUserMovements.add(0, new Field(6,0));
        listOfUserMovements.add(1, new Field(6,1));
        listOfUserMovements.add(2, new Field(6,2));
        listOfUserMovements.add(3, new Field(6,3));
        listOfUserMovements.add(4, new Field(6,4));
        listOfUserMovements.add(5, new Field(7,4));
        listOfUserMovements.add(6, new Field(8,4));
        listOfUserMovements.add(7, new Field(9,4));
        listOfUserMovements.add(8, new Field(10,4));
        listOfUserMovements.add(9, new Field(10,5));
        listOfUserMovements.add(10, new Field(10,6));
        listOfUserMovements.add(11, new Field(9,6));
        listOfUserMovements.add(12, new Field(8,6));
        listOfUserMovements.add(13, new Field(7,6));
        listOfUserMovements.add(14, new Field(6,6));
        listOfUserMovements.add(15, new Field(6,7));
        listOfUserMovements.add(16, new Field(6,8));
        listOfUserMovements.add(17, new Field(6,9));
        listOfUserMovements.add(18, new Field(6,10));
        listOfUserMovements.add(19, new Field(5,10));
        listOfUserMovements.add(20, new Field(4,10));
        listOfUserMovements.add(21, new Field(4,9));
        listOfUserMovements.add(22, new Field(4,8));
        listOfUserMovements.add(23, new Field(4,7));
        listOfUserMovements.add(24, new Field(4,6));
        listOfUserMovements.add(25, new Field(3,6));
        listOfUserMovements.add(26, new Field(2,6));
        listOfUserMovements.add(27, new Field(1,6));
        listOfUserMovements.add(28, new Field(0,6));
        listOfUserMovements.add(29, new Field(0,5));
        listOfUserMovements.add(30, new Field(0,4));
        listOfUserMovements.add(31, new Field(1,4));
        listOfUserMovements.add(32, new Field(2,4));
        listOfUserMovements.add(33, new Field(3,4));
        listOfUserMovements.add(34, new Field(4,4));
        listOfUserMovements.add(35, new Field(4,3));
        listOfUserMovements.add(36, new Field(4,2));
        listOfUserMovements.add(37, new Field(4,1));
        listOfUserMovements.add(38, new Field(4,0));
        listOfUserMovements.add(39, new Field(5,0));
        //nest
        listOfUserMovements.add(40, new Field(5,1));
        listOfUserMovements.add(41, new Field(5,2));
        listOfUserMovements.add(42, new Field(5,3));
        listOfUserMovements.add(43, new Field(5,4));
    }

    public static ArrayList<Field> getListOfUserMovements() {
        return listOfUserMovements;
    }

    public static int getIndexOfCurrentField(ArrayList<Field> movementList, Field pawnCurrentField) {
        int indexOfCurrentField = 0;
        for (int i = 0; i < movementList.size(); i++) {
            if (pawnCurrentField == movementList.get(i)) {
                indexOfCurrentField = i;
            }
        }
        return indexOfCurrentField;
    }
}
