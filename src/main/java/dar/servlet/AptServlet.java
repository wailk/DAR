package dar.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dar.core.Appartements;

/**
 * Servlet implementation class RechercheServlet
 */
@WebServlet("/apt")
public class AptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AptServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		Appartements apt = new Appartements();
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		
		response.getWriter().append(gson.toJson(apt));
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		Appartements apt = new Appartements();
		Gson gson = new Gson();
		
		response.getWriter().append(gson.toJson(apt));
		
	}

}
