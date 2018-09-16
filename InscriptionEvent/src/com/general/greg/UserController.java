package com.general.greg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpSession;

import com.general.greg.CreateConnectionBDD;
import com.general.greg.ConnectmyUser;
import com.general.greg.EventsWebsite;

import java.sql.ResultSet;
public class UserController {


	public String enregistrerUser(User user) {
		String nom = user.getNom();
		String prenom = user.getPrenom();
		String email = user.getEmail();
		String mdp = user.getPassword();


		Connection cn = null;
		PreparedStatement pst = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			cn = (Connection) CreateConnectionBDD.openConnection();// import de la méthode de connection crée dans la classe CreateConnectionBDD

			String sql =  "insert into utilisateurs(nom,prenom,mail,mot_de_passe) values(?,?,?,?)";
			pst = cn.prepareStatement(sql);

			pst.setString(1, nom);
			pst.setString(2, prenom);
			pst.setString(3, email);
			pst.setString(4, mdp);


			int checkInfos = pst.executeUpdate();


			if (checkInfos != 0) {
				return "AccountCreated.";
			} else {
				System.out.println("Please fill your information correctly...");
			}
		}catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return "Oops.. Something went wrong there..!";
	}

	public String ConnectUser (HttpSession session) {
		Connection cn = null;
		Statement st = null;
		Statement st2 = null;
		Statement st3 = null;
		String test = "";
		
		ResultSet result = null;
		ResultSet result2 = null;
		ResultSet result3 = null;
		
		AuthentificationModel createLogin = new AuthentificationModel();
		
		String logged = "<p>Bienvenue</p> ";
		String notLogged = "<a href=\"connection.jsp\">Connectez vous</a>";
		session.setAttribute("connect", notLogged);
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			cn = (Connection) CreateConnectionBDD.openConnection();
			
			st = cn.createStatement();
			st2 = cn.createStatement();
			st3 = cn.createStatement();
			
			String sql = "SELECT mot_de_passe, mail FROM utilisateurs WHERE mail='" + session.getAttribute("mailConnection")
			+ "'";
			
			result = (ResultSet) st.executeQuery(sql);
			
			createLogin.setMdp("");
			
			while (result.next()) {
				createLogin.setOk(true);
				createLogin.setMdp(result.getString("mot_de_passe"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(createLogin.getOk() == true) {
			if((createLogin.getMdp()).equals(session.getAttribute("mdpConnection"))){
				System.out.println("Connection succesfull");
				
				session.setAttribute("isConnected", true);
				session.setAttribute("connected", logged);
				System.out.println("yes!");
				test = "SUCCESS";
				
			} else {

				session.setAttribute("isConnected", false);
				session.setAttribute("connect", notLogged);
				System.out.println("no!");
				test = "miss";
				/*System.out.println(session.getAttribute("mailConnection"));*/
			}
		}
		
		return test;
		
		
		
	}
	
	public String InscriptionUserEvent (User user,EventsWebsite event ) {

		int idUSER = user.getId_user();
		int idEVENT = event.getId_event();
		Connection cn = null;
		PreparedStatement pst = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = (Connection) CreateConnectionBDD.openConnection();
			String sql = "insert into eventencours(id_event,id_utilisateur) values(?,?)";
			pst = cn.prepareStatement(sql);

			pst.setInt(1, idUSER);
			pst.setInt(2, idEVENT);

			int minRequired = pst.executeUpdate();
			if(minRequired != 0) {
				return "EventAdded";
			} else {
				System.out.println("Please fill your information correctly...");
			}

		}

		catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();


		}

		return "Oops.. Something went wrong there..!";


	}
}
