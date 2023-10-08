package com.w2m.superheroes.models;
import javax.persistence.*;
import java.util.List;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String headquarters; // Sede del equipo

    @Column
    private String leader; // Líder del equipo

    @Column(columnDefinition = "TEXT")
    private String description; // Descripción del equipo

    @ManyToMany(mappedBy = "teams")
    private List<Superhero> superheroes;

    // Constructor(s)

    public Team() {
    }

    public Team(String name, String headquarters, String leader, String description) {
        this.name = name;
        this.headquarters = headquarters;
        this.leader = leader;
        this.description = description;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadquarters() {
        return headquarters;
    }

    public void setHeadquarters(String headquarters) {
        this.headquarters = headquarters;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Superhero> getSuperheroes() {
        return superheroes;
    }

    public void setSuperheroes(List<Superhero> superheroes) {
        this.superheroes = superheroes;
    }
}

