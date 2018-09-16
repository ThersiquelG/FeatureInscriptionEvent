package com.general.greg;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ConnectmyUser
 */
@WebServlet("/ConnectmyUser")
public class ConnectmyUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnectmyUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mail = request.getParameter("mailConnection");
		String mdp = request.getParameter("mdpConnection");
		
		if(mail == null) mail = "";
		if(mdp == null) mdp = "";
		
		HttpSession session = request.getSession(true);
		
		session.setAttribute("mailConnection", mail);
		session.setAttribute("mdpConnection", mdp);
		
		UserController ConnectmyUser = new UserController();
		
		String connectRegisteredUser = ConnectmyUser.ConnectUser(session);
		
		if(connectRegisteredUser.equals("SUCCESS")) {
			request.getRequestDispatcher("/connectionSucessfull.jsp").forward(request, response);
		} else {
			request.setAttribute("errMessage", connectRegisteredUser);
			request.getRequestDispatcher("/connectionFailure.jsp").forward(request, response);
		}
		
		
		
		
		/*response.getWriter().append("Served at: ").append(request.getContextPath());*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mail = request.getParameter("mailConnection");
		String mdp = request.getParameter("mdpConnection");
		
		if(mail == null) mail = "";
		if(mdp == null) mdp = "";
		
		HttpSession session = request.getSession(true);
		
		session.setAttribute("mailConnection", mail);
		session.setAttribute("mdpConnection", mdp);
		
		UserController ConnectmyUser = new UserController();
		
		String connectRegisteredUser = ConnectmyUser.ConnectUser(session);
		
		if(connectRegisteredUser.equals("SUCCESS")) {
			request.getRequestDispatcher("/connectionSucessfull.jsp").forward(request, response);
		} else {
			request.setAttribute("errMessage", connectRegisteredUser);
			request.getRequestDispatcher("/connectionFailure.jsp").forward(request, response);
		}
	}

}
