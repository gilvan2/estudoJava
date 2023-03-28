package br.com.estudo.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("loja");
	
	
	/**
	 * Para se criar uma conexão com o banco de dados, precisamos implementar uma interface e usar o método descrito embaixo para buscar o nome da
	 * entidade cadastrada no persistence-unit presente no arquivo persistence.xml*/
	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();
	}

}
