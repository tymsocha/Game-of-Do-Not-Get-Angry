package com.kodilla.donotgetangy;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.util.List;

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

        grid.add(bluePawn1.getPawnImage(), 9, 0);
        grid.add(bluePawn2.getPawnImage(),10,0);
        grid.add(bluePawn3.getPawnImage(), 9,1);
        grid.add(bluePawn4.getPawnImage(),10,1);


        grid.add(yellowPawn1Image, 0,9);
        UserMovesList.addToUserMovesList(yellowPawn1Image);
        grid.add(yellowPawn2Image,1,9);
        grid.add(yellowPawn3Image,0,10);
        grid.add(yellowPawn4Image, 1,10);

        Button rollTheDice = new Button();
        rollTheDice.setPadding(new Insets(10));
        rollTheDice.setText("Roll");
        grid.add(rollTheDice,12,2);

        TextField showDiceRoll = new TextField();
        grid.add(showDiceRoll,13,2);

        rollTheDice.setOnAction(event -> {
            showDiceRoll.setText("");
            int diceRoll = DiceRoll.rollTheDice();
            showDiceRoll.setText(Integer.toString(diceRoll));

            Label chooseThePawn = new Label();
            chooseThePawn.setText("Choose the Pawn you want to move:");
            chooseThePawn.setMinSize(1000,10);
            grid.add(chooseThePawn, 11,3);

            Button pawnNrOne = new Button();
            pawnNrOne.setBackground(SetBackGround.setNewBackground(yellowOne));
            pawnNrOne.setMinSize(63,59);
            grid.add(pawnNrOne, 11,4);

            Button pawnNrTwo = new Button();
            pawnNrTwo.setBackground(SetBackGround.setNewBackground(yellowTwo));
            pawnNrTwo.setMinSize(63,59);
            grid.add(pawnNrTwo, 12,4);

            Button pawnNrThree = new Button();
            pawnNrThree.setBackground(SetBackGround.setNewBackground(yellowThree));
            pawnNrThree.setMinSize(63,59);
            grid.add(pawnNrThree, 13,4);

            Button pawnNrFour = new Button();
            pawnNrFour.setBackground(SetBackGround.setNewBackground(yellowFour));
            pawnNrFour.setMinSize(63,59);
            grid.add(pawnNrFour, 14,4);

            pawnNrOne.setOnAction(event1 -> {
                Movement.moveThePawn(grid, yellowPawn1, diceRoll);
                this.removeMenu(grid, pawnNrOne);
                this.removeMenu(grid, pawnNrTwo);
                this.removeMenu(grid, pawnNrThree);
                this.removeMenu(grid, pawnNrFour);
                this.removeMenu(grid, chooseThePawn);
            });

            pawnNrTwo.setOnAction(event2 -> Movement.moveThePawn(grid, yellowPawn2, diceRoll));


        });

    }

    public void removeMenu(GridPane grid, Node node) {
        grid.getChildren().remove(node);
    }
}
