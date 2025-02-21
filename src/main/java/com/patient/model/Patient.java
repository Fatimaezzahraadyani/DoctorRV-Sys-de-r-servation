package com.patient.model;

public class Patient {

    private int id;
    private String username;
    private String email;
    private String telephone;
    
    public Patient(String username, String email, String telephone) {
    	
    }
	public Patient(int id, String username, String email, String telephone) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.telephone = telephone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
   
}