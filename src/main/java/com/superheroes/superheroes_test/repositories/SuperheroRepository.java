package com.superheroes.superheroes_test.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.superheroes.superheroes_test.models.Superhero;

@Repository
public interface SuperheroRepository extends JpaRepository<Superhero, Long> {
}