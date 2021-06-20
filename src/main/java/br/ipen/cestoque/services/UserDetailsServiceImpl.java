package br.ipen.cestoque.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.ipen.cestoque.domain.Colaborador;
import br.ipen.cestoque.repositories.ColaboradorRepository;
import br.ipen.cestoque.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private ColaboradorRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		Colaborador col = repo.findByEmail(email);
		
		
		if(col == null) {
			throw new UsernameNotFoundException(email);
		}
		
		
		return new UserSS(col.getId(), email, col.getSenha(),col.getNome(), col.getPerfis());
	}

}
