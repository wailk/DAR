package dar.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import dar.dao.EquipementsServices;

@WebServlet("/by")
public class SearchForEquipementsServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	 public SearchForEquipementsServlet() {
			
	        super();
	    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		JSONObject json = new JSONObject();

		PrintWriter out = response.getWriter();

		try {
			String laltitude = request.getParameter("laltitude");
			String longitude = request.getParameter("longitude");

			JSONArray arr = EquipementsServices.getNearby(laltitude, longitude);
			response.getWriter().append(arr.toString());
			

		} catch (Exception e) {

			json.put("c", 1);
			json.put("d", "Mauvais param");

			out.print(json.toString());
			return;

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

	
	

