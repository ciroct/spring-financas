package br.unisantos.financas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisantos.financas.model.Categoria;
import br.unisantos.financas.repositories.CategoriaRepository;

@Service
public class CategoriaService implements ServiceInterface<Categoria> {

	@Autowired
	private CategoriaRepository categoriaRepo;

	@Override
	public Categoria create(Categoria obj) {
		categoriaRepo.save(obj);
		return obj;
	}

	@Override
	public Categoria findById(Long id) {
		Optional<Categoria> _categoria = categoriaRepo.findById(id);
		return _categoria.orElse(null);
	}

	@Override
	public List<Categoria> findAll() {
		return categoriaRepo.findAll();
	}

	@Override
	public boolean update(Categoria obj) {
		if (categoriaRepo.existsById(obj.getId())) {
			categoriaRepo.save(obj);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Long id) {
		Optional<Categoria> _categoria = categoriaRepo.findById(id);
		if (_categoria.isPresent()) {
			categoriaRepo.delete(_categoria.get());
			return true;
		}
		return false;
	}

}
