package com.superheroes.superheroes_test.controlers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.superheroes.superheroes_test.models.Superhero;
import com.superheroes.superheroes_test.services.SuperheroService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/superheroes")
public class SuperheroController {
    private final SuperheroService superheroService;

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

    @GetMapping("/search")
    public ResponseEntity<List<Superhero>> searchSuperheroes(@RequestParam("name") String name) {
        List<Superhero> superheroes = superheroService.searchSuperheroesByName(name);
        return new ResponseEntity<>(superheroes, HttpStatus.OK);
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
