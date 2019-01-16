package com.kodilla.donotgetangy;

import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class Movement {
    public static void moveThePawn(GridPane grid, Pawn pawn, int diceRoll, UserMovesList list, ArrayList<Field> mapOfMovements) {
        Field pawnCurrentField = pawn.getCurrentField();

        if(pawn.getActivationStatus() == true && mapOfMovements.contains(pawnCurrentField) && !pawn.getFinishStatus()) {
            int indexOfCurrentField = MapOfUserFields.getIndexOfCurrentField(mapOfMovements, pawnCurrentField);
            ImageView pawnImage = removePawnImageFromTheBoard(grid, list, pawn, pawnCurrentField);

            if (indexOfCurrentField + diceRoll <= mapOfMovements.size() - 1) {
                addPawnOnBoardInNewPosition(grid, pawnImage, mapOfMovements, indexOfCurrentField, diceRoll, pawn);
            } else {
                addPawnOnTheLastAvailableFinishingField(grid, pawnImage, mapOfMovements, pawn);
            }

        } else if ((!pawn.getActivationStatus() && (diceRoll == 1 || diceRoll ==6) && !pawn.getFinishStatus()) || (!mapOfMovements.contains(pawnCurrentField) && !pawn.getFinishStatus())) {
            tryToChangeActivationStatus(pawn, diceRoll);
            ImageView pawnImage = removePawnImageFromTheBoard(grid, list, pawn, pawnCurrentField);
            addPawnOnBoardInStartPosition(grid, pawnImage, mapOfMovements, pawn);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    private static void tryToChangeActivationStatus(Pawn pawn, int diceRoll) {
        if (pawn.getActivationStatus() == false) {
            if (diceRoll == 1 || diceRoll == 6) {
                pawn.changeActivationStatus();
            }
        }
    }

    private static ImageView removePawnImageFromTheBoard(GridPane grid, UserMovesList list, Pawn pawn, Field pawnCurrentField) {
        grid.getChildren().remove(list.getUserMovesList().get(list.getUserMovesList().size() - 1));
        pawnCurrentField.changeFieldStatus();
        ImageView pawnImage = pawn.getPawnImage();
        list.addToUserMovesList(pawnImage);
        return pawnImage;
    }

    private static void addPawnOnBoardInNewPosition(GridPane grid, ImageView pawnImage, ArrayList<Field> movementList, int indexOfCurrentField, int diceRoll, Pawn pawn) {
        grid.add(pawnImage, movementList.get(indexOfCurrentField + diceRoll).getColumn(), movementList.get(indexOfCurrentField + diceRoll).getRow());
        pawn.setNewPosition(movementList.get(indexOfCurrentField + diceRoll));
        pawn.getCurrentField().changeFieldStatus();
    }

    private static void addPawnOnBoardInStartPosition(GridPane grid, ImageView pawnImage, ArrayList<Field> movementList, Pawn pawn) {
        grid.add(pawnImage, movementList.get(0).getColumn(), movementList.get(0).getRow());
        pawn.setNewPosition(movementList.get(0));
        pawn.getCurrentField().changeFieldStatus();
    }

    private static void addPawnOnTheLastAvailableFinishingField(GridPane grid, ImageView pawnImage, ArrayList<Field> mapOfMovements, Pawn pawn) {
        grid.add(pawnImage, mapOfMovements.get(mapOfMovements.size() - 1).getColumn(), mapOfMovements.get(mapOfMovements.size() - 1).getRow());
        pawn.setNewPosition(mapOfMovements.get(mapOfMovements.size() - 1));
        pawn.getCurrentField().changeFieldStatus();
        mapOfMovements.remove(mapOfMovements.size() - 1);
        pawn.changeActivationStatus();
        pawn.changeFinishStatus();
    }

    public static void showMessageThatPawnCannotMove() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("WRONG CHOICE");
        alert.setHeaderText("This Pawn Cannot Be Moved");
        alert.setContentText("Choose another pawn or end turn");
        alert.showAndWait();
    }
}
