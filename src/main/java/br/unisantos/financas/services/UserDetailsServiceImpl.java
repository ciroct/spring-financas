package br.unisantos.financas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.unisantos.financas.model.Cliente;
import br.unisantos.financas.repositories.ClienteRepository;
import br.unisantos.financas.security.UserDetailsImpl;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private ClienteRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Cliente cliente = repo.findByLogin(username);
		if (cliente == null) {
			throw new UsernameNotFoundException(username);
		}
		return new UserDetailsImpl(cliente.getId(), cliente.getLogin(), cliente.getSenha(), cliente.getPerfis());
	}

}
