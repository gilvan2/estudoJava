package br.com.estudo.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.estudo.dao.CategoriaDao;
import br.com.estudo.dao.ClienteDao;
import br.com.estudo.dao.PedidoDao;
import br.com.estudo.dao.ProdutoDao;
import br.com.estudo.modelo.Categoria;
import br.com.estudo.modelo.Cliente;
import br.com.estudo.modelo.ItemPedido;
import br.com.estudo.modelo.Pedido;
import br.com.estudo.modelo.Produto;
import br.com.estudo.util.JPAUtil;

public class CadastroDePedido {

	public static void main(String[] args) {
		
		popularBancoDeDados();
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		ClienteDao clienteDao = new ClienteDao(em);
		
		Produto produto = produtoDao.buscarPorId(1L);
		Cliente cliente = clienteDao.buscarPorId(1L);
		
		em.getTransaction().begin();
		
		Pedido pedido = new Pedido(cliente);
		pedido.adicionarItem(new ItemPedido(10, pedido, produto));
		PedidoDao pedidoDao = new PedidoDao(em);
		em.getTransaction().commit();

	}

	private static void popularBancoDeDados() {
		Categoria categoria = new Categoria("CELULAR");

		Produto celular = new Produto("Xiaomi Redmi","Muito legak",new BigDecimal("800"), categoria);

		Cliente cliente = new Cliente("Gilvan Junior","01401423470");
		
		EntityManager em = JPAUtil.getEntityManager();
		
		//Perceba que eu não deixei a criação do em no dao, já passo a conexão feita para ela, com isso eu desacoplo a dao do banco de dados
		CategoriaDao categoriaDao = new CategoriaDao(em);
		
		ClienteDao clienteDao = new ClienteDao(em);
		
		ProdutoDao produtoDao = new ProdutoDao(em);
		//Pelo fato do nosso controle de transação sem RESOURCE_LOCAL, obrigatóriamente indicamos quando a trnsação começa e quando termina
		
		em.getTransaction().begin();
		//em.persist(celular);
		categoriaDao.cadastrar(categoria);
		produtoDao.cadastrar(celular);
		clienteDao.cadastrar(cliente);
		em.getTransaction().commit();
		em.close();
	}
}
