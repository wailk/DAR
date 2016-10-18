package dar.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dar.core.Users;
import dar.services.RegisterForm;

/**
 * Servlet implementation class Register
 */

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String ATT_USER="newUser" ; 
	String ATT_USER_SESSION="user"  ; 
	String VUE="/jsp/signup.jsp" ;
	String PAGE_REDIRECT="" ;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.getServletContext().getRequestDispatcher(VUE).forward(request, response); ; 
	
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		if(RegisterForm.valideForm(request, response)){
			Users user=(Users)request.getAttribute(ATT_USER) ; 
			System.out.println(user);
			HttpSession session= request.getSession() ;
			session.setAttribute(ATT_USER_SESSION, user);
			response.sendRedirect(PAGE_REDIRECT);
			return ; 
		}else{
			System.out.println("Invalid shit ! ");
		}
			 
		this.getServletContext().getRequestDispatcher(VUE ).forward(request, response); ; 
		
	}
	


}
