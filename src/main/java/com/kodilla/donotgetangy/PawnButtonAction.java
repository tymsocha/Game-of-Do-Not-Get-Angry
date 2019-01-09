package com.kodilla.donotgetangy;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.util.List;
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

        int computerPawnChoice = new Random().nextInt(4) + 1;
        Pawn pawnChosenByComputer;
        UserMovesList computerMovementsList;
        if (computerPawnChoice == 1) {
            pawnChosenByComputer = computerPawnsList.get(computerPawnChoice);
            computerMovementsList =  computerPawnMovesListOne;
            computerPawnChoiceTextBox.setText("");
            computerPawnChoiceTextBox.setText("Pawn nr 1");
        } else if (computerPawnChoice == 2) {
            pawnChosenByComputer = computerPawnsList.get(computerPawnChoice);
            computerMovementsList = computerPawnMovesListTwo;
            computerPawnChoiceTextBox.setText("");
            computerPawnChoiceTextBox.setText("Pawn nr 2");
        } else if (computerPawnChoice == 3) {
            pawnChosenByComputer = computerPawnsList.get(computerPawnChoice);
            computerMovementsList = computerPawnMovesListThree;
            computerPawnChoiceTextBox.setText("");
            computerPawnChoiceTextBox.setText("Pawn nr 3");
        } else {
            pawnChosenByComputer = computerPawnsList.get(computerPawnChoice);
            computerMovementsList = computerPawnMovesListFour;
            computerPawnChoiceTextBox.setText("");
            computerPawnChoiceTextBox.setText("Pawn nr 4");
        }

        Movement.moveThePawn(grid, pawnChosenByComputer,computerDiceRoll,computerMovementsList, MapOfComputerFields.getListOfUserMovements());
    }

    public static void removeMenu(GridPane grid, Node... node) {
        grid.getChildren().removeAll(node);
    }

    private static int checkComputerPawnStatusAndChangePawnChoice(int computerPawnChoice, Pawn pawnChosenByComputer) {
        boolean leaveTheLoop = true;
        int newComputerPawnChoice = 0;
        while (leaveTheLoop) {
            if (pawnChosenByComputer.getActivationStatus() == true) {
                newComputerPawnChoice = computerPawnChoice;
                leaveTheLoop = false;
            } else if (pawnChosenByComputer.getActivationStatus() == false && computerPawnChoice < 4) {
                newComputerPawnChoice = computerPawnChoice + 1;
                leaveTheLoop = false;
            } else if (pawnChosenByComputer.getActivationStatus() == false && computerPawnChoice == 4) {
                newComputerPawnChoice = 0;
                leaveTheLoop = false;
            } else {
                leaveTheLoop = false;
            }
        }
        return newComputerPawnChoice;
    }
}
