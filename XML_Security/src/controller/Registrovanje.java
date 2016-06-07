package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Korisnik;

/**
 * Servlet implementation class Registrovanje
 */
public class Registrovanje extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registrovanje() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String repeat_password = request.getParameter("repeat_password");
		String ime = request.getParameter("ime");
		String prezime = request.getParameter("prezime");
		String email = request.getParameter("email");
		
	//	ServletContext context=getServletContext();
		

		if(password.equalsIgnoreCase(repeat_password)){
			    Korisnik kor = new Korisnik(username,password,ime,prezime,email,"Gradjanin");
			 
			    	RequestDispatcher disp = request.getRequestDispatcher("index.jsp");
					disp.forward(request, response);
			   
			    
		}else{
			RequestDispatcher disp = request.getRequestDispatcher("korisnik_register.jsp");
			disp.forward(request, response);
		}
	}

}
