package com.patient.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.patient.model.Patient;
import com.utils.DatabaseConnection;

public class PatientDao {

    // Vérifier si le patient existe déjà et retourner son ID
    public int getPatientId(String username) {
        String sql = "SELECT id FROM patient WHERE username = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("id");  // Retourne l'ID du patient existant
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Si le patient n'existe pas
    }

    // Ajouter un patient et retourner son ID
    public int ajouterPatient(Patient patient) {
        int existingId = getPatientId(patient.getUsername());
        if (existingId != -1) {
            return existingId;  // Si le patient existe déjà, retourner son ID
        }

        String sql = "INSERT INTO patient (username, email, telephone) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, patient.getUsername());
            stmt.setString(2, patient.getEmail());
            stmt.setString(3, patient.getTelephone());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows > 0) {
                ResultSet generatedKeys = stmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1); // Retourner l'ID généré
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // En cas d'erreur
    }
}
