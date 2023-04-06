package br.com.estudo.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.estudo.modelo.Pedido;
import br.com.estudo.modelo.Produto;
import br.com.estudo.vo.RelatorioDeVendasVo;

public class PedidoDao {
	
	private EntityManager em;

	public PedidoDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Pedido pedido) {
		this.em.persist(pedido);
	}	
	
	public BigDecimal valorTotalVendido() {
		String jpql = "SELECT SUM(p.valorTotal) FROM Pedido p";
		return em.createQuery(jpql, BigDecimal.class).getSingleResult();
	}
	
	public List<RelatorioDeVendasVo> relatorioDeVendas(){
		//Aplicando o new total path da classe, a JPA vai entender que isso não é uma entidade e vai criar uma instancia de objetos para o relatório
		String jpql = "SELECT new br.com.estudo.vo.RelatorioDeVendasVo("
				+ "produto.nome "
				+ ",SUM(item.quantidade) "
				+ ",MAX(pedido.data)) "
				+ "FROM Pedido pedido "
				+ "JOIN pedido.itens item "
				+ "JOIN item.produto produto "
				+ "GROUP BY produto.nome "
				+ "ORDER BY item.quantidade DESC";
		
		return em.createQuery(jpql, RelatorioDeVendasVo.class).getResultList();
				
	}
	
	public Pedido buscarPedidoComCliente(Long id) {//JOIN FETCH carrega um relacionamento LAZY para essa consulta especificamente
		return em.createQuery("SELECT p FROM Pedido p JOIN FETCH p.cliente WHERE p.id = :id",Pedido.class).setParameter("id", id).getSingleResult();
	}
}
