package com.patient.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.patient.dao.PatientDao;
import com.patient.model.Patient;
import com.reservation.dao.ReservationDao;
import com.reservation.model.Reservation;

@WebServlet("/patientServlet")
public class PatientServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PatientDao patientDao;
    private ReservationDao reservationDao;

    public void init() {
        patientDao = new PatientDao();
        reservationDao = new ReservationDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone");
        String dateRdv = request.getParameter("dateRdv"); // yyyy-MM-dd
        String heureRdv = request.getParameter("heureRdv"); // HH:mm
        String motif = request.getParameter("motif");

        // Ajouter le patient
        Patient patient = new Patient(username, email, telephone);
        int patientId = patientDao.ajouterPatient(patient);

        // Ajouter la réservation
        reservationDao.ajouterReservation(patientId, dateRdv, heureRdv, motif);

        // Récupérer les réservations du patient
        List<Reservation> reservations = reservationDao.getReservationsByUsername(username);

        // Envoyer les réservations à la JSP
        request.setAttribute("reservations", reservations);
        request.getRequestDispatcher("/reservations.jsp").forward(request, response);
    }
}
