package com.kodilla.donotgetangy;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;

public class ChoiceOfPawnColor {
    private static final Label chooseColor = new Label();
    private static final Button redChoice = new Button();
    private static final Button blueChoice = new Button();
    private static final Button greenChoice = new Button();
    private static final Button yellowChoice = new Button();
    private static PawnColor color;
    private static PawnColor computerColor;

    public static void putChoosingColorButtonsOnTheGrid(GridPane grid) {
        chooseColor.setText("Choose your Pawns color");
        chooseColor.setMinSize(1000,10);
        grid.add(chooseColor, 11,0);

        redChoice.setTextFill(Color.RED);
        redChoice.setText("RED");
        grid.add(redChoice, 11, 1);

        blueChoice.setTextFill(Color.BLUE);
        blueChoice.setText("BLUE");
        grid.add(blueChoice, 12, 1);

        greenChoice.setTextFill(Color.GREEN);
        greenChoice.setText("GREEN");
        grid.add(greenChoice, 13, 1);

        yellowChoice.setTextFill(Color.YELLOW);
        yellowChoice.setText("YELLOW");
        grid.add(yellowChoice, 14, 1);
    }

    public static void choosePawnColor(GridPane grid) {
        for (int i = 0; i < 10; i++){
            grid.getColumnConstraints().add(new ColumnConstraints(55));
            grid.getRowConstraints().add(new RowConstraints(55));
        }
        for (int i = 0; i < 4; i++) {
            grid.getColumnConstraints().add(new ColumnConstraints(70));
        }
        blueChoice.setOnAction(event -> {
            color = PawnColor.BLUE;
            computerColor = PawnColor.YELLOW;
            removeMenu(grid, chooseColor, redChoice, greenChoice, blueChoice, yellowChoice);
            grid.setBackground(SetBackGround.setNewBackground(PawnStorage.getBoardBlue()));
            Board board = new Board();
            board.setBoard(grid, color, computerColor);
        });
        greenChoice.setOnAction(event -> {
            color = PawnColor.GREEN;
            computerColor = PawnColor.RED;
            removeMenu(grid, chooseColor, redChoice, greenChoice, blueChoice, yellowChoice);
            grid.setBackground(SetBackGround.setNewBackground(PawnStorage.getBoardGreen()));
            Board board = new Board();
            board.setBoard(grid, color, computerColor);
        });
        redChoice.setOnAction(event -> {
            color = PawnColor.RED;
            computerColor = PawnColor.GREEN;
            removeMenu(grid, chooseColor, redChoice, greenChoice, blueChoice, yellowChoice);
            grid.setBackground(SetBackGround.setNewBackground(PawnStorage.getBoardRed()));
            Board board = new Board();
            board.setBoard(grid, color, computerColor);
        });
        yellowChoice.setOnAction(event -> {
            color = PawnColor.YELLOW;
            computerColor = PawnColor.BLUE;
            removeMenu(grid, chooseColor, redChoice, greenChoice, blueChoice, yellowChoice);
            grid.setBackground(SetBackGround.setNewBackground(PawnStorage.getBoardYellow()));
            Board board = new Board();
            board.setBoard(grid, color, computerColor);
        });
    }

    public static void removeMenu(GridPane grid, Node... node) {
        grid.getChildren().removeAll(node);
    }
}
