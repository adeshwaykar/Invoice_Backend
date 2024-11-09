package com.invoicems.services;

import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.invoicems.models.Customer;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    
    String generateOTP() {
        SecureRandom random = new SecureRandom();
        int otp = 100000 + random.nextInt(900000); 
        return String.valueOf(otp);
    }

    public String sendVerificationEmail(Customer customer) {
        String subject = "Email Verification";
        String senderName = "Invoice Management";

        
        String otp = generateOTP();

       
        customer.setVerificationOtp(otp);

        String mailContent = "<p>Dear " + customer.getFirstName() + " " + customer.getLastName() + ",</p>";
        mailContent += "<p>Please use the following OTP to verify your registration:</p>";
        mailContent += "<h3>" + otp + "</h3>";
        mailContent += "<p>Thank you!<br>Invoice Management Team</p>";

       
        System.out.println("Generated OTP: " + otp);

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {
            helper.setFrom("shreshthinalawade555@gmail.com", senderName); 
            helper.setTo(customer.getEmail());
            helper.setSubject(subject); 
            helper.setText(mailContent, true); 
            mailSender.send(message); 
        } catch (MessagingException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return otp;
    }
    
    
    public String sendVerificationOtp(String email) {
        String subject = "Email Verification";
        String senderName = "Invoice Management";

        
        String otp = generateOTP();

       

        String mailContent = "<p>Dear User,</p>";
        mailContent += "<p>Please use the following OTP to verify your registration:</p>";
        mailContent += "<h3>" + otp + "</h3>";
        mailContent += "<p>Thank you!<br>Invoice Management Team</p>";

       
        System.out.println("Generated OTP: " + otp);

//        MimeMessage message = mailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(message);
//
//        try {
//            helper.setFrom("shreshthinalawade555@gmail.com", senderName); 
//            helper.setTo(email);
//            helper.setSubject(subject); 
//            helper.setText(mailContent, true); 
//            mailSender.send(message); 
//        } catch (MessagingException | UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
        return otp;
    }
}
