package br.ipen.cestoque.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.ipen.cestoque.domain.Colaborador;
import br.ipen.cestoque.repositories.ColaboradorRepository;
import br.ipen.cestoque.services.exception.ObjectNotFoundException;

@Service
public class AuthService {
	
	@Autowired
	private ColaboradorRepository colaboradorRepository;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private EmailService emailService;
	
	private Random rand = new Random();
	
	public void sendNewPassword(String email) {
		
		Colaborador colaborador = colaboradorRepository.findByEmail(email);
		
		if(colaborador == null) {
			throw new ObjectNotFoundException("Email não encontrado.");
		}
		
		String newPass = newPassword();
		colaborador.setSenha(pe.encode(newPass));
		colaboradorRepository.save(colaborador);
		emailService.sendNewPassowrdEmail(colaborador, newPass);
	}

	private String newPassword() {
		char[] vet = new char[10];
		for (int i = 0; i < 10; i++) {
			vet[i] = randomChar();
		}
		return new String(vet);
	}

	private char randomChar() {
		int opt = rand.nextInt(3);
		if(opt == 0) {
			return (char) (rand.nextInt(10) + 48);
		}else if(opt == 1) {
			return (char) (rand.nextInt(26) + 65);
		}else {
			return (char) (rand.nextInt(26) + 97);
		}
	}
}
