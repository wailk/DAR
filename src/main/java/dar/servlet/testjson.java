package dar.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;

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
		SessionFactory sf = HandleHibernate.getSF();
		AppartementDao apdao = new AppartementDao(sf);
		
		Appartements app = apdao.getElement(Appartements.class, 1);
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		
		response.getWriter().append(gson.toJson(app));
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		Appartements apt = new Appartements();
		Gson gson = new Gson();
		
		response.getWriter().append(gson.toJson(apt));
		
	}

}