package br.com.estudo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.estudo.modelo.Produto;

public class ProdutoDao {
	
	private EntityManager em;

	public ProdutoDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Produto produto) {
		this.em.persist(produto);
	}
	
	public Produto buscarPorId(Long id) {
		return em.find(Produto.class, id);
	}
	
	public List<Produto> buscarTodos(){
		//JPQL -> Monta uma query parecido com sql
		
		String jpql = "SELECT p FROM Produto p";
		
		return em.createQuery(jpql, Produto.class).getResultList();
	}
}
