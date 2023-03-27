package br.com.estudo.modelo;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Produto {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Table(name = "produtos")
	private Long id;
	private String nome;
	private String descricao;
	private BigDecimal preco;
	
	//Caso o nome do campo seja diferente do que esta na aentidade, usar a anootação column com o nome do campo no banco de dados

}
