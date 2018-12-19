package com.kodilla.donotgetangy;

import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public class UserMovesList {
    private List<ImageView> userMovesList = new ArrayList<>();

    public void addToUserMovesList(ImageView imageView) {
        userMovesList.add(imageView);
    }

    public List<ImageView> getUserMovesList() {
        return userMovesList;
    }
}
