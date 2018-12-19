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
        ImageView pawnImage = pawn.getPawnImage();
        list.addToUserMovesList(pawnImage);
        grid.add(pawnImage, movementList.get(indexOfCurrentField + diceRoll).getColumn(), movementList.get(indexOfCurrentField + diceRoll).getRow());
        pawn.setNewPosition(movementList.get(indexOfCurrentField + diceRoll));
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
        ImageView pawnImage = pawn.getPawnImage();
        list.addToUserMovesList(pawnImage);
        grid.add(pawnImage, movementList.get(indexOfCurrentField + diceRoll).getColumn(), movementList.get(indexOfCurrentField + diceRoll).getRow());
        pawn.setNewPosition(movementList.get(indexOfCurrentField + diceRoll));
    }
}
