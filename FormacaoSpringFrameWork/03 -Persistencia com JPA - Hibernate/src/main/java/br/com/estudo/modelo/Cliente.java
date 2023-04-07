package br.com.estudo.modelo;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Embedded //Indicando a JPA para embutir os campos da classe dados pessoais na hora de criar as consultas no banco
	private DadosPessoais dadosPessoais;

	public Cliente() {
	}

	public Cliente(String nome, String cpf) {
		
		//Separei em uma classe a parte com atributos agrupados, afim de organizar a minha entidade cliente e não permitir que ela se torne gigante
		this.dadosPessoais = new DadosPessoais(nome, cpf);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DadosPessoais getDadosPessoais() {
		return dadosPessoais;
	}
	//Method delegat - Como antes tinham uma porrada de lugares chamado o get nome, eu delegui para esse metodo chamar o getNome da classe DadosPessoais
	public String getNome() {
		return this.dadosPessoais.getNome();
	}
	
	

}
