package com.kodilla.donotgetangy;

public class GreenPawn implements Pawn {
    private PawnColor color;

    public GreenPawn() {
        this.color = PawnColor.GREEN;
    }

    public PawnColor getColor() {
        return color;
    }
}
