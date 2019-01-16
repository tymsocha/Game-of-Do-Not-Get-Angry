package com.kodilla.donotgetangy;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BluePawn implements Pawn {
    private PawnColor color;
    private Field currentField;
    private Image pawnImage;
    private boolean activationStatus;
    private boolean finishStatus;

    public BluePawn(Field currentField, Image pawnImage) {
        this.color = PawnColor.BLUE;
        this.activationStatus = false;
        this.currentField = currentField;
        this.pawnImage = pawnImage;
        this.finishStatus = false;
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

    public boolean getFinishStatus() {
        return finishStatus;
    }

    public boolean changeFinishStatus() {
        if (finishStatus == true) {
            finishStatus = false;
        } else {
            finishStatus = true;
        }
        return finishStatus;
    }
}
