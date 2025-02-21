package com.reservation.model;

public class Reservation {
	int id;
	int heure;
	int date_rv;
	public Reservation(int id, int heure, int date_rv) {
		super();
		this.id = id;
		this.heure = heure;
		this.date_rv = date_rv;
	}
	public Reservation(int id, String heure, String date_rv) {
		// TODO Auto-generated constructor stub
	}


}
