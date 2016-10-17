package dar.tools;



public class FormTools {
	
	public void validationEmail( String email ) throws Exception {
	    if ( email != null && email.trim().length() != 0 ) {
	        if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
	            throw new Exception( "Merci de saisir une adresse mail valide." );
	        }
	    } else {
	        throw new Exception( "Merci de saisir une adresse mail." );
	    }
	}
	public void validationDateNais( String date ) throws Exception {

	    if ( date != null && date.trim().length() != 0 ) {
	        if ( !date.matches( "^(0[1-9]|[1-2][0-9]|3[0-1])-(0[1-9]|1[0-2])-((19[0-9]{2})|(20[0-1][0-9]))$" ) ) {
	            throw new Exception( "Merci de saisir une adresse mail valide." );
	        }
	    } else {
	        throw new Exception( "Merci de saisir une adresse mail." );
	    }
	}

	/**
	 * Valide les mots de passe saisis.
	 */
	public void validationMotsDePasse( String motDePasse, String confirmation ) throws Exception{
	    if (motDePasse != null && motDePasse.trim().length() != 0 && confirmation != null && confirmation.trim().length() != 0) {
	        if (!motDePasse.equals(confirmation)) {
	            throw new Exception("Les mots de passe entrés sont différents, merci de les saisir à nouveau.");
	        } else if (motDePasse.trim().length() < 3) {
	            throw new Exception("Les mots de passe doivent contenir au moins 3 caractères.");
	        }
	    } else {
	        throw new Exception("Merci de saisir et confirmer votre mot de passe.");
	    }
	}
	public void validationNom( String nom ) throws Exception {
	    if ( nom == null || nom.trim().length() < 3 ) {
	        throw new Exception( "Le nom d'utilisateur doit contenir au moins 3 caractères." );
	    }
	   
	}
	public void validationURL(String url) throws Exception{
		// Fonction permettant de vérifier l'url de l'image
		return  ; 
	}
}



