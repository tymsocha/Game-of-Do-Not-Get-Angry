package com.kodilla.donotgetangy;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import java.util.ArrayList;
import java.util.List;


public class Board {
    public void setBoard (GridPane grid, PawnColor pawnColor, PawnColor computerColor) {
        PawnStorage pawnStorage = new PawnStorage();

        Pawn userPawnOne = pawnStorage.getUserPawn(pawnColor, 1);
        Pawn userPawnTwo = pawnStorage.getUserPawn(pawnColor, 2);
        Pawn userPawnThree = pawnStorage.getUserPawn(pawnColor, 3);
        Pawn userPawnFour = pawnStorage.getUserPawn(pawnColor, 4);

        Pawn computerPawnOne = pawnStorage.getUserPawn(computerColor, 1);
        Pawn computerPawnTwo = pawnStorage.getUserPawn(computerColor, 2);
        Pawn computerPawnThree = pawnStorage.getUserPawn(computerColor, 3);
        Pawn computerPawnFour = pawnStorage.getUserPawn(computerColor, 4);

        ImageView userPawn1Image = userPawnOne.getPawnImage();
        ImageView userPawn2Image = userPawnTwo.getPawnImage();
        ImageView userPawn3Image = userPawnThree.getPawnImage();
        ImageView userPawn4Image = userPawnFour.getPawnImage();

        ImageView computerPawn1Image = computerPawnOne.getPawnImage();
        ImageView computerPawn2Image = computerPawnTwo.getPawnImage();
        ImageView computerPawn3Image = computerPawnThree.getPawnImage();
        ImageView computerPawn4Image = computerPawnFour.getPawnImage();

        grid.add(computerPawn1Image,9, 0);
        UserMovesList computerPawnOneMovementsList = new UserMovesList();
        computerPawnOneMovementsList.addToUserMovesList(computerPawn1Image);

        grid.add(computerPawn2Image,10,0);
        UserMovesList computerPawnTwoMovementsList = new UserMovesList();
        computerPawnTwoMovementsList.addToUserMovesList(computerPawn2Image);

        grid.add(computerPawn3Image, 9,1);
        UserMovesList computerPawnThreeMovementsList = new UserMovesList();
        computerPawnThreeMovementsList.addToUserMovesList(computerPawn3Image);

        grid.add(computerPawn4Image,10,1);
        UserMovesList computerPawnFourMovementsList = new UserMovesList();
        computerPawnFourMovementsList.addToUserMovesList(computerPawn4Image);

        List<Pawn> computersPawnsList = new ArrayList<>();
        computersPawnsList.add(0,computerPawnOne);
        computersPawnsList.add(1,computerPawnTwo);
        computersPawnsList.add(2,computerPawnThree);
        computersPawnsList.add(3,computerPawnFour);

        grid.add(userPawn1Image, 0,9);
        UserMovesList userPawnOneMovementsList = new UserMovesList();
        userPawnOneMovementsList.addToUserMovesList(userPawn1Image);

        grid.add(userPawn2Image,1,9);
        UserMovesList userPawnTwoMovementsList = new UserMovesList();
        userPawnTwoMovementsList.addToUserMovesList(userPawn2Image);

        grid.add(userPawn3Image,0,10);
        UserMovesList userPawnThreeMovementsList = new UserMovesList();
        userPawnThreeMovementsList.addToUserMovesList(userPawn3Image);

        grid.add(userPawn4Image, 1,10);
        UserMovesList userPawnFourMovementsList = new UserMovesList();
        userPawnFourMovementsList.addToUserMovesList(userPawn4Image);

        Button rollTheDice = new Button();
        rollTheDice.setPadding(new Insets(10));
        rollTheDice.setText("Roll");
        grid.add(rollTheDice,12,2);

        TextField showDiceRoll = new TextField();
        grid.add(showDiceRoll,13,2);

        Label chooseThePawn = new Label();
        chooseThePawn.setText("Choose the Pawn you want to move:");
        chooseThePawn.setMinSize(1000,10);

        Button pawnNrOne = new Button();
        pawnNrOne.setBackground(SetBackGround.setNewBackground(pawnStorage.getPawnImage(pawnColor,1)));
        pawnNrOne.setMinSize(63,59);

        Button pawnNrTwo = new Button();
        pawnNrTwo.setBackground(SetBackGround.setNewBackground(pawnStorage.getPawnImage(pawnColor,2)));
        pawnNrTwo.setMinSize(63,59);

        Button pawnNrThree = new Button();
        pawnNrThree.setBackground(SetBackGround.setNewBackground(pawnStorage.getPawnImage(pawnColor,3)));
        pawnNrThree.setMinSize(63,59);

        Button pawnNrFour = new Button();
        pawnNrFour.setBackground(SetBackGround.setNewBackground(pawnStorage.getPawnImage(pawnColor,4)));
        pawnNrFour.setMinSize(63,59);

        Button endTurn = new Button();
        endTurn.setText("End Turn");
        endTurn.setMinSize(100,20);
        grid.add(endTurn, 12,8);


        rollTheDice.setOnAction(event -> {
            this.removeMenu(grid, pawnNrOne, pawnNrTwo, pawnNrThree, pawnNrFour, chooseThePawn);
            showDiceRoll.setText("");
            int diceRoll = DiceRoll.rollTheDice();
            showDiceRoll.setText(Integer.toString(diceRoll));

            grid.add(chooseThePawn, 11,3);
            grid.add(pawnNrOne, 11,4);
            grid.add(pawnNrTwo, 12,4);
            grid.add(pawnNrThree, 13,4);
            grid.add(pawnNrFour, 14,4);

            pawnNrOne.setOnAction(event1 -> {
                try {
                    Movement.moveThePawn(grid, userPawnOne, diceRoll, userPawnOneMovementsList, MapOfUserFields.getListOfUserMovements());
                    PawnButtonAction.moveComputerPawn(grid, computerPawnOneMovementsList, computerPawnTwoMovementsList, computerPawnThreeMovementsList, computerPawnFourMovementsList, computersPawnsList);
                } catch (IndexOutOfBoundsException e) {
                    Movement.showMessageThatPawnCannotMove();
                }
                });

            pawnNrTwo.setOnAction(event1 -> {
                try {
                    Movement.moveThePawn(grid, userPawnTwo, diceRoll, userPawnTwoMovementsList, MapOfUserFields.getListOfUserMovements());
                    PawnButtonAction.moveComputerPawn(grid, computerPawnOneMovementsList, computerPawnTwoMovementsList, computerPawnThreeMovementsList, computerPawnFourMovementsList, computersPawnsList);
                } catch (IndexOutOfBoundsException e) {
                    Movement.showMessageThatPawnCannotMove();
                }
            });

            pawnNrThree.setOnAction(event1 -> {
                try {
                    Movement.moveThePawn(grid, userPawnThree, diceRoll, userPawnThreeMovementsList, MapOfUserFields.getListOfUserMovements());
                    PawnButtonAction.moveComputerPawn(grid, computerPawnOneMovementsList, computerPawnTwoMovementsList, computerPawnThreeMovementsList, computerPawnFourMovementsList, computersPawnsList);
                } catch (IndexOutOfBoundsException e) {
                    Movement.showMessageThatPawnCannotMove();
                }
            });

            pawnNrFour.setOnAction(event1 -> {
                try {
                    Movement.moveThePawn(grid, userPawnFour, diceRoll, userPawnFourMovementsList, MapOfUserFields.getListOfUserMovements());
                    PawnButtonAction.moveComputerPawn(grid, computerPawnOneMovementsList, computerPawnTwoMovementsList, computerPawnThreeMovementsList, computerPawnFourMovementsList, computersPawnsList);
                } catch (IndexOutOfBoundsException e) {
                    Movement.showMessageThatPawnCannotMove();
                }
            });
        });

        endTurn.setOnAction(event -> {
            PawnButtonAction.moveComputerPawn(grid, computerPawnOneMovementsList, computerPawnTwoMovementsList, computerPawnThreeMovementsList, computerPawnFourMovementsList, computersPawnsList);
        });
    }

    public void removeMenu(GridPane grid, Node... node) {
        grid.getChildren().removeAll(node);
    }
}
