package com.kodilla.donotgetangy;

import javafx.scene.image.ImageView;

import java.util.List;

public interface Pawn {
    PawnColor getColor();
    //boolean isActive();
    Field getCurrentField();
    ImageView getPawnImage();
    void setNewPosition(Field field);
}
