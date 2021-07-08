package com.nthieucmc.springjwtmongodb.controller;

import com.nthieucmc.springjwtmongodb.dto.response.BaseResponseDTO;
import com.nthieucmc.springjwtmongodb.mail.SendMailHelper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.mail.javamail.JavaMailSender;

import javax.annotation.Resource;

@Controller
public class SendMailController {

    @Resource
    JavaMailSender mailSender;

    @Resource
    SendMailHelper sendMailHelper;

    @GetMapping("/send-mail")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<BaseResponseDTO> sendMail () {
        BaseResponseDTO response = sendMailHelper.sendEmail();
        return ResponseEntity.ok(response);
    }
}
