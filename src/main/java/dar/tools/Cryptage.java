package dar.tools;

import org.mindrot.jbcrypt.BCrypt;

public class Cryptage {
	private static String SALT = "$2a$10$tSBQ74s9Jzz1VxueEE3hFe";

	public static String hashpw(String mdp) {
		return BCrypt.hashpw(mdp, SALT);
	}

	public static boolean checkpw(String mdp, String hashed) {
		return BCrypt.checkpw(mdp, hashed);
	}
}
