package br.com.estudo.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.estudo.dao.ProdutoDao;
import br.com.estudo.modelo.Categoria;
import br.com.estudo.modelo.Produto;
import br.com.estudo.util.JPAUtil;

public class CadastroDeprodutos {

	public static void main(String[] args) {

		Produto celular = new Produto("Xiaomi Redmi","Muito legak",new BigDecimal("800"), Categoria.CELULARRES);

		EntityManager em = JPAUtil.getEntityManager();
		
		//Perceba que eu não deixei a criação do em no dao, já passo a conexão feita para ela, com isso eu desacoplo a dao do banco de dados
		ProdutoDao dao = new ProdutoDao(em);
		//Pelo fato do nosso controle de transação sem RESOURCE_LOCAL, obrigatóriamente indicamos quando a trnsação começa e quando termina
		
		em.getTransaction().begin();
		//em.persist(celular);
		dao.cadastrar(celular);
		em.getTransaction().commit();
		em.close();

	}

}
