package dar.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dar.core.Appartements;
import dar.dao.AppartementDao;
import dar.utils.HandleHibernate;

@WebServlet("/testjson")
public class testjson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public testjson() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		
		JSONObject obj = new JSONObject();
		obj.put("fname", "wail");
		obj.put("lname", "khecha");
		
		
		response.getWriter().append(obj.toString());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		Appartements apt = new Appartements();
		Gson gson = new Gson();
		
		response.getWriter().append(gson.toJson(apt));
		
	}

}