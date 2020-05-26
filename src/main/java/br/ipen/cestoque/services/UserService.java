package br.ipen.cestoque.services;

import org.springframework.security.core.context.SecurityContextHolder;

import br.ipen.cestoque.security.UserSS;

public class UserService {

	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		} catch (Exception e) {
			return null;
		}
	}
	
}
