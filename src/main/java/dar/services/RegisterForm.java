package dar.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dar.core.Users;
import dar.tools.FormTools;
import dar.tools.R;
import dar.utils.dbProfilTools;



public class RegisterForm {
	public static boolean valideForm(HttpServletRequest request, HttpServletResponse response){

		String nom=request.getParameter(R.Register.NAME) ; 
		String prenom=request.getParameter(R.Register.FIRSTNAME)  ; 
		String mail=request.getParameter(R.Register.EMAIL) ;
		String pass=request.getParameter(R.Register.PASS) ;
		String confPass=request.getParameter(R.Register.PASSRETAPE) ;
		String tel=request.getParameter(R.Register.TEL) ;
			FormTools form=new FormTools() ; 
		try{
			form.validationMotsDePasse(pass, confPass);
			form.validationEmail(mail);
			form.validationNom(nom);
			form.validationNom(prenom);
			
			
			Users newUser=new Users( nom, prenom, mail,tel, pass);
			request.setAttribute("newUser", newUser);
			//Enregistrement dans la base de donnÃ©e 
			dbProfilTools.addUser(newUser) ;
		}catch(Exception e){
			request.setAttribute("erreurMsg",e.getMessage());
			return false ; 
		}
	
 
		
 		return true;

	}
}
