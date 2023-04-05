package br.com.estudo.modelo;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="produtos")
public class Produto {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descricao;
	private BigDecimal preco;
	private LocalDate dataCadastro = LocalDate.now();
	//Vc é obrigado a dizer a cardinalidade entre as tabelas, por padrão o java não lança nada
	@ManyToOne(fetch = FetchType.LAZY)
	private Categoria categoria;
	
	public Produto() {}
	
	public Produto(String nome, String descricao, BigDecimal preco, Categoria categoria) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.categoria = categoria;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public LocalDate getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	//Caso o nome do campo seja diferente do que esta na aentidade, usar a anootação column com o nome do campo no banco de dados
	//Para projetos em hibernate, não precisamos indicar o path da classe no persistence.xml
	//<class>br.com.alura.loja.modelo.Produto</class>
	
}
