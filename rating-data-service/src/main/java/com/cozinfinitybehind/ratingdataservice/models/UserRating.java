package com.cozinfinitybehind.ratingdataservice.models;

import java.util.List;

public class UserRating {
    List<Rating> ratingList;

    public UserRating(List<Rating> ratingList) {
        this.ratingList = ratingList;
    }

    public List<Rating> getRatingList() {
        return ratingList;
    }

    public void setRatingList(List<Rating> ratingList) {
        this.ratingList = ratingList;
    }
}
