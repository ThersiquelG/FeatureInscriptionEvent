package com.general.greg;

public class AuthentificationModel {
String mail;
String mdp;
Boolean ok = false;
public String getMail() {
	return mail;
}
public void setMail(String mail) {
	this.mail = mail;
}
public String getMdp() {
	return mdp;
}
public void setMdp(String mdp) {
	this.mdp = mdp;
}
public Boolean getOk() {
	return ok;
}
public void setOk(Boolean ok) {
	this.ok = ok;
}

}
