package  dar.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dar.core.Users;
import dar.tools.FormTools;
import dar.tools.R;
import dar.utils.dbProfilTools;

public class LoginForm {
	public static boolean valideForm(HttpServletRequest request, HttpServletResponse response){


		String pseudo = request.getParameter(R.Connexion.LOGIN); 
		String pass=request.getParameter(R.Connexion.PASS) ;


		Users newUser=null ;
		FormTools form=new FormTools() ; 
		try{
			form.validationNom(pseudo);
			form.validationNom(pass);
			//r�cup�rer l'utilisateur de la base de donn�e
			System.out.println("pseudo "+pseudo);
			System.out.println("pass "+pass);
			
			newUser=dbProfilTools.getUser(pseudo, pass) ; 
			System.out.println(" user "+newUser );
		}catch(Exception e){
			request.setAttribute("erreurMsg",e.getMessage());
			return false ; 
		}

		request.setAttribute("newUser", newUser);

		
 		return true;

	}
}
