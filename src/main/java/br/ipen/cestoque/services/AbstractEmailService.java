package br.ipen.cestoque.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import br.ipen.cestoque.domain.Produto;

public abstract class AbstractEmailService implements EmailService{
	
	@Value("${default.sender}")
	private String sender;

	@Override
	public void sendProdutoConfirmationEmail(Produto obj) {
		SimpleMailMessage sm = prepareSimpleMailMessageFromProduto(obj);
		sendEmail(sm);
	}

	protected SimpleMailMessage prepareSimpleMailMessageFromProduto(Produto obj) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(obj.getColaborador().toString());
		sm.setFrom(sender);
		sm.setSubject("Produto: "+obj.getNome());
		return null;
	}
	
}
