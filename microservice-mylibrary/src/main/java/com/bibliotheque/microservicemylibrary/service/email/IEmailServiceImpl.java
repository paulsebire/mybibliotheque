package com.bibliotheque.microservicemylibrary.service.email;

import com.bibliotheque.microservicemylibrary.dao.IEmailDao;
import com.bibliotheque.microservicemylibrary.model.Email;
import com.bibliotheque.microservicemylibrary.outils.EmailType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;

@Service
public class IEmailServiceImpl implements EmailService{

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    IEmailDao iEmailDao;

    @Autowired
    JavaMailSenderImpl sender;


    @Override
    public Email findByName(String name){
        return iEmailDao.findByName( name );
    }

    @Override
    public void sendSimpleMessage(String email, String objet, String contenu) throws MessagingException {

        System.out.println(sender.getHost());
        System.out.println(sender.getPort());

        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setTo(email);
        helper.setSubject(objet);
        helper.setText(contenu);

        sender.send(message);

        logger.info("{} email notification has been send to {}", email);
    }

    @Override
    public void sendRevival(List<EmailType> emailTypeList) throws MessagingException {

        Email email = findByName("relance");

        for (EmailType e: emailTypeList) {
            String text = email.getContenu()
                    .replace("[LIVRE_TITRE]", e.getTitre())
                    .replace("[DATE_FIN]", e.getDateDeFinDuPret());
            sendSimpleMessage(e.getEmail(),email.getContenu(),text);
        }
    }


}
