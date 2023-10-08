package com.superheroes.superheroes_test.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.superheroes.superheroes_test.annotations.ExecutionTimeLogger;
import com.superheroes.superheroes_test.dao.SuperheroRepository;
import com.superheroes.superheroes_test.exceptions.CustomException;
import com.superheroes.superheroes_test.models.Superhero;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
@Service
public class SuperheroService {
    private final SuperheroRepository superheroRepository;

    @Autowired
    public SuperheroService(SuperheroRepository superheroRepository) {
        this.superheroRepository = superheroRepository;
    }

    // Métodos para operaciones CRUD en la entidad Superhero
    @Cacheable("superheroesCache")
    @ExecutionTimeLogger("Get all superheroes")
    public List<Superhero> getAllSuperheroes() {
        return superheroRepository.findAll();
    }
    @Cacheable("superheroesCache")
    @ExecutionTimeLogger("Get superhero by ID")
    public Optional<Superhero> getSuperheroById(Long id) {
        Optional<Superhero> superhero = superheroRepository.findById(id);
        if (superhero.isPresent()) {
            return superhero;
        }
        else{
            throw new CustomException("No fue encontrado el superhéroe con el ID: " + id + ".");
        }
    }
    
    @ExecutionTimeLogger("Search a superhero by name") 
    public List<Superhero> searchSuperheroesByName(String name) {
        List<Superhero> superheroes = superheroRepository.findAll();
        superheroes.removeIf(superhero -> !superhero.getName().toLowerCase().contains(name.toLowerCase()));
        return superheroes;
    }

    @ExecutionTimeLogger("Create superhero") 
    public Superhero createSuperhero(Superhero superhero) {
        return superheroRepository.save(superhero);
    }

    @ExecutionTimeLogger("Update superhero") 
    public Superhero updateSuperhero(Long id, Superhero updatedSuperhero) {
        // Verificar si el superhéroe con el ID dado existe
        Optional<Superhero> existingSuperhero = superheroRepository.findById(id);
        if (existingSuperhero.isPresent()) {
            Superhero superhero = existingSuperhero.get();
            superhero.setName(updatedSuperhero.getName());
            superhero.setSuperpower(updatedSuperhero.getSuperpower());
            superhero.setRealName(updatedSuperhero.getRealName());
            superhero.setDescription(updatedSuperhero.getDescription());
            // Actualizar otros campos si es necesario
            return superheroRepository.save(superhero);
        }
        else{
            throw new CustomException("No fue encontrado el superhéroe con el ID: " + id + ".");
        }
    }
    @ExecutionTimeLogger("Delete superhero") 
    public void deleteSuperhero(Long id) {
        Optional<Superhero> superhero = superheroRepository.findById(id);
        if (superhero.isPresent()) {
            superheroRepository.deleteById(id);
        }else{
            throw new CustomException("No fue encontrado el superhéroe con el ID: " + id + ".");
        }
        
    }
}

