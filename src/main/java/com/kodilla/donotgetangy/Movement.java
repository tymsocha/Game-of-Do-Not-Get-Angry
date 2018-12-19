package com.kodilla.donotgetangy;

import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.util.List;

public class Movement {
    public static void moveThePawn(GridPane grid, Pawn pawn, int diceRoll) {
        List<Field> movementList = MapOfUserFields.getListOfUserMovements();
        Field pawnCurrentField = pawn.getCurrentField();
        int indexOfCurrentField = 0;
        for(int i = 0; i < movementList.size(); i++ ) {
            if(pawnCurrentField == movementList.get(i)) {
                indexOfCurrentField = i;
            }
        }
        grid.getChildren().remove(UserMovesList.getUserMovesList().get(UserMovesList.getUserMovesList().size() - 1));
        ImageView pawnImage = pawn.getPawnImage();
        UserMovesList.addToUserMovesList(pawnImage);
        grid.add(pawnImage, movementList.get(indexOfCurrentField + diceRoll).getColumn(), movementList.get(indexOfCurrentField + diceRoll).getRow());
        pawn.setNewPosition(movementList.get(indexOfCurrentField + diceRoll));
    }
}
