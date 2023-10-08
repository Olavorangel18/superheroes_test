package com.w2m.superheroes.services;
import com.w2m.superheroes.models.Team;
import com.w2m.superheroes.repositories.TeamRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TeamServiceTest {

    @Mock
    private TeamRepository teamRepository;

    private TeamService teamService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        teamService = new TeamService(teamRepository);
    }

    @Test
    public void testGetAllTeams() {
        List<Team> teams = List.of(new Team(), new Team());
        when(teamRepository.findAll()).thenReturn(teams);

        List<Team> result = teamService.getAllTeams();

        assertEquals(2, result.size());
    }

    @Test
    public void testGetTeamById() {
        Team team = new Team();
        team.setId(1L);
        when(teamRepository.findById(1L)).thenReturn(Optional.of(team));

        Team result = teamService.getTeamById(1L).orElse(null);

        assertNotNull(result);
        assertEquals(1L, result.getId());
    }

    @Test
    public void testCreateTeam() {
        Team team = new Team();
        when(teamRepository.save(team)).thenReturn(team);

        Team result = teamService.createTeam(team);

        assertNotNull(result);
    }

    // Similarmente, puedes escribir pruebas para los otros métodos del servicio (actualizar y eliminar).
}

