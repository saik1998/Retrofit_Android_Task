package com.firstapp.retrofit_own_api;

public class DetailsModel {
    String Director;
    String Chairman;

    public DetailsModel(String director, String chairman) {
        Director = director;
        Chairman = chairman;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public String getChairman() {
        return Chairman;
    }

    public void setChairman(String chairman) {
        Chairman = chairman;
    }
}
