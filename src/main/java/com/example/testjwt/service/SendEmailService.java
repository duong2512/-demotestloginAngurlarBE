package com.example.testjwt.service;

import com.example.testjwt.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Service
public class SendEmailService {



    @Autowired
    JavaMailSender mailSender;


    String [] upper={ "A", "B", "C", "D", "E", "F", "G", "H", "I" ,"J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    String [] lower={ "a", "b", "c", "d", "e", "f", "g", "h" ,"i","j" ,"k" , "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    int [] number={0,1,2,3,4,5,6,7,8,9};

    int size1=upper.length-1;
    int size2=number.length-1;
    public  int makeRandom(int min, int max){
        return (int) ((Math.random())*((max-min)+1)+min);
    }


    public  String createCode(){
        String newCode="";
        for (int i=0;i<8;i++){
            int from=makeRandom(1,3);
            switch (from){
                case 1:
                    newCode+=upper[makeRandom(0,size1)];
                    break;
                case 2:
                    newCode+=lower[makeRandom(0,size1)];
                    break;
                case 3:
                    newCode+=number[makeRandom(0,size2)];
                    break;
            }
        }

        return newCode;
    }


    public void sendMail( AppUser appUser) {

        String fromAddress = "trandinhquanhubt@gmail.com";
        String content = "Xin chao,[[name]]<br>" +
                "Dang ki thanh cong";
        String subject = "Chao mung......";

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {
            helper.setFrom(fromAddress, "H shop");
            helper.setTo(appUser.getEmail());
            helper.setSubject(subject);

            content = content.replace("[[name]]", appUser.getUserName());
//            String verifyURL = siteURL + "/verify?code=" + user.getVerificationCode();


            helper.setText(content, true);

            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

}
