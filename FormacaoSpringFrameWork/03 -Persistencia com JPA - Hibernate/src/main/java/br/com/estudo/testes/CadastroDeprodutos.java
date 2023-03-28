package br.com.estudo.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.estudo.modelo.Produto;

public class CadastroDeprodutos {

	public static void main(String[] args) {

		Produto celular = new Produto();
		celular.setNome("Xiaomi Redmi");
		celular.setDescricao("Muito legak");
		celular.setPreco(new BigDecimal("800"));
		
		
		/**
		 * Para se criar uma conexão com o banco de dados, precisamos implementar uma interface e usar o método descrito embaixo para buscar o nome da
		 * entidade cadastrada no persistence-unit presente no arquivo persistence.xml*/
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("loja");
		
		EntityManager em = factory.createEntityManager();
		
		//Pelo fato do nosso controle de transação sem RESOURCE_LOCAL, obrigatóriamente indicamos quando a trnsação começa e quando termina
		
		em.getTransaction().begin();
		em.persist(celular);
		em.getTransaction().commit();
		em.close();

	}

}
