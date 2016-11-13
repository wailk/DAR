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

import dar.core.Users;
import dar.services.AppartServices;

@WebServlet("/Suppapp")
public class SuppAppServlet extends HttpServlet {
	

	private static final long serialVersionUID = 1L;




	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String PAGE_NOT_LOGGED="/Login" ; 
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		JSONObject json=new JSONObject() ; 

		PrintWriter out=response.getWriter() ;
		System.out.println("************");
		HttpSession session=request.getSession() ; 

		if(session.getAttribute("user")==null){

			System.out.println("redirection vers la page d'authentification ...");
			try{
				json.put("c", 1);
				json.put("d","user null");

			}catch(Exception e1){
				e1.printStackTrace();
			}
			out.print(json.toString());
			System.out.println("Invalid ! ");
			response.sendRedirect(PAGE_NOT_LOGGED);

			return ; 
		}

		String tmpUser=(String)session.getAttribute("user") ; 
		int idapp = Integer.parseInt(request.getParameter("id"));
		try{
			
			AppartServices.suppAppart(idapp);
	
		}catch(Exception e){
			try{
				json.put("c", 1);
				json.put("d","Mauvais param");

			}catch(Exception e1){
				e.printStackTrace();
			}
			out.print(json.toString());
			return ; 

		}	

		try{
			json.put("c", 0);
			json.put("d","ça marche");

		}catch(Exception e){
			e.printStackTrace();
		}

		out.print(json.toString());
		return ; 
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}


