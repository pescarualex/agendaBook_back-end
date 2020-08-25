package org.fasttrackit.web;

import org.fasttrackit.config.ObjectMapperConfiguration;
import org.fasttrackit.domain.Agenda;
import org.fasttrackit.service.AgendaService;
import org.fasttrackit.transfer.CreateAgendRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/agenda")
public class AgendaServlet extends HttpServlet {

    private AgendaService agendaService = new AgendaService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CreateAgendRequest request = ObjectMapperConfiguration.getObjectMapper()
                .readValue(req.getReader(), CreateAgendRequest.class);

        try {
            agendaService.createAgenda(request);
        } catch (SQLException e) {
            resp.sendError(500, e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Agenda> agenda = agendaService.getAgenda();

            ObjectMapperConfiguration.getObjectMapper()
                    .writeValue(resp.getWriter(), agenda);

        } catch (SQLException e) {
            resp.sendError(500, e.getMessage());
        }
    }


}
