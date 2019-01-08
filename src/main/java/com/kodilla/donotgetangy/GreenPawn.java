package com.kodilla.donotgetangy;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GreenPawn implements Pawn {
    private PawnColor color;
    private boolean activationStatus;
    private Field currentField;
    private Image pawnImage;
    private int previousMovement = 0;

    public GreenPawn(Field currentField, Image pawnImage) {
        this.activationStatus = false;
        this.color = PawnColor.GREEN;
        this.currentField = currentField;
        this.pawnImage = pawnImage;
    }

    public PawnColor getColor() {
        return color;
    }

    public Field getCurrentField() {
        return currentField;
    }

    public ImageView getPawnImage() {
        return new ImageView(pawnImage);
    }

    public void setNewPosition(Field field) {
        this.currentField = field;
    }

    public boolean getActivationStatus() {
        return activationStatus;
    }

    public boolean changeActivationStatus() {
        if (activationStatus == true) {
            activationStatus = false;
        } else {
            activationStatus = true;
        }
        return activationStatus;
    }

    public void rememberMovement(int movement) {
        previousMovement = movement;
    }

    public int getPreviousMovement() {
        return previousMovement;
    }


}
