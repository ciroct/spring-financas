package br.unisantos.financas.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unisantos.financas.exception.AuthorizationException;
import br.unisantos.financas.model.PessoaFisica;
import br.unisantos.financas.services.PessoaFisicaService;


@RestController
@RequestMapping("/pessoas_fisicas")
public class PessoaFisicaResource implements ResourceInterface<PessoaFisica> {

	@Autowired
	private PessoaFisicaService pfService;
	
	
	public PessoaFisicaResource() {
	}

	@Override
	@GetMapping
	public ResponseEntity<List<PessoaFisica>> get() {		
		return ResponseEntity.ok(pfService.findAll());
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") Long id) {
		try {
			PessoaFisica _pf = pfService.findById(id);
			if (_pf != null) {
				return ResponseEntity.ok(_pf);
			}
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} catch (AuthorizationException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}

	@Override
	@PostMapping
	public ResponseEntity<PessoaFisica> post(@RequestBody PessoaFisica obj) {
		pfService.create(obj);
		return ResponseEntity.ok(obj);
	}

	@Override
	@PutMapping
	public ResponseEntity<?> put(@RequestBody PessoaFisica obj) {
		if (pfService.update(obj)) {
			return ResponseEntity.ok(obj);				
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();		
	}

	@Override
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		if (pfService.delete(id)) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

}
