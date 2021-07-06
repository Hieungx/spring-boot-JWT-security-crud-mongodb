package com.nthieucmc.springjwtmongodb.mail;

import com.nthieucmc.springjwtmongodb.dto.response.BaseResponseDTO;
import lombok.SneakyThrows;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Properties;

public class SendMailHelper {
    String host = "smtp.gmail.com";

    @SneakyThrows
    public BaseResponseDTO sendEmail(){
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        // Get the Session object
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(MailConstants.MY_EMAIL, MailConstants.MY_PASSWORD);
                    }
                });

        //Create a new message
        MimeMessage msg = new MimeMessage(session);

        //Set from address
        msg.setFrom(new InternetAddress(MailConstants.MY_EMAIL));

        //Setting the "to recipients"
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(MailConstants.FRIEND_EMAIL, false));
        msg.setSubject("Hiếu Siêu cấp vip pro");
        MimeBodyPart mbp1 = new MimeBodyPart();
        mbp1.setText("Hello " + MailConstants.FRIEND_EMAIL);
        MimeBodyPart mbp2 = new MimeBodyPart();
        File temp = null;
        File temp1 = null;




        return new BaseResponseDTO();
    }
}
