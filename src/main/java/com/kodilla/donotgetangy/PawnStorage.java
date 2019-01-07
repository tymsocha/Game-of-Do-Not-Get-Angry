package com.kodilla.donotgetangy;

import javafx.scene.image.Image;

public final class PawnStorage {
    private final Image yellowOne = new Image("file:E:/Dokumenty/Kodilla/Kodilla-Projects/do-not-get-angy/src/main/images/YellowOne.jpg");
    private final Image yellowTwo = new Image("file:E:/Dokumenty/Kodilla/Kodilla-Projects/do-not-get-angy/src/main/images/YellowTwo.jpg");
    private final Image yellowThree = new Image("file:E:/Dokumenty/Kodilla/Kodilla-Projects/do-not-get-angy/src/main/images/YellowThree.jpg");
    private final Image yellowFour = new Image("file:E:/Dokumenty/Kodilla/Kodilla-Projects/do-not-get-angy/src/main/images/YellowFour.jpg");

    private final Image blueOne = new Image("file:E:/Dokumenty/Kodilla/Kodilla-Projects/do-not-get-angy/src/main/images/BlueOne.jpg");
    private final Image blueTwo = new Image("file:E:/Dokumenty/Kodilla/Kodilla-Projects/do-not-get-angy/src/main/images/BlueTwo.jpg");
    private final Image blueThree = new Image("file:E:/Dokumenty/Kodilla/Kodilla-Projects/do-not-get-angy/src/main/images/BlueThree.jpg");
    private final Image blueFour = new Image("file:E:/Dokumenty/Kodilla/Kodilla-Projects/do-not-get-angy/src/main/images/BlueFour.jpg");

    private final Image redOne = new Image("file:E:/Dokumenty/Kodilla/Kodilla-Projects/do-not-get-angy/src/main/images/RedOne.jpg");
    private final Image redTwo = new Image("file:E:/Dokumenty/Kodilla/Kodilla-Projects/do-not-get-angy/src/main/images/RedTwo.jpg");
    private final Image redThree = new Image("file:E:/Dokumenty/Kodilla/Kodilla-Projects/do-not-get-angy/src/main/images/RedThree.jpg");
    private final Image redFour = new Image("file:E:/Dokumenty/Kodilla/Kodilla-Projects/do-not-get-angy/src/main/images/RedFour.jpg");

    private final Image greenOne = new Image("file:E:/Dokumenty/Kodilla/Kodilla-Projects/do-not-get-angy/src/main/images/GreenOne.jpg");
    private final Image greenTwo = new Image("file:E:/Dokumenty/Kodilla/Kodilla-Projects/do-not-get-angy/src/main/images/GreenTwo.jpg");
    private final Image greenThree = new Image("file:E:/Dokumenty/Kodilla/Kodilla-Projects/do-not-get-angy/src/main/images/GreenThree.jpg");
    private final Image greenFour = new Image("file:E:/Dokumenty/Kodilla/Kodilla-Projects/do-not-get-angy/src/main/images/GreenFour.jpg");

    private static final Image boardYellow = new Image("file:E:/Dokumenty/Kodilla/Kodilla-Projects/do-not-get-angy/src/main/images/board1.jpg");
    private static final Image boardRed = new Image("file:E:/Dokumenty/Kodilla/Kodilla-Projects/do-not-get-angy/src/main/images/BoardRed.jpg");
    private static final Image boardBlue = new Image("file:E:/Dokumenty/Kodilla/Kodilla-Projects/do-not-get-angy/src/main/images/BoardBlue.jpg");
    private static final Image boardGreen = new Image("file:E:/Dokumenty/Kodilla/Kodilla-Projects/do-not-get-angy/src/main/images/BoardGreen.jpg");

    private final Field userStartFieldOne = new Field(0, 9);
    private final Field userStartFieldTwo = new Field(1, 9);
    private final Field userStartFieldThree = new Field(0, 10);
    private final Field userStartFieldFour = new Field(0, 10);

    private final Field computerStartFieldOne = new Field(9, 1);
    private final Field computerStartFieldTwo = new Field(10, 1);
    private final Field computerStartFieldThree = new Field(9, 0);
    private final Field computerStartFieldFour = new Field(10, 0);

    public Pawn getUserPawn(PawnColor pawnColor, int pawnNumber) {
        Pawn pawn;
        if(pawnNumber == 1) {
            if (pawnColor.equals(PawnColor.RED)) {
                pawn = new RedPawn(userStartFieldOne, redOne);
            } else if (pawnColor.equals(PawnColor.BLUE)) {
                pawn = new BluePawn(userStartFieldOne, blueOne);
            } else if (pawnColor.equals(PawnColor.GREEN)) {
                pawn = new GreenPawn(userStartFieldOne, greenOne);
            } else {
                pawn = new YellowPawn(userStartFieldOne, yellowOne);
            }
        } else if (pawnNumber == 2) {
            if(pawnColor.equals(PawnColor.RED)) {
                pawn = new RedPawn(userStartFieldTwo, redTwo);
            } else if (pawnColor.equals(PawnColor.BLUE)) {
                pawn = new BluePawn(userStartFieldTwo, blueTwo);
            } else if (pawnColor.equals(PawnColor.GREEN)) {
                pawn = new GreenPawn(userStartFieldTwo, greenTwo);
            } else {
                pawn = new YellowPawn(userStartFieldTwo, yellowTwo);
            }
        } else if (pawnNumber == 3) {
            if(pawnColor.equals(PawnColor.RED)) {
                pawn = new RedPawn(userStartFieldThree, redThree);
            } else if (pawnColor.equals(PawnColor.BLUE)) {
                pawn = new BluePawn(userStartFieldThree, blueThree);
            } else if (pawnColor.equals(PawnColor.GREEN)) {
                pawn = new GreenPawn(userStartFieldThree, greenThree);
            } else {
                pawn = new YellowPawn(userStartFieldThree, yellowThree);
            }
        } else {
            if(pawnColor.equals(PawnColor.RED)) {
                pawn = new RedPawn(userStartFieldFour, redFour);
            } else if (pawnColor.equals(PawnColor.BLUE)) {
                pawn = new BluePawn(userStartFieldFour, blueFour);
            } else if (pawnColor.equals(PawnColor.GREEN)) {
                pawn = new GreenPawn(userStartFieldFour, greenFour);
            } else {
                pawn = new YellowPawn(userStartFieldFour, yellowFour);
            }
        }
        return pawn;
    }

    public Image getPawnImage(PawnColor pawnColor, int pawnNumber) {
        Image pawn;
        if(pawnNumber == 1) {
            if (pawnColor.equals(PawnColor.RED)) {
                pawn = redOne;
            } else if (pawnColor.equals(PawnColor.BLUE)) {
                pawn = blueOne;
            } else if (pawnColor.equals(PawnColor.GREEN)) {
                pawn = greenOne;
            } else {
                pawn = yellowOne;
            }
        } else if (pawnNumber == 2) {
            if(pawnColor.equals(PawnColor.RED)) {
                pawn = redTwo;
            } else if (pawnColor.equals(PawnColor.BLUE)) {
                pawn = blueTwo;
            } else if (pawnColor.equals(PawnColor.GREEN)) {
                pawn = greenTwo;
            } else {
                pawn = yellowTwo;
            }
        } else if (pawnNumber == 3) {
            if(pawnColor.equals(PawnColor.RED)) {
                pawn = redThree;
            } else if (pawnColor.equals(PawnColor.BLUE)) {
                pawn = blueThree;
            } else if (pawnColor.equals(PawnColor.GREEN)) {
                pawn = greenThree;
            } else {
                pawn = yellowThree;
            }
        } else {
            if(pawnColor.equals(PawnColor.RED)) {
                pawn = redFour;
            } else if (pawnColor.equals(PawnColor.BLUE)) {
                pawn = blueFour;
            } else if (pawnColor.equals(PawnColor.GREEN)) {
                pawn = greenFour;
            } else {
                pawn = yellowFour;
            }
        }
        return pawn;
    }

    public Field getUserStartFieldOne() { return userStartFieldOne; }

    public Field getUserStartFieldTwo() {
        return userStartFieldTwo;
    }

    public Field getUserStartFieldThree() { return userStartFieldThree; }

    public Field getUserStartFieldFour() {
        return userStartFieldFour;
    }

    public Field getComputerStartFieldOne() {
        return computerStartFieldOne;
    }

    public Field getComputerStartFieldTwo() {
        return computerStartFieldTwo;
    }

    public Field getComputerStartFieldThree() {
        return computerStartFieldThree;
    }

    public Field getComputerStartFieldFour() {
        return computerStartFieldFour;
    }

    public static Image getBoardYellow() {
        return boardYellow;
    }

    public static Image getBoardRed() {
        return boardRed;
    }

    public static Image getBoardBlue() {
        return boardBlue;
    }

    public static Image getBoardGreen() {
        return boardGreen;
    }
}
