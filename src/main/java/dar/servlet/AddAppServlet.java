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
import dar.core.Users;
import dar.services.AppartServices;

@WebServlet("/Addapp")
public class AddAppServlet extends HttpServlet {

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
			System.out.println("Invalid shit ! ");
			response.sendRedirect(PAGE_NOT_LOGGED);

			return ; 
		}

		Users tmpUser=(Users)session.getAttribute("user") ;
		int id_user = tmpUser.getId_user() ; 
		Appartements app=new Appartements() ; 
		try{
			String adresse=request.getParameter("adresse") ; 
			String description=request.getParameter("desc");
			//int arron=Integer.parseInt(request.getParameter("arron")) ; 
			String photo=request.getParameter("photo");
			String superficie=request.getParameter("superficie") ;
			String type=request.getParameter("type") ;
			String meuble = request.getParameter("meuble");
			Boolean m = Boolean.parseBoolean(meuble);
			String chaine_loyer=request.getParameter("loyer");
			double loyer = Double.parseDouble(chaine_loyer);
			
			AppartServices.addAppart(tmpUser, adresse, loyer, m);
	
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


