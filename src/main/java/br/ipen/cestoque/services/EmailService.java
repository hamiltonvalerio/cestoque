package br.ipen.cestoque.services;

import org.springframework.mail.SimpleMailMessage;

import br.ipen.cestoque.domain.Colaborador;
import br.ipen.cestoque.domain.Produto;

public interface EmailService {

	void sendProdutoConfirmationEmail(Produto obj);
	
	void sendEmail(SimpleMailMessage msg);

	void sendNewPassowrdEmail(Colaborador colaborador, String newPass);
}
