package br.unisantos.financas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unisantos.financas.model.Movimentacao;


public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {

}
