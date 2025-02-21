package com.patient.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;


import com.patient.model.Patient;
import com.utils.DatabaseConnection;




public class PatientDao { 
	public void ajouterPatient(Patient patient) {
		String sql = "INSERT INTO patient (username, email, telephone) VALUES (?, ?, ?)";
	
		
		 try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement statement = conn.prepareStatement(sql)) {
	            
			 statement.setString(1, patient.getUsername());
			 statement.setString(2, patient.getEmail());
			 statement.setString(3, patient.getTelephone());
	            
			 statement.executeUpdate();
			 
	        }catch (SQLException e) {
	            e.printStackTrace();
	        }
	}
	
		
	
}


