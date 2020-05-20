package br.unisantos.financas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "tb_categoria")
@Entity
@NamedQueries({
	@NamedQuery(name = "Categoria.listarTodas",
			    query = "select c from Categoria c order by c.nome"),
	@NamedQuery(name = "Categoria.consultarPorId",
    			query = "select c from Categoria c where c.id=?1"),
	@NamedQuery(name = "Categoria.listarPorNome",
				query = "select c from Categoria c where c.nome like ?1 order by c.nome") 

})
public class Categoria extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	@Column(name = "nm_nome", length = 50)
	private String nome;
	
	public Categoria() { } 
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
