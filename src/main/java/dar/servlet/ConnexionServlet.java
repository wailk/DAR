//package dar.servlet;
//
//import java.io.IOException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Servlet implementation class ConnexionServlet
// */
//
//@WebServlet("/cnx")
//public class ConnexionServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	private static final String LOGIN = "login";
//	private static final String PSW = "password";
//	private static final String DIR_JSP = "/jsp/";
//	private static final String PAGE_CNX = "cnx.jsp";
//	private static final String PAGE_HOME = "home.jsp";
//	private final static Logger LOGGER = Logger.getLogger(ConnexionServlet.class.getName());
//
//	/**
//	 * @see HttpServlet#HttpServlet()
//	 */
//	public ConnexionServlet() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String nextJSP = DIR_JSP + PAGE_CNX;
//		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
//		dispatcher.forward(req, resp);
//
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String login = request.getParameter(LOGIN);
//		String psw = request.getParameter(PSW);
//		LOGGER.info("le client " + login + " veut se connecter");
//		
//		//TODO verification de l'utilisateur 
//		
//		// user OK
//		LOGGER.log(Level.INFO, "le client " + login + "  s'est connect�");
//		
//		// TODO creation de session pour l'utilisateur
//		request.setAttribute(LOGIN, login);
//		String nextJSP = DIR_JSP + PAGE_HOME;
//		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
//		dispatcher.forward(request, response);
//		
//	}
//
//}
