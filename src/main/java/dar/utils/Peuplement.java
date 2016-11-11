package dar.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import dar.core.Users;
import dar.services.AppartServices;

public class Peuplement {
	
	public static void main(String[] args) {
		Users tmpUser = dbProfilTools.getUser("root@gamil.com") ;
		try (Stream<String> stream = Files.lines(Paths.get("C:\\Users\\Wail\\git\\DAR\\src\\main\\resources\\apt_raw.txt"))) {
	        stream.forEach(x -> {
	        	String[] parts = x.split(";");
	        	try {
					AppartServices.addAppart(tmpUser, parts[0], new Double(parts[1]), new Integer(parts[3]), parts[4], new Boolean(parts[2]),75);
				} catch (Exception e) {
					e.printStackTrace();
				}
	        	
	        });
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
}
