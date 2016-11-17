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
import dar.utils.dbProfilTools;

@WebServlet("/myapt")
public class UserAppartementsServlet extends HttpServlet {

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

		String login_user=(String) session.getAttribute("user") ;
		int  id_user = dbProfilTools.getUser(login_user).getId_user() ;  
		try{
			List<Appartements> appartements= AppartServices.getByUserId(id_user);
			JSONArray arr = new JSONArray();
			for(Appartements a : appartements)
				arr.put(a.toJSON());
			response.getWriter().append(new JSONObject().put("apps", arr).toString());
			
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
}
}
