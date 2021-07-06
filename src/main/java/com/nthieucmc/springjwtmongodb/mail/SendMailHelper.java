package com.nthieucmc.springjwtmongodb.mail;

import com.nthieucmc.springjwtmongodb.constant.ErrorCode;
import com.nthieucmc.springjwtmongodb.dto.response.BaseResponseDTO;
import com.nthieucmc.springjwtmongodb.exception.CustomException;
import com.nthieucmc.springjwtmongodb.validation.ValidationResult;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.Properties;

@Component
public class SendMailHelper {
    String host = "smtp.gmail.com";

    @SneakyThrows
    public BaseResponseDTO sendEmail() {
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
        File temp1 = null;

        temp1 = new File("C:/Users/nthieu10/Downloads/users_2021-06-30.xlsx");
        boolean ch = temp1.createNewFile();
        FileDataSource fds = new FileDataSource(temp1);
        mbp2.setDataHandler(new DataHandler(fds));
        mbp2.setFileName(fds.getName());
        Multipart mp = new MimeMultipart();
        mp.addBodyPart(mbp1);
        mp.addBodyPart(mbp2);
        msg.setContent(mp);
        msg.saveChanges();

        // Set the Date: header
        msg.setSentDate(new java.util.Date());
        Transport.send(msg);

        ValidationResult validationResult = validageMsgNull(msg);
        if (!validationResult.isSuccessful()) {
            throw new CustomException(validationResult.getCode(), validationResult.getMessage());
        }
        validationResult.setMessage("Send Mail Success");

        return new BaseResponseDTO(validationResult.getMessage());
    }

    private ValidationResult validageMsgNull(MimeMessage msg) {
        ValidationResult validationResult = new ValidationResult();
        validationResult.setSuccessful(true);
        if (ObjectUtils.isEmpty(msg)) {
            validationResult.setSuccessful(false);
            validationResult.setCode(ErrorCode.MESSAGE_NULL);
            validationResult.setMessage("Message must not null");
        }
        return validationResult;
    }
}
