package br.ipen.cestoque.resources;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ipen.cestoque.domain.Colaborador;
import br.ipen.cestoque.dto.ColaboradorAlterPassDTO;
import br.ipen.cestoque.dto.EmailDTO;
import br.ipen.cestoque.repositories.ColaboradorRepository;
import br.ipen.cestoque.security.JWTUtil;
import br.ipen.cestoque.security.UserSS;
import br.ipen.cestoque.services.AuthService;
import br.ipen.cestoque.services.EmailService;
import br.ipen.cestoque.services.UserService;
import br.ipen.cestoque.services.exception.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/auth")
public class AuthResource {

	@Autowired
	private JWTUtil jwtUtil;

	@Autowired
	private AuthService service;

	@Autowired
	private BCryptPasswordEncoder pe;

	@Autowired
	private ColaboradorRepository colaboradorRepository;

	@Autowired
	private EmailService emailService;

	@RequestMapping(value = "/refresh_token", method = RequestMethod.POST)
	public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
		UserSS user = UserService.authenticated();
		String token = jwtUtil.generateToken(user.getUsername());
		response.addHeader("Authorization", "Bearer " + token);
		response.addHeader("access-control-expose-headers", "Authorization");
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/forgot", method = RequestMethod.POST)
	public ResponseEntity<Void> forgot(@Valid @RequestBody EmailDTO objDTO) {
		service.sendNewPassword(objDTO.getEmail());
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/alterpass", method = RequestMethod.POST)
	public ResponseEntity<Void> alterpass(@RequestBody ColaboradorAlterPassDTO objDTO) {

		if (objDTO != null) {
			if (objDTO.getEmail() != null) {
				Colaborador colaborador = colaboradorRepository.findByEmail(objDTO.getEmail());

				if (colaborador == null) {
					throw new ObjectNotFoundException("Email não encontrado.");
				}

				colaborador.setSenha(pe.encode(objDTO.getSenha()));
				colaboradorRepository.save(colaborador);
				emailService.sendNewPassowrdEmail(colaborador, objDTO.getSenha());
			}
		}

		return ResponseEntity.noContent().build();
	}

}
