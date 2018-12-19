package com.kodilla.donotgetangy;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Board {

    private static Image yellowOne = new Image("file:E:/Dokumenty/Kodilla/Kodilla-Projects/do-not-get-angy/src/main/images/YellowOne.jpg");
    private Image yellowTwo = new Image("file:E:/Dokumenty/Kodilla/Kodilla-Projects/do-not-get-angy/src/main/images/YellowTwo.jpg");
    private Image yellowThree = new Image("file:E:/Dokumenty/Kodilla/Kodilla-Projects/do-not-get-angy/src/main/images/YellowThree.jpg");
    private Image yellowFour = new Image("file:E:/Dokumenty/Kodilla/Kodilla-Projects/do-not-get-angy/src/main/images/YellowFour.jpg");

    private Image blueOne = new Image("file:E:/Dokumenty/Kodilla/Kodilla-Projects/do-not-get-angy/src/main/images/BlueOne.jpg");
    private Image blueTwo = new Image("file:E:/Dokumenty/Kodilla/Kodilla-Projects/do-not-get-angy/src/main/images/BlueTwo.jpg");
    private Image blueThree = new Image("file:E:/Dokumenty/Kodilla/Kodilla-Projects/do-not-get-angy/src/main/images/BlueThree.jpg");
    private Image blueFour = new Image("file:E:/Dokumenty/Kodilla/Kodilla-Projects/do-not-get-angy/src/main/images/BlueFour.jpg");

    private Image redOne = new Image("file:E:/Dokumenty/Kodilla/Kodilla-Projects/do-not-get-angy/src/main/images/RedOne.jpg");
    private Image redTwo = new Image("file:E:/Dokumenty/Kodilla/Kodilla-Projects/do-not-get-angy/src/main/images/RedTwo.jpg");
    private Image redThree = new Image("file:E:/Dokumenty/Kodilla/Kodilla-Projects/do-not-get-angy/src/main/images/RedThree.jpg");
    private Image redFour = new Image("file:E:/Dokumenty/Kodilla/Kodilla-Projects/do-not-get-angy/src/main/images/RedFour.jpg");

    private Image greenOne = new Image("file:E:/Dokumenty/Kodilla/Kodilla-Projects/do-not-get-angy/src/main/images/GreenOne.jpg");
    private Image greenTwo = new Image("file:E:/Dokumenty/Kodilla/Kodilla-Projects/do-not-get-angy/src/main/images/GreenTwo.jpg");
    private Image greenThree = new Image("file:E:/Dokumenty/Kodilla/Kodilla-Projects/do-not-get-angy/src/main/images/GreenThree.jpg");
    private Image greenFour = new Image("file:E:/Dokumenty/Kodilla/Kodilla-Projects/do-not-get-angy/src/main/images/GreenFour.jpg");

    private Pawn bluePawn1 = new BluePawn(new Field(9,0), blueOne);
    private Pawn bluePawn2 = new BluePawn(new Field(10,0), blueTwo);
    private Pawn bluePawn3 = new BluePawn(new Field(9,1), blueThree);
    private Pawn bluePawn4 = new BluePawn(new Field(10,1), blueFour);

    private Pawn yellowPawn1 = new YellowPawn(new Field(0, 9), yellowOne);
    private Pawn yellowPawn2 = new YellowPawn(new Field(1, 9), yellowTwo);
    private Pawn yellowPawn3 = new YellowPawn(new Field(0,10), yellowThree);
    private Pawn yellowPawn4 = new YellowPawn(new Field(1,10), yellowFour);

    public void setBoard (GridPane grid) {
        for (int i = 0; i < 11; i++){
            grid.getColumnConstraints().add(new ColumnConstraints(59));
            grid.getRowConstraints().add(new RowConstraints(59));
        }
        for (int i = 0; i < 4; i++) {
            grid.getColumnConstraints().add(new ColumnConstraints(63));
        }

        ImageView yellowPawn1Image = yellowPawn1.getPawnImage();
        ImageView yellowPawn2Image = yellowPawn2.getPawnImage();
        ImageView yellowPawn3Image = yellowPawn3.getPawnImage();
        ImageView yellowPawn4Image = yellowPawn4.getPawnImage();

        ImageView bluePawn1Image = bluePawn1.getPawnImage();
        ImageView bluePawn2Image = bluePawn2.getPawnImage();
        ImageView bluePawn3Image = bluePawn3.getPawnImage();
        ImageView bluePawn4Image = bluePawn4.getPawnImage();

        grid.add(bluePawn1Image,9, 0);
        UserMovesList bluePawnOneMovementsList = new UserMovesList();
        bluePawnOneMovementsList.addToUserMovesList(bluePawn1Image);

        grid.add(bluePawn2Image,10,0);
        UserMovesList bluePawnTwoMovementsList = new UserMovesList();
        bluePawnTwoMovementsList.addToUserMovesList(bluePawn2Image);

        grid.add(bluePawn3Image, 9,1);
        UserMovesList bluePawnThreeMovementsList = new UserMovesList();
        bluePawnThreeMovementsList.addToUserMovesList(bluePawn3Image);

        grid.add(bluePawn4Image,10,1);
        UserMovesList bluePawnFourMovementsList = new UserMovesList();
        bluePawnFourMovementsList.addToUserMovesList(bluePawn4Image);

        List<Pawn> computersPawnsList = new ArrayList<>();
        computersPawnsList.add(0,bluePawn1);
        computersPawnsList.add(1,bluePawn2);
        computersPawnsList.add(2,bluePawn3);
        computersPawnsList.add(3,bluePawn4);

        grid.add(yellowPawn1Image, 0,9);
        UserMovesList yellowPawnOneMovementsList = new UserMovesList();
        yellowPawnOneMovementsList.addToUserMovesList(yellowPawn1Image);

        grid.add(yellowPawn2Image,1,9);
        UserMovesList yellowPawnTwoMovementsList = new UserMovesList();
        yellowPawnTwoMovementsList.addToUserMovesList(yellowPawn2Image);

        grid.add(yellowPawn3Image,0,10);
        UserMovesList yellowPawnThreeMovementsList = new UserMovesList();
        yellowPawnThreeMovementsList.addToUserMovesList(yellowPawn3Image);

        grid.add(yellowPawn4Image, 1,10);
        UserMovesList yellowPawnFourMovementsList = new UserMovesList();
        yellowPawnFourMovementsList.addToUserMovesList(yellowPawn4Image);

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
        pawnNrOne.setBackground(SetBackGround.setNewBackground(yellowOne));
        pawnNrOne.setMinSize(63,59);

        Button pawnNrTwo = new Button();
        pawnNrTwo.setBackground(SetBackGround.setNewBackground(yellowTwo));
        pawnNrTwo.setMinSize(63,59);

        Button pawnNrThree = new Button();
        pawnNrThree.setBackground(SetBackGround.setNewBackground(yellowThree));
        pawnNrThree.setMinSize(63,59);

        Button pawnNrFour = new Button();
        pawnNrFour.setBackground(SetBackGround.setNewBackground(yellowFour));
        pawnNrFour.setMinSize(63,59);

        Label computerRoll = new Label();
        computerRoll.setText("Computer rolled:");
        computerRoll.setMinSize(1000,10);

        TextField showComputerRoll = new TextField();

        Label computerPawnChoiceLabel = new Label();
        computerPawnChoiceLabel.setText("Computer chose:");
        computerPawnChoiceLabel.setMinSize(1000,10);

        TextField computerPawnChoiceTextBox = new TextField();
        computerPawnChoiceTextBox.setMinSize(100,10);

        rollTheDice.setOnAction(event -> {
            this.removeMenu(grid, pawnNrOne, pawnNrTwo, pawnNrThree, pawnNrFour, chooseThePawn, computerRoll, showComputerRoll, computerPawnChoiceLabel, computerPawnChoiceTextBox);
            showDiceRoll.setText("");
            int diceRoll = DiceRoll.rollTheDice();
            showDiceRoll.setText(Integer.toString(diceRoll));

            grid.add(chooseThePawn, 11,3);
            grid.add(pawnNrOne, 11,4);
            grid.add(pawnNrTwo, 12,4);
            grid.add(pawnNrThree, 13,4);
            grid.add(pawnNrFour, 14,4);

            pawnNrOne.setOnAction(event1 -> {
                Movement.moveTheUserPawn(grid, yellowPawn1, diceRoll, yellowPawnOneMovementsList);

                grid.add(computerRoll, 11, 5);

                grid.add(showComputerRoll,13,5);
                showComputerRoll.setText("");
                int computerDiceRoll = DiceRoll.rollTheDice();
                showComputerRoll.setText(Integer.toString(computerDiceRoll));

                grid.add(computerPawnChoiceLabel,11,6);
                grid.add(computerPawnChoiceTextBox,13,6);

                int computerPawnChoice = new Random().nextInt(4);
                Pawn pawnChosenByComputer;
                UserMovesList computerMovementsList;
                if (computerPawnChoice == 0) {
                    pawnChosenByComputer = computersPawnsList.get(computerPawnChoice);
                    computerMovementsList = bluePawnOneMovementsList;
                    computerPawnChoiceTextBox.setText("");
                    computerPawnChoiceTextBox.setText("Pawn nr 1");
                } else if (computerPawnChoice == 1) {
                    pawnChosenByComputer = computersPawnsList.get(computerPawnChoice);
                    computerMovementsList = bluePawnTwoMovementsList;
                    computerPawnChoiceTextBox.setText("");
                    computerPawnChoiceTextBox.setText("Pawn nr 2");
                } else if (computerPawnChoice == 2) {
                    pawnChosenByComputer = computersPawnsList.get(computerPawnChoice);
                    computerMovementsList = bluePawnThreeMovementsList;
                    computerPawnChoiceTextBox.setText("");
                    computerPawnChoiceTextBox.setText("Pawn nr 3");
                } else {
                    pawnChosenByComputer = computersPawnsList.get(computerPawnChoice);
                    computerMovementsList = bluePawnFourMovementsList;
                    computerPawnChoiceTextBox.setText("");
                    computerPawnChoiceTextBox.setText("Pawn nr 4");
                }

                Movement.moveTheComputerPawn(grid, pawnChosenByComputer,computerDiceRoll,computerMovementsList);
            });

           pawnNrTwo.setOnAction(event1 -> {
                Movement.moveTheUserPawn(grid, yellowPawn2, diceRoll, yellowPawnTwoMovementsList);
                this.removeMenu(grid, pawnNrOne, pawnNrTwo, pawnNrThree, pawnNrFour, chooseThePawn);
            });

           pawnNrThree.setOnAction(event1 -> {
               Movement.moveTheUserPawn(grid, yellowPawn3, diceRoll, yellowPawnThreeMovementsList);
               this.removeMenu(grid, pawnNrOne, pawnNrTwo, pawnNrThree, pawnNrFour, chooseThePawn);
           });

           pawnNrFour.setOnAction(event1 -> {
               Movement.moveTheUserPawn(grid, yellowPawn4, diceRoll, yellowPawnFourMovementsList);
               this.removeMenu(grid, pawnNrOne, pawnNrTwo, pawnNrThree, pawnNrFour, chooseThePawn);
           });

        });

    }

    public void removeMenu(GridPane grid, Node... node) {
        grid.getChildren().removeAll(node);
    }
}
