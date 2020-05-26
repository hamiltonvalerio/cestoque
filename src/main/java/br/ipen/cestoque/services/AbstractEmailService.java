package br.ipen.cestoque.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import br.ipen.cestoque.domain.Colaborador;
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
	
	@Override
	public void sendNewPassowrdEmail(Colaborador colaborador, String newPass) {
		SimpleMailMessage sm = prepareNewPasswordEmail(colaborador, newPass);
		sendEmail(sm);
	}

	protected SimpleMailMessage prepareNewPasswordEmail(Colaborador colaborador, String newPass) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(colaborador.getEmail());
		sm.setFrom(sender);
		sm.setSubject("SOLICITAÇÃO DE NOVA SENHA");
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText("Nova senha:" + newPass);
		return sm;
	}
	
}
