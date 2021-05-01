package com.example.project_af;

public class ImageTextDataModel {

    String English,French,Image;

    public ImageTextDataModel() {
    }

    public ImageTextDataModel(String english, String french, String image) {
        English = english;
        French = french;
        Image = image;
    }

    public String getEnglish() {
        return English;
    }

    public void setEnglish(String english) {
        English = english;
    }

    public String getFrench() {
        return French;
    }

    public void setFrench(String french) {
        French = french;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
