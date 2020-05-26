package br.unisantos.financas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unisantos.financas.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
