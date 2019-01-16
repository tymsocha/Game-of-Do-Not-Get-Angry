package com.kodilla.donotgetangy;

import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public class PawnButtonAction {
    private static final Label computerRoll = new Label();
    private static final TextField showComputerRoll = new TextField();
    private static final Label computerPawnChoiceLabel = new Label();
    private static final TextField computerPawnChoiceTextBox = new TextField();

    public static void moveComputerPawn(GridPane grid, UserMovesList computerPawnMovesListOne, UserMovesList computerPawnMovesListTwo, UserMovesList computerPawnMovesListThree, UserMovesList computerPawnMovesListFour, List<Pawn> computerPawnsList) {
        removeMenu(grid, computerRoll, showComputerRoll, computerPawnChoiceLabel, computerPawnChoiceTextBox);

        computerRoll.setText("Computer rolled:");
        computerRoll.setMinSize(1000,10);
        computerPawnChoiceLabel.setText("Computer chose:");
        computerPawnChoiceLabel.setMinSize(1000,10);
        computerPawnChoiceTextBox.setMinSize(100,10);

        grid.add(computerRoll, 11, 5);

        grid.add(computerPawnChoiceLabel,11,6);
        grid.add(computerPawnChoiceTextBox,13,6);

        grid.add(showComputerRoll,13,5);
        showComputerRoll.setText("");
        int computerDiceRoll = DiceRoll.rollTheDice();
        showComputerRoll.setText(Integer.toString(computerDiceRoll));

        int computerPawnChoice = new Random().nextInt(4);
        Pawn pawnChosenByComputer;
        UserMovesList computerMovementsList;
        if ((computerDiceRoll == 1 || computerDiceRoll == 6 || computerPawnsList.get(computerPawnChoice).getActivationStatus())) {
            if (!computerPawnsList.get(computerPawnChoice).getActivationStatus()) {
                computerPawnsList.get(computerPawnChoice).changeActivationStatus();
            }
            if (computerPawnChoice == 0 && computerPawnsList.get(computerPawnChoice).getActivationStatus()) {
                pawnChosenByComputer = computerPawnsList.get(computerPawnChoice);
                computerMovementsList =  computerPawnMovesListOne;
                computerPawnChoiceTextBox.setText("");
                computerPawnChoiceTextBox.setText("Pawn nr 1");
                Movement.moveThePawn(grid, pawnChosenByComputer,computerDiceRoll,computerMovementsList, MapOfComputerFields.getListOfUserMovements());
            } else if (computerPawnChoice == 1 && computerPawnsList.get(computerPawnChoice).getActivationStatus()) {
                pawnChosenByComputer = computerPawnsList.get(computerPawnChoice);
                computerMovementsList = computerPawnMovesListTwo;
                computerPawnChoiceTextBox.setText("");
                computerPawnChoiceTextBox.setText("Pawn nr 2");
                Movement.moveThePawn(grid, pawnChosenByComputer,computerDiceRoll,computerMovementsList, MapOfComputerFields.getListOfUserMovements());
            } else if (computerPawnChoice == 2 && computerPawnsList.get(computerPawnChoice).getActivationStatus()) {
                pawnChosenByComputer = computerPawnsList.get(computerPawnChoice);
                computerMovementsList = computerPawnMovesListThree;
                computerPawnChoiceTextBox.setText("");
                computerPawnChoiceTextBox.setText("Pawn nr 3");
                Movement.moveThePawn(grid, pawnChosenByComputer,computerDiceRoll,computerMovementsList, MapOfComputerFields.getListOfUserMovements());
            } else if (computerPawnChoice == 3 && computerPawnsList.get(computerPawnChoice).getActivationStatus()) {
                pawnChosenByComputer = computerPawnsList.get(computerPawnChoice);
                computerMovementsList = computerPawnMovesListFour;
                computerPawnChoiceTextBox.setText("");
                computerPawnChoiceTextBox.setText("Pawn nr 4");
                Movement.moveThePawn(grid, pawnChosenByComputer, computerDiceRoll, computerMovementsList, MapOfComputerFields.getListOfUserMovements());
            }
        } else if (!computerPawnsList.get(computerPawnChoice).getActivationStatus() && !(computerDiceRoll == 1 || computerDiceRoll == 6)) {
            pawnChosenByComputer = computerPawnsList.stream()
                    .filter(pawn -> pawn.getActivationStatus() == true)
                    .findFirst()
                    .get();
            if (pawnChosenByComputer.equals(computerPawnsList.get(0))) {
                computerMovementsList = computerPawnMovesListOne;
                computerPawnChoiceTextBox.setText("");
                computerPawnChoiceTextBox.setText("Pawn nr 1");
            } else if (pawnChosenByComputer.equals(computerPawnsList.get(1))) {
                computerMovementsList = computerPawnMovesListTwo;
                computerPawnChoiceTextBox.setText("");
                computerPawnChoiceTextBox.setText("Pawn nr 2");
            } else if (pawnChosenByComputer.equals(computerPawnsList.get(2))) {
                computerMovementsList = computerPawnMovesListThree;
                computerPawnChoiceTextBox.setText("");
                computerPawnChoiceTextBox.setText("Pawn nr 3");
            } else {
                computerMovementsList = computerPawnMovesListFour;
                computerPawnChoiceTextBox.setText("");
                computerPawnChoiceTextBox.setText("Pawn nr 4");
            }
            Movement.moveThePawn(grid, pawnChosenByComputer,computerDiceRoll,computerMovementsList, MapOfComputerFields.getListOfUserMovements());
        } else throw new NoSuchElementException();

    }

    public static void removeMenu(GridPane grid, Node... node) {
        grid.getChildren().removeAll(node);
    }


    public static void showMessageThatComputerPawnCannotMove() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("COMPUTER HAS NO ACTIVE PAWNS");
        alert.setHeaderText("Computer cannot move any pawn");
        alert.setContentText("Your turn");
        alert.showAndWait();
    }
}
