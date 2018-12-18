package com.kodilla.donotgetangy;

import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class SetBackGround {
    public static Background setNewBackground(Image image){
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, backgroundSize);
        Background background = new Background(backgroundImage);
        return background;
    }
}
