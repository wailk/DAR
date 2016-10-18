package dar.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */

	@WebServlet("/logout")
	public class LogoutServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
		
		String VUE="/index.jsp" ;

		
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			resp.setContentType("application/json");
			HttpSession session = req.getSession();
			session.invalidate();
			RequestDispatcher rd = req.getRequestDispatcher(VUE);
			rd.forward(req, resp);
			
	}

}
