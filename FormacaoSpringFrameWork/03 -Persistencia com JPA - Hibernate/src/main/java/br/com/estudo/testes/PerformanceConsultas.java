package br.com.estudo.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.estudo.modelo.Categoria;
import br.com.estudo.modelo.Produto;
import br.com.estudo.util.JPAUtil;

public class PerformanceConsultas {

	public static void main(String[] args) {
		popularBancoDeDados();
		EntityManager em = JPAUtil.getEntityManager();

	}

	private static void popularBancoDeDados() {
		Categoria celulares = new Categoria("CELULARES");
		Categoria videoGames = new Categoria("VIDEO GAMES");
		Categoria informatica = new Categoria("INFORMATICA");
		
		Produto celular = new Produto("Xiaomi RedMI", "Celular perfeito para jogos", new BigDecimal("800"), celulares); 
		
	}

}
