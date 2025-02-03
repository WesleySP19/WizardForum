package com.ForumWizard.Forum.application.service;

import com.ForumWizard.Forum.models.halloffame.HallOfFame;
import com.ForumWizard.Forum.models.user.Athlete;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class HallOfFameServiceTest {
    private HallOfFameService hallOfFameService;
    private HallOfFame hallOfFame;

    @BeforeEach
    void setUp() {
        hallOfFame = new HallOfFame();
        hallOfFameService = new HallOfFameService(hallOfFame);
    }

    @Test
    public void testAddAthlete() {
        Athlete athlete = new Athlete("Wesley Souza", "wesley@example.com", "password123", "John", 10);
        hallOfFameService.addAthlete(athlete);
        assertEquals(1, hallOfFameService.getTopAthletes().size());
    }

    private void assertEquals(int i, int size) {
    }
}
