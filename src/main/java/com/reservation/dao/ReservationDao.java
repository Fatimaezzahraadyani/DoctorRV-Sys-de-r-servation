package com.reservation.dao;

import com.reservation.model.Reservation;
import com.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationDao {

    // Méthode pour récupérer les réservations d'un utilisateur par son nom d'utilisateur
    public List<Reservation> getReservationsByUsername(String username) throws SQLException {
        List<Reservation> reservations = new ArrayList<>();
        String sql = "SELECT r.id, r.date_rv, r.heure, r.id_patient, r.id_medecin " +
                     "FROM reservation r JOIN patient p ON r.id_patient = p.id " +
                     "WHERE p.username = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, username);  // Remplir le paramètre avec le nom d'utilisateur

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                // Récupérer les données du résultat et les ajouter à la liste des réservations
                int id = resultSet.getInt("id");
                String dateRV = resultSet.getString("date_rv");
                String heure = resultSet.getString("heure");
                int idPatient = resultSet.getInt("id_patient");
                int idMedecin = resultSet.getInt("id_medecin");

                // Ajouter la réservation dans la liste
                reservations.add(new Reservation(id, dateRV, heure, idPatient, idMedecin));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Erreur lors de la récupération des réservations");
        }

        return reservations;
    }

    // Méthode pour ajouter une réservation
    public boolean addReservation(Reservation reservation) {
        String sql = "INSERT INTO reservation (date_rv, heure, id_patient, id_medecin) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, reservation.getDateRV());  // Date et heure de la réservation
            statement.setString(2, reservation.getHeure());   // Heure du rendez-vous
            statement.setInt(3, reservation.getIdPatient());  // ID du patient
            statement.setInt(4, reservation.getIdMedecin());  // ID du médecin

            // Exécuter la requête d'insertion
            int rowsAffected = statement.executeUpdate();

            return rowsAffected > 0;  // Si l'insertion est réussie, retourner true

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
