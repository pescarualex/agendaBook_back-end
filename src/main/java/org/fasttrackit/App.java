package org.fasttrackit;

import org.fasttrackit.persistence.AgendaRepository;
import org.fasttrackit.transfer.CreateAgendRequest;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {

        AgendaRepository agenda = new AgendaRepository();

//        CreateAgendRequest request = new CreateAgendRequest();
//
//        request.setFirstName("ALEX");
//        request.setLastName("ALEX");
//        request.setPhoneNumber(771128331);
//
//        agenda.createAgenda(request);

        agenda.deleteAgenda(1);


    }
}
