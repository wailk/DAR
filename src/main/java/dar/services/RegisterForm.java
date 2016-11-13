package dar.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dar.core.Users;
import dar.tools.Cryptage;
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
			String hashpwd = Cryptage.hashpw(pass);
			
			if(!UsersServices.exist(mail)){
			Users newUser=new Users( nom, prenom, mail,tel, hashpwd);
			request.setAttribute("newUser", newUser);
			//Enregistrement dans la base de donnÃ©e 
			dbProfilTools.addUser(newUser) ;
			}
			else return false ;
		}catch(Exception e){
			return false ; 
		}
	
 
		
 		return true;

	}
}
