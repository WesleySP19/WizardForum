package com.ForumWizard.Forum.models.user;

import com.ForumWizard.Forum.models.enums.UserType;

import java.util.ArrayList;
import java.util.List;

public class CT extends User {
    private List<Athlete> evaluatedAthletes;

    public CT(String name, String email, String password) {
        super(name, email, password, UserType.CT);
        this.evaluatedAthletes = new ArrayList<>();
    }

    public void evaluateAthlete(Athlete athlete, int rating) {
        athlete.setRating(rating);
        evaluatedAthletes.add(athlete);
    }

    public List<Athlete> getEvaluatedAthletes() {
        return evaluatedAthletes;
    }
}