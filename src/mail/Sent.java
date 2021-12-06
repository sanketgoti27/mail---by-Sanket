package mail;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

public class Sent {
	public static void main(String[] args) {

		String host = "smtp.gmail.com";
		String from = "sanketgoti1111@gmail.com";
		String password = "uxsorfrkytztuijr";
		String to = "vaghasiyaprashant11@gmail.com";
		
		Properties props = new Properties();
		
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.auth", "true");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			
			}
		});

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Goti's are here ");
			message.setText(" Hello Prashant bhai !! How are You ? ");

		    BodyPart messageBodyPart1 = new MimeBodyPart();  
		    messageBodyPart1.setText("This is message body");  
		      
		    MimeBodyPart messageBodyPart2 = new MimeBodyPart();  
		  
		    String filename = "C:\\Users\\DhavalG\\Desktop\\DurgaSoft-SCJP-notes-Part-1_JavabynataraJ.pdf";
		    	//   filename = "C:\\Users\\DhavalG\\Desktop\\OCJP part 2 by durga.pdf";
		    	   
		    DataSource source = new FileDataSource(filename);  
		    messageBodyPart2.setDataHandler(new DataHandler(source));  
		    messageBodyPart2.setFileName(filename);  
		     
		    Multipart multipart = new MimeMultipart();  
		    multipart.addBodyPart(messageBodyPart1);  
		    multipart.addBodyPart(messageBodyPart2);  
		  
		    message.setContent(multipart );  
		    
			Transport.send(message);

			System.out.println("message sent successfully...");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	

	}
}
