package com.kodilla.donotgetangy;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class RedPawn implements Pawn{
    private PawnColor color;
    private boolean isInGame;
    private Field currentField;
    private Image pawnImage;

    public RedPawn(Field currentField, Image pawnImage) {
        this.color = PawnColor.RED;
        this.isInGame = false;
        this.currentField = currentField;
        this.pawnImage = pawnImage;
    }

    public PawnColor getColor() {
        return color;
    }

    public boolean goToGame(int number) {
        if(number == 1 || number == 6) {
            isInGame = true;
        }
        return isInGame;
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
}
