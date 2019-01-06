package com.kodilla.donotgetangy;

import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.util.List;

public class Movement {
    public static void moveTheUserPawn(GridPane grid, Pawn pawn, int diceRoll, UserMovesList list) {
        List<Field> movementList = MapOfUserFields.getListOfUserMovements();
        Field pawnCurrentField = pawn.getCurrentField();
        int indexOfCurrentField = 0;
        for(int i = 0; i < movementList.size(); i++ ) {
            if(pawnCurrentField == movementList.get(i)) {
                indexOfCurrentField = i;
            }
        }
        grid.getChildren().remove(list.getUserMovesList().get(list.getUserMovesList().size() - 1));
        pawnCurrentField.changeFieldStatus();
        ImageView pawnImage = pawn.getPawnImage();
        list.addToUserMovesList(pawnImage);
        if(indexOfCurrentField + diceRoll <= movementList.size()) {
            grid.add(pawnImage, movementList.get(indexOfCurrentField + diceRoll).getColumn(), movementList.get(indexOfCurrentField + diceRoll).getRow());
            pawn.setNewPosition(movementList.get(indexOfCurrentField + diceRoll));
            pawn.getCurrentField().changeFieldStatus();
        } else {
            grid.add(pawnImage, movementList.get(movementList.size()-1).getColumn(), movementList.get(movementList.size()-1).getRow());
            pawn.setNewPosition(movementList.get(movementList.size()-1));
            pawn.getCurrentField().changeFieldStatus();
            movementList.remove(movementList.size()-1);
        }
    }

    public static void moveTheComputerPawn(GridPane grid, Pawn pawn, int diceRoll, UserMovesList list) {
        List<Field> movementList = MapOfComputerFields.getListOfUserMovements();
        Field pawnCurrentField = pawn.getCurrentField();
        int indexOfCurrentField = 0;
        for(int i = 0; i < movementList.size(); i++ ) {
            if(pawnCurrentField == movementList.get(i)) {
                indexOfCurrentField = i;
            }
        }
        grid.getChildren().remove(list.getUserMovesList().get(list.getUserMovesList().size() - 1));
        pawnCurrentField.changeFieldStatus();
        ImageView pawnImage = pawn.getPawnImage();
        list.addToUserMovesList(pawnImage);
        if(indexOfCurrentField + diceRoll <= movementList.size()) {
            grid.add(pawnImage, movementList.get(indexOfCurrentField + diceRoll).getColumn(), movementList.get(indexOfCurrentField + diceRoll).getRow());
            pawn.setNewPosition(movementList.get(indexOfCurrentField + diceRoll));
            pawn.getCurrentField().changeFieldStatus();
        } else {
            grid.add(pawnImage, movementList.get(movementList.size()-1).getColumn(), movementList.get(movementList.size()-1).getRow());
            pawn.setNewPosition(movementList.get(movementList.size()-1));
            pawn.getCurrentField().changeFieldStatus();
            movementList.remove(movementList.size()-1);
        }
    }
}
