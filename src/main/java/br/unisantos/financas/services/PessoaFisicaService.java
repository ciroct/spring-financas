package br.unisantos.financas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.unisantos.financas.exception.AuthorizationException;
import br.unisantos.financas.model.PessoaFisica;
import br.unisantos.financas.repositories.PessoaFisicaRepository;
import br.unisantos.financas.security.JWTUtil;

@Service
public class PessoaFisicaService implements ServiceInterface<PessoaFisica> {

	@Autowired
	private PessoaFisicaRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	
	public PessoaFisicaService() {
	}

	@Override
	public PessoaFisica create(PessoaFisica obj) {
		obj.setSenha(passwordEncoder.encode(obj.getSenha()));
		repo.save(obj);
		return obj;
	}

	@Override
	public PessoaFisica findById(Long id) throws AuthorizationException {
		if (!jwtUtil.authorized(id)) {
			throw new AuthorizationException("Acesso negado!");
		}
		Optional<PessoaFisica> _pf = repo.findById(id);
		return _pf.orElse(null);
	}

	@Override
	public List<PessoaFisica> findAll() {
		return repo.findAll();
	}

	@Override
	public boolean update(PessoaFisica obj) {
		if (repo.existsById(obj.getId())) {
			repo.save(obj);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Long id) {
		Optional<PessoaFisica> _pf = repo.findById(id);
		if (_pf.isPresent()) {
			repo.delete(_pf.get());
			return true;
		}
		return false;
	}


}
