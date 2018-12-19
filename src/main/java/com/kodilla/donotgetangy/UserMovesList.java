package com.kodilla.donotgetangy;

import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public class UserMovesList {
    private static List<ImageView> userMovesList = new ArrayList<>();

    public static void addToUserMovesList(ImageView imageView) {
        userMovesList.add(imageView);
    }

    public static List<ImageView> getUserMovesList() {
        return userMovesList;
    }
}
