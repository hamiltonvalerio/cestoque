package br.ipen.cestoque.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;

public class SmtpEmailService extends AbstractEmailService {

	/*
	 * @Autowired private MailSender mailSender;
	 */

	@Autowired
	private JavaMailSender javaMailSender;

	private static final Logger LOG = LoggerFactory.getLogger(SmtpEmailService.class);

	@Autowired
	private TaskExecutor taskExecutor;

	/*@Autowired
	public SmtpEmailService(TaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}*/

	@Async
	@Override
	public void sendEmail(SimpleMailMessage msg) throws MailException{
		// TODO Auto-generated method stub
		LOG.info("Enviando email");
		/*
		 * try { mailSender.send(msg); } catch (Exception e) { // TODO: handle exception
		 * e.printStackTrace(); }
		 */
		try {
			taskExecutor.execute(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					javaMailSender.send(msg);
					
				}
			});
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		LOG.info("Email enviado");
	}

}
