package br.com.estudo.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.estudo.dao.CategoriaDao;
import br.com.estudo.dao.ProdutoDao;
import br.com.estudo.modelo.Categoria;
import br.com.estudo.modelo.Produto;
import br.com.estudo.util.JPAUtil;

public class CadastroDeprodutos {

	public static void main(String[] args) {
		
		Categoria categoria = new Categoria("CELULAR");

		Produto celular = new Produto("Xiaomi Redmi","Muito legak",new BigDecimal("800"), categoria);

		EntityManager em = JPAUtil.getEntityManager();
		
		//Perceba que eu não deixei a criação do em no dao, já passo a conexão feita para ela, com isso eu desacoplo a dao do banco de dados
		CategoriaDao categoriaDao = new CategoriaDao(em);
		
		ProdutoDao produtoDao = new ProdutoDao(em);
		//Pelo fato do nosso controle de transação sem RESOURCE_LOCAL, obrigatóriamente indicamos quando a trnsação começa e quando termina
		
		em.getTransaction().begin();
		//em.persist(celular);
		categoriaDao.cadastrar(categoria);
		
		produtoDao.cadastrar(celular);
		em.getTransaction().commit();
		em.close();

	}

}
