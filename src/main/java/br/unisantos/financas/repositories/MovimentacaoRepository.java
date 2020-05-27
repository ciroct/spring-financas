package br.unisantos.financas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unisantos.financas.model.Movimentacao;


@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {

}
