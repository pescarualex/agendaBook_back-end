package org.fasttrackit.service;

import org.fasttrackit.domain.Agenda;
import org.fasttrackit.persistence.AgendaRepository;
import org.fasttrackit.transfer.CreateAgendRequest;
import org.fasttrackit.transfer.UpdateAdengaRepository;

import java.sql.SQLException;
import java.util.List;

public class AgendaService {

    private AgendaRepository agendaRepository = new AgendaRepository();

    public void createAgenda(CreateAgendRequest request) throws SQLException {
        System.out.println("Creating agenda: " + request);
        agendaRepository.createAgenda(request);
    }

    public List<Agenda> getAgenda() throws SQLException {
        System.out.println("Retrieving agenda.");
        return agendaRepository.getAgenda();
    }

    public void updateAgenda(int id, UpdateAdengaRepository request) throws SQLException {
        System.out.println("Updating  agenda " + id + ":" + request);
        agendaRepository.updateAgenda(id, request);
    }

    public void deleteAgenda(int id) throws SQLException {
        System.out.println("Deleting agenda " + id);
        agendaRepository.deleteAgenda(id);
    }
}
