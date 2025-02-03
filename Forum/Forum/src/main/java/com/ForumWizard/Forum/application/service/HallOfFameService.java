package com.ForumWizard.Forum.application.service;

import com.ForumWizard.Forum.models.halloffame.HallOfFame;
import com.ForumWizard.Forum.models.user.Athlete;

import java.util.List;

public class HallOfFameService {
    private final HallOfFame hallOfFame;

    public HallOfFameService(HallOfFame hallOfFame) {
        this.hallOfFame = hallOfFame;
    }

    public void addAthlete(Athlete athlete) {
        hallOfFame.addAthlete(athlete);
    }

    public List<Athlete> getTopAthletes() {
        return hallOfFame.getTopAthletes();
    }
}
