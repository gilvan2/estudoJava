package br.com.estudo.modelo;

import javax.persistence.Embeddable;

@Embeddable //Informando a JPA que esses campos são embitiveis na entidade de cliente
public class DadosPessoais {
	//Agrupar os campos de dados pessoais da entidade Cliente
	private String nome;
	private String cpf;
	
	public DadosPessoais() {}
	
	public DadosPessoais(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

}
