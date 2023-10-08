package com.w2m.superheroes.models;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class TeamTest {

    private Team team;

    @BeforeEach
    public void setUp() {
        team = new Team();
    }

    @Test
    public void testTeamId() {
        team.setId(1L);
        assertEquals(1L, team.getId());
    }

    @Test
    public void testTeamName() {
        team.setName("Avengers");
        assertEquals("Avengers", team.getName());
    }

    @Test
    public void testTeamHeadquarters() {
        team.setHeadquarters("New York");
        assertEquals("New York", team.getHeadquarters());
    }

    @Test
    public void testTeamLeader() {
        team.setLeader("Captain America");
        assertEquals("Captain America", team.getLeader());
    }

    @Test
    public void testTeamDescription() {
        team.setDescription("A team of superheroes.");
        assertEquals("A team of superheroes.", team.getDescription());
    }

    @Test
    public void testTeamSuperheroes() {
        Superhero superhero1 = new Superhero();
        Superhero superhero2 = new Superhero();

        team.setSuperheroes(List.of(superhero1, superhero2));

        assertEquals(2, team.getSuperheroes().size());
        assertTrue(team.getSuperheroes().contains(superhero1));
        assertTrue(team.getSuperheroes().contains(superhero2));
    }
}
