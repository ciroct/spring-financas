package br.unisantos.financas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisantos.financas.model.Conta;
import br.unisantos.financas.repositories.ContaRepository;


@Service
public class ContaService implements ServiceInterface<Conta> {
	
	@Autowired
	private ContaRepository contaRepo;
	
	public ContaService() {}
	
	@Override
	public Conta create(Conta obj) {
		contaRepo.save(obj);
		return obj;
	}

	@Override
	public Conta findById(Long id) {
		Optional<Conta> _conta = contaRepo.findById(id);
		return _conta.orElse(null);
	}

	@Override
	public List<Conta> findAll() {
		return contaRepo.findAll();
	}
	
	public List<Conta> listarPorBanco(String banco) {
		return contaRepo.listarPorBanco('%' + banco + '%');
	}
	
	public List<Conta> listarPorBancoENumero(String banco, Integer from, Integer to) {
		return contaRepo.listarPorBancoENumero(banco, from, to);		
	}

	public List<Conta> listarPorNomeCliente(String nome) {
		return contaRepo.listarPorNomeCliente('%' + nome + '%');
	}
	
	public boolean update(Conta obj) {
		if (contaRepo.existsById(obj.getId())) {
			contaRepo.save(obj);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Long id) {
		Optional<Conta> _conta = contaRepo.findById(id);
		if (_conta.isPresent()) {
			contaRepo.delete(_conta.get());
			return true;
		}
		return false;
	}

}

