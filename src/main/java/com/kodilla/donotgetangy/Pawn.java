package com.kodilla.donotgetangy;

import javafx.scene.image.ImageView;

import java.util.List;

public interface Pawn {
    PawnColor getColor();
    boolean getActivationStatus();
    boolean changeActivationStatus();
    Field getCurrentField();
    ImageView getPawnImage();
    void setNewPosition(Field field);
    void rememberMovement(int number);
    int getPreviousMovement();
}
