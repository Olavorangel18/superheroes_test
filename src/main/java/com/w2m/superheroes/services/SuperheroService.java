package com.w2m.superheroes.services;

import com.w2m.superheroes.models.Superhero;
import com.w2m.superheroes.repositories.SuperheroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuperheroService {
    private final SuperheroRepository superheroRepository;

    @Autowired
    public SuperheroService(SuperheroRepository superheroRepository) {
        this.superheroRepository = superheroRepository;
    }

    // Métodos para operaciones CRUD en la entidad Superhero

    public List<Superhero> getAllSuperheroes() {
        return superheroRepository.findAll();
    }

    public Optional<Superhero> getSuperheroById(Long id) {
        return superheroRepository.findById(id);
    }

    public Superhero createSuperhero(Superhero superhero) {
        return superheroRepository.save(superhero);
    }

    public Superhero updateSuperhero(Long id, Superhero updatedSuperhero) {
        // Verificar si el superhéroe con el ID dado existe
        Optional<Superhero> existingSuperhero = superheroRepository.findById(id);
        if (existingSuperhero.isPresent()) {
            Superhero superhero = existingSuperhero.get();
            superhero.setName(updatedSuperhero.getName());
            superhero.setSuperpower(updatedSuperhero.getSuperpower());
            // Actualizar otros campos si es necesario
            return superheroRepository.save(superhero);
        }
        return null; // Devuelve null si el superhéroe no existe
    }

    public void deleteSuperhero(Long id) {
        superheroRepository.deleteById(id);
    }
}

