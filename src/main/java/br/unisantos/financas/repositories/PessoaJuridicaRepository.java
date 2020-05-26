package br.unisantos.financas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unisantos.financas.model.PessoaJuridica;

public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica, Long> {

}
