
package dar.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;

import dar.core.Appartements;
import dar.core.Favoris;
import dar.core.Users;

import dar.services.AppartServices;
import dar.services.FavorisServices;

import dar.utils.dbProfilTools;

@WebServlet("/Favoris")
public class FavorisServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String ATT_USER = "newUser";
	String ATT_USER_SESSION = "user";
	String VUE = "/jsp/cnx.jsp";
	String PAGE_REDIRECT = "index.html";
	String PAGE_ERR_REDIRECT = "/Login";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String login = (String) session.getAttribute(ATT_USER_SESSION);
		Favoris fav = FavorisServices.getFavoris(login);
		response.getWriter().append(fav.toJSON().toString());

		// System.out.println("c bon utlisateur connecte");
		return;

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		JSONObject json = new JSONObject();
		String PAGE_NOT_LOGGED = "/Login";
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();

		if (session.getAttribute("user") == null) {

			System.out.println("redirection vers la page d'authentification ...");
			try {
				json.put("c", 1);
				json.put("d", "user null");

			} catch (Exception e1) {
				e1.printStackTrace();
			}
			out.print(json.toString());
			System.out.println("Invalid shit ! ");
			response.sendRedirect(PAGE_NOT_LOGGED);

			return;
		}

		try {

			String login = (String) session.getAttribute(ATT_USER_SESSION);
			
			
			int id_appart = Integer.valueOf(request.getParameter("idapp"));
			FavorisServices.traitementFavoris(login,id_appart);
	
		} catch (Exception e) {
			try {
				json.put("c", 1);
				json.put("d", "Mauvais param");

			} catch (Exception e1) {
				e.printStackTrace();
			}
			out.print(json.toString());
			return;

		}

		try {
			json.put("c", 0);
			json.put("d", "ça marche");

		} catch (Exception e) {
			e.printStackTrace();
		}

		out.print(json.toString());
		return;

	}
}
