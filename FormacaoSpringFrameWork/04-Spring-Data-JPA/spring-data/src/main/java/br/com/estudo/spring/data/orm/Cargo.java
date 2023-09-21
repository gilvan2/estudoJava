package br.com.estudo.spring.data.orm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table(name = "cargos")
public class Cargo {
	@javax.persistence.Id
	@GeneratedValue
	private Integer Id;
	private String descricao;
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
