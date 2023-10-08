package com.w2m.superheroes.repositories;

import com.w2m.superheroes.models.Superhero;
import com.w2m.superheroes.models.Team;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class TeamRepositoryTest {

    @Autowired
    private TeamRepository teamRepository;

    @BeforeEach
    public void setUp() {

        Superhero superhero1 = new Superhero();
        superhero1.setName("Spiderman");
        superhero1.setRealName("Peter Parker");
        superhero1.setSuperpower("Web-slinging");
        superhero1.setDescription("Friendly neighborhood superhero");

        

        Team team1 = new Team();
        team1.setName("Avengers");
        team1.setId(1L);
        team1.setHeadquarters("New York");
        team1.setLeader("Captain America");
        team1.setDescription("A team of superheroes");
        team1.setSuperheroes(List.of(superhero1));

        Superhero superhero2 = new Superhero();
        superhero2.setName("Superman");
        superhero2.setRealName("Clark Kent");
        superhero2.setSuperpower("Flight");
        superhero2.setDescription("Iron man");

        Team team2 = new Team();
        team2.setId(2L);
        team2.setName("Justice League");
        team2.setHeadquarters("Metropolis");
        team2.setLeader("Superman");
        team2.setDescription("Another team of superheroes");
        team2.setSuperheroes(List.of(superhero2));

        teamRepository.saveAll(List.of(team1, team2));
    }

    @AfterEach
    public void tearDown() {
        teamRepository.deleteAll();
    }

    @Test
    public void testFindAll() {
        List<Team> teams = teamRepository.findAll();
        assertEquals(2, teams.size());
    }

    @Test
    public void testFindById() {
        Team team = teamRepository.findById(1L).orElse(null);
        assertNotNull(team);
        assertEquals("Avengers", team.getName());
    }

}
