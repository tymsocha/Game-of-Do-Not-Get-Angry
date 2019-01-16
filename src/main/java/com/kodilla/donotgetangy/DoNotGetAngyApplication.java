package com.kodilla.donotgetangy;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class DoNotGetAngyApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane grid = new GridPane();
        grid.setHgap(17);
        grid.setVgap(16);
        grid.setPadding(new Insets(40, 22, 22, 45));
        grid.setBackground(SetBackGround.setNewBackground(PawnStorage.getBoardYellow()));

        MapOfFinishingFields.addListOfFinishingMovements();
        MapOfUserFields.addListOfUserMovements();
        MapOfComputerFields.addListOfUserMovements();

        ChoiceOfPawnColor.putChoosingColorButtonsOnTheGrid(grid);
        ChoiceOfPawnColor.choosePawnColor(grid);

        Scene scene = new Scene(grid, 1250, 850, Color.WHITE);

        primaryStage.setTitle("Do Not Get Angry");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
