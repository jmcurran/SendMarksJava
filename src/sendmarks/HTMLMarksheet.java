/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sendmarks;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author James M. Curran <j.curran@auckland.ac.nz>
 */
public class HTMLMarksheet {

  private String strSheet;

  public HTMLMarksheet(String assignmentNumber, 
    String strCSS, String strDetailsTable,
    Object[][] markTable) {
    StringBuilder sb = new StringBuilder();
    
    

    sb.append("<!DOCTYPE html>\n<html>\n<head>\n");
    sb.append("<title>STATS 779 Assignment ");
    sb.append(assignmentNumber);
    sb.append("</title>\n");
    sb.append("<style>\n");
    sb.append(strCSS);
    sb.append("\t</style>\n");
    sb.append("</head>\n<body>\n");
    
    sb.append(strDetailsTable);
   
    Marktable m = new Marktable(markTable);
    
    sb.append(m.toString());
    
    sb.append("\t\t\t</table>\n");
    sb.append("\t\t</div>\n");
    sb.append("\t</body>\n");
    sb.append("</html>\n");

    strSheet = sb.toString();
  }

  @Override
  public String toString(){
    return strSheet;
  }
  
  public void send(String strMessage){
    // Recipient's email ID needs to be mentioned.
    String to = "james.m.curran@gmail.com";

    // Sender's email ID needs to be mentioned
    String from = "j.curran@auckland.ac.nz";
    final String username = "jcur002";//change accordingly
    final String password = "aqz4@lie";//change accordingly

     String host = "mailhost.auckland.ac.nz";

    Properties props = new Properties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", host);
    props.put("mail.smtp.port", "25");

    // Get the Session object.
    Session session = Session.getInstance(props,
      new javax.mail.Authenticator() {
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password);
      }
    });

    try {
      // Create a default MimeMessage object.
      Message message = new MimeMessage(session);

      // Set From: header field of the header.
      message.setFrom(new InternetAddress(from));

      // Set To: header field of the header.
      message.setRecipients(Message.RecipientType.TO,
        InternetAddress.parse(to));

      // Set Subject: header field
      message.setSubject("Testing Subject");

      // Send the actual HTML message, as big as you like
      message.setContent(strMessage, "text/html");

      // Send message
      Transport.send(message);

      System.out.println("Sent message successfully....");

    } catch (MessagingException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }
  
  public void write(String strFileName) throws IOException{
    FileWriter f1 = new FileWriter(strFileName);
    
    f1.write(strSheet);
    f1.write("\n");
    f1.close();
    
    
  }
}