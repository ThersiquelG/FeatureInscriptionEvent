package com.general.greg;
import java.sql.PreparedStatement;

public class EventsWebsite {
	
	int id_event;
	String nom;

public int getId_event() {
	return id_event;
}
public void setId_event(int id_event) {
	this.id_event = id_event;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public EventsWebsite() {
	super();
	this.id_event = id_event;
	this.nom = nom;
}





}
