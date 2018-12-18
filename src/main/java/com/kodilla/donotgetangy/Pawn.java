package com.kodilla.donotgetangy;

import javafx.scene.image.ImageView;

import java.util.List;

public interface Pawn {
    PawnColor getColor();
    boolean goToGame(int number);
    Field getCurrentField();
    ImageView getPawnImage();
    //List<Field> getPositionList();
    void setNewPosition(Field field);
}
