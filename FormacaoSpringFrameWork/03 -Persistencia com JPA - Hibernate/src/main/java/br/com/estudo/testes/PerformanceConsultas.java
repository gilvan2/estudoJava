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

public class PerformanceConsultas {

	public static void main(String[] args) {
		popularBancoDeDados();
		EntityManager em = JPAUtil.getEntityManager();
		
		//Primeiro teste,
		Pedido pedido = em.find(Pedido.class, 1l);
		System.out.println(pedido.getItens().size());

	}

	private static void popularBancoDeDados() {
		Categoria celulares = new Categoria("CELULARES");
		Categoria videoGames = new Categoria("VIDEO GAMES");
		Categoria informatica = new Categoria("INFORMATICA");
		
		Produto celular = new Produto("Xiaomi RedMi", "Celular perfeito para jogos", new BigDecimal("800"), celulares);
		Produto videoGame = new Produto("PS5", "Play Station 5", new BigDecimal("4000"), videoGames);
		Produto macbook = new Produto("Macbook", "Macbook Pro", new BigDecimal("8000"), informatica);
		
		Cliente cliente = new Cliente("Gilvan","370.410.813-07");
		
		Pedido pedido = new Pedido(cliente);
		pedido.adicionarItem(new ItemPedido(10,pedido,celular));
		pedido.adicionarItem(new ItemPedido(40,pedido,videoGame));
		
		Pedido pedido2 = new Pedido(cliente);
		pedido2.adicionarItem(new ItemPedido(2, pedido2, macbook));
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		ClienteDao clienteDao = new ClienteDao(em);
		PedidoDao pedidoDao = new PedidoDao(em);
		
		em.getTransaction().begin();
		
		categoriaDao.cadastrar(celulares);
		categoriaDao.cadastrar(videoGames);
		categoriaDao.cadastrar(informatica);
		
		produtoDao.cadastrar(celular);
		produtoDao.cadastrar(videoGame);
		produtoDao.cadastrar(macbook);
		
		clienteDao.cadastrar(cliente);
		
		pedidoDao.cadastrar(pedido);
		pedidoDao.cadastrar(pedido2);
		
		em.getTransaction().commit();
		
	}

}
