package com.general.greg;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.general.greg.User;

import com.general.greg.UserController;

/**
 * Servlet implementation class SaveUser
 */
@WebServlet("/SaveUser")
public class SaveUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = new User();
		
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("mail");
		String mdp = request.getParameter("mdp");
		
		
		user.setNom(nom);
		user.setPrenom(prenom);
		user.setEmail(email);
		user.setPassword(mdp);
		
		
		UserController createUser = new UserController();
		
		String userSaved = createUser.enregistrerUser(user);
		
		if(userSaved.equals("AccountCreated.") ) {
			request.getRequestDispatcher("/Home.jsp").forward(request, response);
		}
		else // On Failure, display a meaningful message to the User.
		{
			request.setAttribute("errMessage", userSaved);
			request.getRequestDispatcher("/inscriptionPage.jsp").forward(request, response);

		}
		
		
		
		
		/*response.getWriter().append("Served at: ").append(request.getContextPath());*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
