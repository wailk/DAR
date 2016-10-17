package dar.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dar.services.LoginForm;

public class LoginServlet extends HttpServlet {
	String ATT_USER="newUser" ; 
	String ATT_USER_SESSION="user"  ; 
	String VUE="/jsp/cnx.jsp" ;
	private static final String LOGIN = "login";
	private static final String PSW = "password";
	String PAGE_REDIRECT="home" ;
	String PAGE_ERR_REDIRECT="/Login" ;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession() ; 
		//session.invalidate();
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response); ; 
	
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			
		
		if(LoginForm.valideForm(request, response)){
			String login = request.getParameter(LOGIN);
			String psw = request.getParameter(PSW); 
			System.out.println("Connexion de "+ login);
			
			HttpSession session= request.getSession() ;
			session.setAttribute(ATT_USER_SESSION, login);
			response.sendRedirect(PAGE_REDIRECT);
			return ; 
		}else{
			
			System.out.println("Invalid shit ! ");
			response.sendRedirect(PAGE_ERR_REDIRECT);
		}
		}catch(Exception e){
			e.printStackTrace();
			response.sendRedirect(PAGE_ERR_REDIRECT);
			
		}
	}
	

}
