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

import org.hibernate.SessionFactory;
import org.json.JSONArray;
import org.json.JSONObject;

import dar.core.Appartements;
import dar.core.Users;
import dar.dao.AppartementDao;
import dar.services.AppartServices;
import dar.utils.HandleHibernate;
import dar.utils.dbProfilTools;


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
		response.getWriter().append(new JSONObject().put("apps", arr).toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

		String login_user=(String) session.getAttribute("ATT_USER_SESSION") ;
		Users tmpUser = dbProfilTools.getUser(login_user) ;  
		try{
			String adresse=request.getParameter("adresse") ; 
			//String description=request.getParameter("desc");
			//int arron=Integer.parseInt(request.getParameter("arron")) ; 
			String photo=request.getParameter("photo");
			int superficie= new Integer(request.getParameter("superficie"));
			String type=request.getParameter("type") ;
			String meuble = request.getParameter("meuble");
			int code_postal = Integer.valueOf(request.getParameter("codepostal"));
			Boolean m = Boolean.parseBoolean(meuble);
			String chaine_loyer=request.getParameter("loyer");
			double loyer = Double.parseDouble(chaine_loyer);
			
			AppartServices.addAppart(tmpUser, adresse, loyer, superficie,type, m,code_postal);
			//addAppart(Users user,String adresse,double loyer, int superficie, String type,boolean meuble,int cd)
	
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

}
