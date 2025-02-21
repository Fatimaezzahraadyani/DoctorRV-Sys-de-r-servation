package com.reservation.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reservation.dao.ReservationDao;
import com.reservation.model.Reservation;


/**
 * Servlet implementation class reservationServlet
 */
@WebServlet("/reservationServlet")
public class reservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ReservationDao reservationDao;
	
	public void init() {
		reservationDao = new ReservationDao();
	}

    /**
     * Default constructor. 
     */
    public reservationServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String username = request.getParameter("username");
		try {
		if (username!=null && !username.isEmpty()) {
			List<Reservation> reservations = reservationDao.getReservationsByUsername(username);
			request.setAttribute("reservations", reservations);
		}else {
			request.setAttribute("error","User name invalide !");
		}
		request.getRequestDispatcher("/Reservation.jsp").forward(request, response);
		}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				 request.setAttribute("error", "Une erreur est survenue lors de la récupération des réservations.");
			        request.getRequestDispatcher("/Reservation.jsp").forward(request, response);
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
