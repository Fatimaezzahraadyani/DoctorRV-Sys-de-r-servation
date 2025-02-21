package com.reservation.model;

import com.patient.model.Patient;

public class Reservation extends Patient {
    private int id;
    private String dateRv;
    private String heure;

    // Constructor
    public Reservation(int id, String dateRv, String heure, String username, String email, String telephone) {
        super(username, email, telephone);  // Appelle le constructeur de la classe Patient
        this.id = id;
        this.dateRv = dateRv;
        this.heure = heure;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateRv() {
        return dateRv;
    }

    public void setDateRv(String dateRv) {
        this.dateRv = dateRv;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }
}
