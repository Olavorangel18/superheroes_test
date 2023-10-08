package com.w2m.superheroes.repositories;

import com.w2m.superheroes.models.Superhero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SuperheroRepository extends JpaRepository<Superhero, Long> {
}