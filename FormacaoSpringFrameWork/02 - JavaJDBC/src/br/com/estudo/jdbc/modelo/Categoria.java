package br.com.estudo.jdbc.modelo;

public class Categoria {
	
	private Integer id;
	private String nome;
	
	public Categoria(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public String getNome() {
		
		return this.nome;
	}

	public int getId() {
		return this.id;
	}
	
	/*@Override
	public String toString() {
		return String.format("Categorias cadastradas: ID: %d, Nome: %s", this.id, this.nome);
	}*/
}
