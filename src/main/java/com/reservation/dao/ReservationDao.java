package com.reservation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.reservation.model.Reservation;
import com.utils.DatabaseConnection;

public class ReservationDao {
	public List<Reservation> getReservationsByUsername(String username) throws SQLException {
        List<Reservation> reservations = new ArrayList<>();
        String sql = "SELECT r.id, r.date_rv, r.heure " +
                     "FROM reservation r " +
                     "JOIN patient p ON r.id_patient = p.id " +
                     "WHERE p.username = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

        	statement.setString(1, username);
            try(ResultSet rs = statement.executeQuery()){

            while (rs.next()) {
                Reservation reservation = new Reservation(
                    rs.getInt("id"),
                    rs.getString("date_rv").toString(),
                    rs.getString("heure").toString()
                );
                reservations.add(reservation);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservations;
    }
	}
}


