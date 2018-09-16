package com.general.greg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;

public class InscriptionEvent {
	
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
