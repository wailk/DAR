package dar.services;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class MailUtil {
	
	static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;
	
	 public static void sendMail(String adresse,String from,String to,String content) throws MessagingException
	   {    
	     
		 

	      final String username = "cartimmmo@gmail.com";
			final String password ="cartimmo2016";

			
				
			
			Properties props = new Properties();
			//props.put("mail.imap.ssl.trust", "*");
	
			// Step1
			System.out.println("\n 1st ===> setup Mail Server Properties..");
			mailServerProperties = System.getProperties();
			mailServerProperties.put("mail.smtp.port", "587");
			mailServerProperties.put("mail.smtp.auth", "true");
			mailServerProperties.put("mail.smtp.starttls.enable", "true");
			mailServerProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");

			System.out.println("Mail Server Properties have been setup successfully..");

			// Step2
			System.out.println("\n\n 2nd ===> get Mail Session..");
			getMailSession = Session.getDefaultInstance(mailServerProperties, null);
			generateMailMessage = new MimeMessage(getMailSession);
			generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("hichri.mootez@gmail.com"));
			generateMailMessage.setSubject("Cartimmo");
			String emailBody = "Test email by Crunchify.com JavaMail API example. " + "<br><br> Regards, <br>Crunchify Admin";
			
	      
	   
	         
	         StringBuilder bodyText = new StringBuilder(); 
	            bodyText.append("<div>")
	                 .append("  Dear User<br/><br/>")
	                 .append("  You have a message from "+from+"<br/>")
	                 .append("concerning your announcement of the apartment situated at this address :" +adresse+" :" +" <br/>")
	                 .append(content)
	                 .append("  <br/><br/>")
	                 .append("  Thanks,<br/>")
	                 .append("  Cartimmo Team")
	                 .append("</div>");
	            generateMailMessage.setContent(bodyText.toString(), "text/html");
				System.out.println("Mail Session has been created successfully..");
	        
				
				// Step3
				System.out.println("\n\n 3rd ===> Get Session and Send mail");
				Transport transport = getMailSession.getTransport("smtp");
		 
				// Enter your correct gmail UserID and Password
				// if you have 2FA enabled then provide App Specific Password
				transport.connect("smtp.gmail.com", username,password);
				transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
				transport.close();
	}

}

