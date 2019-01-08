package com.kodilla.donotgetangy;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class RedPawn implements Pawn{
    private PawnColor color;
    private boolean activationStatus;
    private Field currentField;
    private Image pawnImage;
    private int previousMovement = 0;

    public RedPawn(Field currentField, Image pawnImage) {
        this.color = PawnColor.RED;
        this.activationStatus = false;
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
        ImageView imageView = new ImageView(pawnImage);
        return imageView;
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
