package com.firstapp.retrofit_task_array;

public class DetailsModel {
    String director;
    String Chairman;

    public DetailsModel(String director, String chairman) {
        this.director = director;
        this.Chairman = chairman;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getChairman() {
        return Chairman;
    }

    public void setChairman(String chairman) {
        this.Chairman = chairman;
    }
}