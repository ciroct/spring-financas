package br.unisantos.financas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unisantos.financas.model.PessoaFisica;

public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long> {

}
