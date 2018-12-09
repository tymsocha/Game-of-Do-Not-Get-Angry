package com.kodilla.donotgetangy;

public class RedPawn implements Pawn{
    private PawnColor color;

    public RedPawn() {
        this.color = PawnColor.RED;
    }

    public PawnColor getColor() {
        return color;
    }
}
