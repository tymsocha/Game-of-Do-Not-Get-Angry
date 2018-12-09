package com.kodilla.donotgetangy;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class DoNotGetAngyApplication extends Application {

    private Image board = new Image("file:E:/Dokumenty/Kodilla/Kodilla-Projects/do-not-get-angy/src/main/images/board.png");

    private Image yellowPawn = new Image("file:E:/Dokumenty/Kodilla/Kodilla-Projects/do-not-get-angy/src/main/images/yellow_pawn.jpg");
    private Image bluePawn = new Image("file:E:/Dokumenty/Kodilla/Kodilla-Projects/do-not-get-angy/src/main/images/blue_pawn.jpg");
    private Image redPawn = new Image("file:E:/Dokumenty/Kodilla/Kodilla-Projects/do-not-get-angy/src/main/images/red_pawn.jpg");
    private Image greenPawn = new Image("file:E:/Dokumenty/Kodilla/Kodilla-Projects/do-not-get-angy/src/main/images/green_pawn.jpg");

    private FlowPane pawns = new FlowPane(Orientation.HORIZONTAL);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(board, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();
        grid.setVgap(20);
        grid.setHgap(20);
        grid.setAlignment(Pos.BOTTOM_LEFT);
        grid.setPadding(new Insets(0,0,0,0));
        grid.setBackground(background);

        ImageView redPawn1 = new ImageView(redPawn);
        ImageView greenPawn1 = new ImageView(greenPawn);
        ImageView bluePawn1 = new ImageView(bluePawn);
        ImageView yellowPawn1 = new ImageView(yellowPawn);

        pawns.getChildren().add(redPawn1);

        grid.add(yellowPawn1,1,0,20,20);

        Scene scene = new Scene(grid, 1200, 900, Color.WHITESMOKE);

        primaryStage.setTitle("Do Not Get Angry");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
