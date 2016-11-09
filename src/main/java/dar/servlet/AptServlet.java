package dar.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;
import org.json.JSONArray;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dar.core.Appartements;
import dar.dao.AppartementDao;
import dar.utils.HandleHibernate;

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
		
		SessionFactory	sf = HandleHibernate.getSF() ;
		AppartementDao appdao= new AppartementDao(sf);
		List<Appartements> appartements = appdao.getAll(Appartements.class);
		
		JSONArray arr = new JSONArray();
		for(Appartements a : appartements)
			arr.put(a.toJSON());
		
			
		response.getWriter().append(arr.toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("application/json");
		//Appartements apt = new Appartements();
	}

}
