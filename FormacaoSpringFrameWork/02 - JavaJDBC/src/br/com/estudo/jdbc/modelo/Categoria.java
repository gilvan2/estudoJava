package br.com.estudo.jdbc.modelo;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
	
	private Integer id;
	private String nome;
	private List<Produto> produtos = new ArrayList<Produto>();
	
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

	public void adicionar(Produto produto) {
		produtos.add(produto);
		
	}

	public List<Produto> getProdutos() {
		// TODO Auto-generated method stub
		return this.produtos;
	}
	
	/*@Override
	public String toString() {
		return String.format("Categorias cadastradas: ID: %d, Nome: %s", this.id, this.nome);
	}*/
}
