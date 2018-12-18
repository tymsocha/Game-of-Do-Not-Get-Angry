package com.kodilla.donotgetangy;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.List;


public class DoNotGetAngyApplication extends Application {

    private Image board = new Image("file:E:/Dokumenty/Kodilla/Kodilla-Projects/do-not-get-angy/src/main/images/board1.jpg");

    private Image yellowOne = new Image("file:E:/Dokumenty/Kodilla/Kodilla-Projects/do-not-get-angy/src/main/images/YellowOne.jpg");
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

    private Rectangle rectangle = new Rectangle(59,73);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane grid = new GridPane();
        grid.setHgap(17);
        grid.setVgap(16);
        grid.setPadding(new Insets(40, 22, 22, 45));
        grid.setBackground(SetBackGround.setNewBackground(board));

        Board board = new Board();
        board.setBoard(grid);

        List<Field> userMap = MapOfUserFields.getListOfUserMovements();

        ImageView redPawn1 = new ImageView(redOne);
        ImageView redPawn2 = new ImageView(redTwo);
        ImageView redPawn3 = new ImageView(redThree);
        ImageView redPawn4 = new ImageView(redFour);

        ImageView greenPawn1 = new ImageView(greenOne);
        ImageView greenPawn2 = new ImageView(greenTwo);
        ImageView greenPawn3 = new ImageView(greenThree);
        ImageView greenPawn4 = new ImageView(greenFour);

        ImageView bluePawn1 = new ImageView(blueOne);
        ImageView bluePawn2 = new ImageView(blueTwo);
        ImageView bluePawn3 = new ImageView(blueThree);
        ImageView bluePawn4 = new ImageView(blueFour);

        ImageView yellowPawn1 = new ImageView(yellowOne);
        ImageView yellowPawn2 = new ImageView(yellowTwo);
        ImageView yellowPawn3 = new ImageView(yellowThree);
        ImageView yellowPawn4 = new ImageView(yellowFour);

        grid.add(redPawn1,0,0);
        grid.add(redPawn2,1,0);
        grid.add(redPawn3, 0, 1);
        grid.add(redPawn4,1,1);

        grid.add(bluePawn1, 9, 0);
        grid.add(bluePawn2,10,0);
        grid.add(bluePawn3, 9,1);
        grid.add(bluePawn4,10,1);

        grid.add(greenPawn1,9,9);
        grid.add(greenPawn2,10,9);
        grid.add(greenPawn3, 9,10);
        grid.add(greenPawn4,10,10);

        grid.add(yellowPawn1, userMap.get(0).getColumn(), userMap.get(0).getRow());
        grid.add(yellowPawn2,1,9);
        grid.add(yellowPawn3,0,10);
        grid.add(yellowPawn4, 1,10);

        grid.getChildren().remove(yellowPawn1);

        Scene scene = new Scene(grid, 1200, 900, Color.WHITE);

        primaryStage.setTitle("Do Not Get Angry");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
