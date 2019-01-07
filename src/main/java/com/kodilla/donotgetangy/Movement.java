package com.kodilla.donotgetangy;

import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class Movement {
    private static int numberOfMoves = 0;
    public static void moveThePawn(GridPane grid, Pawn pawn, int diceRoll, UserMovesList list, ArrayList<Field> mapOfMovements) {
        if (pawn.getActivationStatus() == false) {
            if (diceRoll == 1 || diceRoll == 6) {
                pawn.changeActivationStatus();
            }
        }
        if(pawn.getActivationStatus() == true) {
            ArrayList<Field> movementList = mapOfMovements;
            Field pawnCurrentField = pawn.getCurrentField();
            int indexOfCurrentField = 0;
            for (int i = 0; i < movementList.size(); i++) {
                if (pawnCurrentField == movementList.get(i)) {
                    indexOfCurrentField = i;
                }
            }
            System.out.println("Index: " + indexOfCurrentField);
            grid.getChildren().remove(list.getUserMovesList().get(list.getUserMovesList().size() - 1));
            pawnCurrentField.changeFieldStatus();
            ImageView pawnImage = pawn.getPawnImage();
            list.addToUserMovesList(pawnImage);
            if (indexOfCurrentField + diceRoll <= movementList.size() - 1) {
                grid.add(pawnImage, movementList.get(indexOfCurrentField + diceRoll).getColumn(), movementList.get(indexOfCurrentField + diceRoll).getRow());
                pawn.setNewPosition(movementList.get(indexOfCurrentField + diceRoll));
                pawn.getCurrentField().changeFieldStatus();
                //System.out.println("Index: " + indexOfCurrentField);
                numberOfMoves++;
                System.out.println("Rozmiar listy: " + movementList.size());
                System.out.println("Numerruchu: " + numberOfMoves);

            } else {
                grid.add(pawnImage, movementList.get(movementList.size() - 1).getColumn(), movementList.get(movementList.size() - 1).getRow());
                pawn.setNewPosition(movementList.get(movementList.size() - 1));
                pawn.getCurrentField().changeFieldStatus();
                movementList.remove(movementList.size() - 1);
                pawn.changeActivationStatus();
            }
        } else {

        }

    }
}
