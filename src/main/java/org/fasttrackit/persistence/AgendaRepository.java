package org.fasttrackit.persistence;

import org.fasttrackit.config.DBConfiguration;
import org.fasttrackit.transfer.CreateAgendRequest;
import org.fasttrackit.transfer.UpdateAdengaRepository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AgendaRepository {

    public void createAgenda(CreateAgendRequest request) throws SQLException {
        String sql = "INSERT INTO agenda (first_name, last_name, phone_number) VALUES (?,?,?)";

        try (PreparedStatement prepareStatement = DBConfiguration.getConnection().prepareStatement(sql )) {
            prepareStatement.setString(1, request.getFirstName());
            prepareStatement.setString(2, request.getLastName());
            prepareStatement.setInt(3, request.getPhoneNumber());

            prepareStatement.executeUpdate();
        }
    }


    public void updateAgenda(int id, UpdateAdengaRepository request) throws SQLException {
        String sql = "UPDATE agenda SET first_name = ?, last_name = ?, phone_number = ?  WHERE id = ?";

        try (PreparedStatement preparedStatement = DBConfiguration.getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, request.getFirstName());
            preparedStatement.setString(2, request.getLastName());
            preparedStatement.setInt(3, request.getPhoneNumber());
            preparedStatement.setLong(4, id);

            preparedStatement.executeUpdate();
        }


    }

    public void deleteAgenda(int id) throws SQLException {
        String sql = "DELETE FROM agenda WHERE id = ?";

        try (PreparedStatement preparedStatement = DBConfiguration.getConnection().prepareStatement(sql)) {
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
        }



    }


}
