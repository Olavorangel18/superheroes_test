package com.w2m.superheroes.models;
import org.junit.jupiter.api.Test;

import com.superheroes.superheroes_test.models.Superhero;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

public class SuperheroTest {

    private Superhero superhero;

    @BeforeEach
    public void setUp() {
        superhero = new Superhero();
    }

    @Test
    public void testSuperheroId() {
        superhero.setId(1L);
        assertEquals(1L, superhero.getId());
    }

    @Test
    public void testSuperheroName() {
        superhero.setName("Spiderman");
        assertEquals("Spiderman", superhero.getName());
    }

    @Test
    public void testSuperheroRealName() {
        superhero.setRealName("Peter Parker");
        assertEquals("Peter Parker", superhero.getRealName());
    }

    @Test
    public void testSuperheroSuperpower() {
        superhero.setSuperpower("Web-slinging");
        assertEquals("Web-slinging", superhero.getSuperpower());
    }

    @Test
    public void testSuperheroDescription() {
        superhero.setDescription("A superhero with web-slinging abilities.");
        assertEquals("A superhero with web-slinging abilities.", superhero.getDescription());
    }

}

