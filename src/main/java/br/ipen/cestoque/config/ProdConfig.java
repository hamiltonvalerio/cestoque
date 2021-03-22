package br.ipen.cestoque.config;

import java.security.GeneralSecurityException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.sun.mail.util.MailSSLSocketFactory;

import br.ipen.cestoque.services.DBService;
import br.ipen.cestoque.services.EmailService;
import br.ipen.cestoque.services.SmtpEmailService;

@Configuration
@Profile("prod")
public class ProdConfig {

	@Autowired
	private DBService dbService;

	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;

	@Value("${spring.mail.smtp.host}")
	private String host;
	
	@Value("${spring.mail.smtp.port}")
	private Integer port;
	
	@Value("${spring.mail.username}")
	private String username;
	
	@Value("${spring.mail.password}")
	private String password;

	@Bean
	public boolean instantiateDatabase() {

		if (!"create".equals(strategy)) {
			return false;
		}

		// dbService.instantiateTestDatabase();
		return true;
	}

	@Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}

	/*@Bean
	public MailSender mailSender() {
		return new MailSender() {

			@Override
			public void send(SimpleMailMessage... simpleMessages) throws MailException {
				// TODO Auto-generated method stub

			}

			@Override
			public void send(SimpleMailMessage simpleMessage) throws MailException {
				// TODO Auto-generated method stub

			}
		};
	}*/

	@Bean
	public JavaMailSender javaMailService() {
		
		MailSSLSocketFactory sf = null;
		try {
			sf = new MailSSLSocketFactory();
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sf.setTrustAllHosts(true);
		
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
		javaMailSender.setHost(host);
		javaMailSender.setPort(port);
		javaMailSender.setUsername(username);
		javaMailSender.setPassword(password);
		Properties props = javaMailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");
		//props.put("mail.smtps.ssl.checkserveridentity", "true");
	    //props.put("mail.smtps.ssl.trust", "*");
		//props.put("mail.smtp.ssl.enable", "true");
		//props.put("mail.smtp.ssl.socketFactory", sf);

	    //javaMailSender.setJavaMailProperties(javaMailProperties );
		
		return javaMailSender;
	}
}
