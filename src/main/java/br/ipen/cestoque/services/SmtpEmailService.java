package br.ipen.cestoque.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class SmtpEmailService extends AbstractEmailService{

	/*@Autowired
	private MailSender mailSender;*/
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	private static final Logger LOG = LoggerFactory.getLogger(SmtpEmailService.class);
	
	@Override
	public void sendEmail(SimpleMailMessage msg) {
		// TODO Auto-generated method stub
		LOG.info("Enviando email");
		/*try {
			mailSender.send(msg);	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}*/
		try {
			javaMailSender.send(msg);	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		LOG.info("Email enviado");
	}

}
