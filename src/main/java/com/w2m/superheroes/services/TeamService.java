package com.w2m.superheroes.services;

import com.w2m.superheroes.models.Team;
import com.w2m.superheroes.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class TeamService {
    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    // Métodos para operaciones CRUD en la entidad Team

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Optional<Team> getTeamById(Long id) {
        return teamRepository.findById(id);
    }

    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }
    
    public Team updateTeam(Long id, Team updatedTeam) {
        Optional<Team> existingTeam = teamRepository.findById(id);
        if (existingTeam.isPresent()) {
            Team team = existingTeam.get();
            team.setName(updatedTeam.getName());
            team.setHeadquarters(updatedTeam.getHeadquarters());
            team.setLeader(updatedTeam.getLeader());
            // Actualiza otros campos si es necesario
            return teamRepository.save(team);
        }
        return null;
    }

    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }

}
