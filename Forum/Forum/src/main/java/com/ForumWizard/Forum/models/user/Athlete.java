package com.ForumWizard.Forum.models.user;

import com.ForumWizard.Forum.models.enums.UserType;

public class Athlete extends User {
    private String playerName;
    private int jerseyNumber;
    private int attendanceCount;
    private int rating;

    public Athlete(String name, String email, String password, String playerName, int jerseyNumber) {
        super(name, email, password, UserType.ATHLETE);
        this.playerName = playerName;
        this.jerseyNumber = jerseyNumber;
        this.attendanceCount = 0;
        this.rating = 0;
    }

    // Getters e Setters
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public int getAttendanceCount() {
        return attendanceCount;
    }

    public void setAttendanceCount(int attendanceCount) {
        this.attendanceCount = attendanceCount;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
