package com.w2m.superheroes.services;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.superheroes.superheroes_test.models.Superhero;
import com.superheroes.superheroes_test.repositories.SuperheroRepository;
import com.superheroes.superheroes_test.services.SuperheroService;

import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SuperheroServiceTest {

    @Mock
    private SuperheroRepository superheroRepository;

    private SuperheroService superheroService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        superheroService = new SuperheroService(superheroRepository);
    }

    @Test
    public void testGetAllSuperheroes() {
        List<Superhero> superheroes = List.of(new Superhero(), new Superhero());
        when(superheroRepository.findAll()).thenReturn(superheroes);

        List<Superhero> result = superheroService.getAllSuperheroes();

        assertEquals(2, result.size());
    }

    @Test
    public void testGetSuperheroById() {
        Superhero superhero = new Superhero();
        superhero.setId(1L);
        when(superheroRepository.findById(1L)).thenReturn(Optional.of(superhero));

        Superhero result = superheroService.getSuperheroById(1L).orElse(null);

        assertNotNull(result);
        assertEquals(1L, result.getId());
    }

    @Test
    public void testCreateSuperhero() {
        Superhero superhero = new Superhero();
        when(superheroRepository.save(superhero)).thenReturn(superhero);

        Superhero result = superheroService.createSuperhero(superhero);

        assertNotNull(result);
    }

}





