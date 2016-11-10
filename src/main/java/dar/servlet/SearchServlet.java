package dar.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;

import dar.core.Appartements;
import dar.services.AppartServices;



@WebServlet("/Search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchServlet(){
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		JSONObject json=new JSONObject() ; 

		PrintWriter out=response.getWriter() ;

		HttpSession session=request.getSession() ; 

		try{
			String prix_min=request.getParameter("min");
			String prix_max=request.getParameter("max");
			String ville=request.getParameter("ville");
			List<Appartements> appartements= AppartServices.search(prix_max,prix_min,ville);
			
				JSONArray arr = new JSONArray();
				for(Appartements a : appartements)
					arr.put(a.toJSON());
				
					
				response.getWriter().append(arr.toString());
	
		}catch(Exception e){
	
				json.put("c", 1);
				json.put("d","Mauvais param");
				
			out.print(json.toString());
			return ; 

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
