package com.kodilla.donotgetangy;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class ChoiceOfPawnColor {
    // Four buttons to pick a color
    // If one color is selected return this color and remove those buttons from the grid
    public static PawnColor choosePawnColor(GridPane grid, Button buttonBlue, Button buttonYellow, Button buttonGreen, Button buttonRed) {
        if (buttonBlue.isPressed()) {
            grid.getChildren().removeAll(buttonBlue,buttonGreen,buttonRed,buttonYellow);
            return PawnColor.BLUE;
        } else if (buttonGreen.isPressed()) {
            grid.getChildren().removeAll(buttonBlue,buttonGreen,buttonRed,buttonYellow);
            return PawnColor.GREEN;
        } else if (buttonYellow.isPressed()) {
            grid.getChildren().removeAll(buttonBlue,buttonGreen,buttonRed,buttonYellow);
            return PawnColor.YELLOW;
        } else {
            grid.getChildren().removeAll(buttonBlue,buttonGreen,buttonRed,buttonYellow);
            return PawnColor.RED;
        }
    }
}
