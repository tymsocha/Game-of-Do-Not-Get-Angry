package com.kodilla.donotgetangy;

public class YellowPawn implements Pawn{
    private PawnColor color;

    public YellowPawn() {
        this.color = PawnColor.YELLOW;
    }

    public PawnColor getColor() {
        return color;
    }
}
