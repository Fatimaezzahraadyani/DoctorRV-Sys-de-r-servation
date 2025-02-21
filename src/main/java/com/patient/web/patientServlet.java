package com.patient.web;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.patient.dao.PatientDao;
import com.patient.model.Patient;


/**
 * Servlet implementation class patientServlet
 */
@WebServlet("/patientServlet") //Associe la servlet à l’URL /PatientServlet.

public class PatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PatientDao patientDao;
	
	public void init() {
		patientDao = new PatientDao();
	}
	//inistialise patientDao

    /**
     * Default constructor. 
     */
    public PatientServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/**
	 * protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//String action = request.getParameter("action");
		
		//if("continuer".equals(action)) {
		//	reserverRv(request,response);
		//}
	

	//private void reserverRv(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String email = request.getParameter("email");
	    String telephone = request.getParameter("telephone");
	 
	    Patient patient = new Patient(username,email,telephone);
	    patientDao.ajouterPatient(patient);
	     
	    response.sendRedirect("reservation.jsp");
	}
}
