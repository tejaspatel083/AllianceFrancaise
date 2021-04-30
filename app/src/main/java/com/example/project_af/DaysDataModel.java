package com.example.project_af;

public class DaysDataModel {

    String English,French;

    public DaysDataModel() {
    }

    public DaysDataModel(String english, String french) {
        English = english;
        French = french;
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
}
