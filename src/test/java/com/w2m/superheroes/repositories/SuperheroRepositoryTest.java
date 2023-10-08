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
public class SuperheroRepositoryTest {

    @Autowired
    private SuperheroRepository superheroRepository;

    @BeforeEach
    public void setUp() {

        Team team1 = new Team();
        team1.setName("Avengers");
        team1.setHeadquarters("New York");
        team1.setLeader("Captain America");
        team1.setDescription("A team of superheroes");

        Superhero superhero1 = new Superhero();
        superhero1.setName("Spiderman");
        superhero1.setRealName("Peter Parker");
        superhero1.setSuperpower("Web-slinging");
        superhero1.setDescription("Friendly neighborhood superhero");
        team1.setSuperheroes(List.of(superhero1));
        superhero1.setTeams(List.of(team1));

        Team team2 = new Team();
        team2.setName("Justice League");
        team2.setHeadquarters("Metropolis");
        team2.setLeader("Superman");
        team2.setDescription("Another team of superheroes");

        Superhero superhero2 = new Superhero();
        superhero2.setName("Superman");
        superhero2.setRealName("Clark Kent");
        superhero2.setSuperpower("Flight");
        superhero2.setDescription("Man of Steel");
        team2.setSuperheroes(List.of(superhero2));
        superhero2.setTeams(List.of(team2));

        superheroRepository.saveAll(List.of(superhero1, superhero2));
    }

    @AfterEach
    public void tearDown() {
        superheroRepository.deleteAll();
    }

    @Test
    public void testFindAll() {
        List<Superhero> superheroes = superheroRepository.findAll();
        assertEquals(2, superheroes.size());
    }

    @Test
    public void testFindById() {
        Superhero superhero = superheroRepository.findById(1L).orElse(null);
        assertNotNull(superhero);
        assertEquals("Spiderman", superhero.getName());
    }
}



