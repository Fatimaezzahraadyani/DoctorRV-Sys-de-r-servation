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

    // Ajouter une réservation
    public void ajouterReservation(int patientId, String date, String heure, String motif) {
        String sql = "INSERT INTO reservation (id_patient, date_rv, heure, motif) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, patientId);
            stmt.setString(2, date);
            stmt.setString(3, heure);
            stmt.setString(4, motif);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Récupérer les réservations d'un patient
    public List<Reservation> getReservationsByUsername(String username) {
        List<Reservation> reservations = new ArrayList<>();
        String sql = "SELECT r.id, p.username, p.email, p.telephone, r.date_rv, r.heure, r.motif " +
                     "FROM reservation r " +
                     "JOIN patient p ON r.id_patient = p.id " +
                     "WHERE p.username = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Reservation reservation = new Reservation(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("email"),
                    rs.getString("telephone"),
                    rs.getString("date_rv"),
                    rs.getString("heure"),
                    rs.getString("motif")
                );
                reservations.add(reservation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservations;
    }
}
