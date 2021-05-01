package com.example.project_af;

public class DaysDataModel {

    String English,French,Pronounce;

    public DaysDataModel() {
    }

    public DaysDataModel(String english, String french) {
        English = english;
        French = french;
    }

    public DaysDataModel(String english, String french, String pronounce) {
        English = english;
        French = french;
        Pronounce = pronounce;
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

    public String getPronounce() {
        return Pronounce;
    }

    public void setPronounce(String pronounce) {
        Pronounce = pronounce;
    }
}
