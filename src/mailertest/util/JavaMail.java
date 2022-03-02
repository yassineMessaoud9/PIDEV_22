/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mailertest.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import esprit.com.views.MailConfig;

/**
 *
 * @author ASUS
 */
public class JavaMail {

    private static HashMap<String, String> CONF;
    private static Properties PROPS;
    private static Session SESSION;

    public JavaMail() {

	CONF = MailConfig.getInstance().getConfig();
	PROPS = new Properties();

	PROPS.setProperty("mail.smtp.auth", "true");
	PROPS.setProperty("mail.smtp.starttls.enable", "true");
	PROPS.setProperty("mail.smtp.host", CONF.get("HOST"));
	PROPS.setProperty("mail.smtp.port", CONF.get("PORT"));
	PROPS.setProperty("mail.default-encoding", "UTF-8");

	SESSION = Session.getDefaultInstance(PROPS, new Authenticator() {

	    @Override
	    protected PasswordAuthentication getPasswordAuthentication() {

		return new PasswordAuthentication(CONF.get("EMAIL"), CONF.get("PWD"));
	    }
	});
    }

    public void sendTextMail(String subject, String to, String body) {

	System.out.println("Preparing to send email...");

	try {

	    MimeMessage textMail = createTextMessage(to, subject, body);

	    Transport.send(textMail);
	    System.out.println("Message sent successfully !!");

	} catch (MessagingException ex) {
	    System.out.println(ex.getMessage());
	}

    }

    private MimeMessage createTextMessage(String to, String subject, String body) throws MessagingException {

	MimeMessage message = prepareMessage(to, subject);

	message.setSentDate(new Date());

	message.setText(body);

	return message;
    }

    private MimeMessage prepareMessage(String to, String subject) throws AddressException, MessagingException {
	MimeMessage message = new MimeMessage(SESSION);

	message.setFrom(new InternetAddress(CONF.get("EMAIL")));

	// Set To: header field of the header.
	message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

	// Set Subject: header field
	message.setSubject(subject);

	return message;
    }
/*
    public void sendMailWithAttachment(String subject, String to, String body, String filePath, String fileName) {

	System.out.println("Preparing to send email...");

	try {

	    Message attMail = createMimeMessage(to, subject, body, filePath, fileName);

	    Transport.send(attMail);

	    System.out.println("Message sent successfully !!");

	} catch (MessagingException | IOException ex) {
	    System.out.println(ex.getMessage());
	}
    }

    private Message createMimeMessage(String to, String subject, String body, String filePath, String fileName) throws MessagingException, IOException {

	SESSION.setDebug(true);

	MimeMessage message = prepareMessage(to, subject);

	message.setSentDate(new Date());

        MimeBodyPart bodyPart = new MimeBodyPart();
        bodyPart.setContent("<h1>"+ body +"</h1>", "text/html; charset=utf-8");

	MimeBodyPart attachmentPart = new MimeBodyPart();
	attachmentPart.attachFile(new File(filePath, fileName));
    
	Multipart multipart = new MimeMultipart();
	multipart.addBodyPart(bodyPart);
	multipart.addBodyPart(attachmentPart);

	message.setContent(multipart);

	return message;
    }
*/
}
