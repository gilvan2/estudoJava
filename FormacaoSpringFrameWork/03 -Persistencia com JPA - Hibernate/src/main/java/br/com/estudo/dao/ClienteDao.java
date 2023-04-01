package br.com.estudo.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.estudo.modelo.Cliente;
import br.com.estudo.modelo.Pedido;
import br.com.estudo.modelo.Produto;

public class ClienteDao {
	
	private EntityManager em;

	public ClienteDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Cliente cliente) {
		this.em.persist(cliente);
	}
	
	public Cliente buscarPorId(long id) {
		return em.find(Cliente.class, id);
	}	
}
