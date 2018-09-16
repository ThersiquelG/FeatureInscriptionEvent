<%@page import="com.general.greg.EventsWebsite"%>
<%@page import="com.general.greg.CreateConnectionBDD"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%
  	ArrayList<EventsWebsite> listEvents = new ArrayList<EventsWebsite>();
   	 Connection cn = null;
   	 Statement st = null; 
   	 
   			try {
  		Class.forName("com.mysql.jdbc.Driver");
  		String url = "jdbc:mysql://localhost:3306/bibliothèque";
  		String usr = "root";
  		String pwd = "root";

  		cn = CreateConnectionBDD.openConnection();
  		String sql = "SELECT * FROM lesevents";

  		st = cn.createStatement();
  		ResultSet result = st.executeQuery(sql);

  		while (result.next()) {
  			EventsWebsite objet = new EventsWebsite();
  			objet.setId_event(result.getInt("id_event"));
  			objet.setNom(result.getString("nom_event"));

  			listEvents.add(objet);
  		}
  	}

  	 catch (ClassNotFoundException e) {
  		// TODO Auto-generated catch block
  		e.printStackTrace();
  	} catch (Exception e) {
  		// TODO Auto-generated catch block
  		e.printStackTrace();
  	}
  %>   
    
    
    
    
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vous avez bien été connecté</title>
</head>
<body>
<center><h1>Féliciation vous avez bien été connecté.</h1></center>


<h2> Souhaitez vous vous inscrire à cet événement ? </h2>

<% 
	out.println("<ul>");
	for(int i = 0; i<listEvents.size(); i++){
		out.println("<li>");
		out.print(listEvents.get(i).getId_event());
		out.print("</li>");
		
		out.println("<li>");
		out.print(listEvents.get(i).getNom());
		out.print("</li>");
		out.println("<br />");
	}
	
	out.println("</ul>");
%>


	<center>
		<form action="InscriptionEvent">
			<input type="submit" value="Valider">
		</form>
	</center>
</body>
</html>