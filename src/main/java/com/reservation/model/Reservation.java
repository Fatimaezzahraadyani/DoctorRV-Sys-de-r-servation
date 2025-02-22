package com.reservation.model;

public class Reservation {

    private int id;                // ID de la réservation
    private String dateRV;         // Date et heure de la réservation (format yyyy-MM-dd HH:mm)
    private String heure;          // Heure du rendez-vous
    private int idPatient;         // ID du patient
    private int idMedecin;         // ID du médecin

    // Constructeur
    public Reservation(int id, String dateRV, String heure, int idPatient, int idMedecin) {
        this.id = id;
        this.dateRV = dateRV;
        this.heure = heure;
        this.idPatient = idPatient;
        this.idMedecin = idMedecin;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateRV() {
        return dateRV;
    }

    public void setDateRV(String dateRV) {
        this.dateRV = dateRV;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public int getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    public int getIdMedecin() {
        return idMedecin;
    }

    public void setIdMedecin(int idMedecin) {
        this.idMedecin = idMedecin;
    }

	
}
