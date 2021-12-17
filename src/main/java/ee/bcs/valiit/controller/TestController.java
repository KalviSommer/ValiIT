package ee.bcs.valiit.controller;

import ch.qos.logback.core.Layout;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@RestController
public class TestController {

    @GetMapping("sendEmail")
            public void sendEmail() throws MessagingException {
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("kalvikodu@gmail.com", "midagiuut");
                    }
                }
                );
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("kalvikodu@gmail.com"));
        message.setRecipients(
                Message.RecipientType.TO,
                InternetAddress.parse("kalvi005@gmail.com")
        );
        message.setSubject("Subject");
        message.setText("Body of email");
        Transport.send(message);
    }


//    localhost:8080/hello/kalvi
//    @GetMapping("employee/{name}")
//    public String hello(@PathVariable("name") String employeename){
//        return "Hello " + employeename;
//    }
//
//    @GetMapping("htmlTest")
//    public String htmlTest(){
//        return "Hello    World";
//    }
}
