package com.ForumWizard.Forum.models.halloffame;

import com.ForumWizard.Forum.models.user.Athlete;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparingInt;

public class HallOfFame {
    private List<Athlete> topAthletes;

    public HallOfFame() {
        this.topAthletes = new ArrayList<>();
    }

    public void addAthlete(Athlete athlete) {
        topAthletes.add(athlete);
        topAthletes.sort(comparingInt(Athlete::getRating).reversed());
    }

    public List<Athlete> getTopAthletes() {
        return topAthletes;
    }
}
