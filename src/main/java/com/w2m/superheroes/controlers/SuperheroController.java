package com.w2m.superheroes.controlers;

import com.w2m.superheroes.models.Superhero;
import com.w2m.superheroes.services.SuperheroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/superheroes")
public class SuperheroController {
    private final SuperheroService superheroService;

    @Autowired
    public SuperheroController(SuperheroService superheroService) {
        this.superheroService = superheroService;
    }

    @GetMapping
    public List<Superhero> getAllSuperheroes() {
        return superheroService.getAllSuperheroes();
    }

    @GetMapping("/{id}")
    public Optional<Superhero> getSuperheroById(@PathVariable Long id) {
        return superheroService.getSuperheroById(id);
    }

    @PostMapping
    public Superhero createSuperhero(@RequestBody Superhero superhero) {
        return superheroService.createSuperhero(superhero);
    }

    @PutMapping("/{id}")
    public Superhero updateSuperhero(@PathVariable Long id, @RequestBody Superhero updatedSuperhero) {
        return superheroService.updateSuperhero(id, updatedSuperhero);
    }

    @DeleteMapping("/{id}")
    public void deleteSuperhero(@PathVariable Long id) {
        superheroService.deleteSuperhero(id);
    }
}
