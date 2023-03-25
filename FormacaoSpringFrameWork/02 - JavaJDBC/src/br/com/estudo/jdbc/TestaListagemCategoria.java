package br.com.estudo.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.estudo.jdbc.DAO.CategoriaDAO;
import br.com.estudo.jdbc.DAO.ProdutoDAO;
import br.com.estudo.jdbc.modelo.Categoria;
import br.com.estudo.jdbc.modelo.Produto;

public class TestaListagemCategoria {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		try(Connection con = connectionFactory.recuperarConexao()){
			
			CategoriaDAO categoriaDAO = new CategoriaDAO(con);
			
			List<Categoria> listaDeCategorias = categoriaDAO.listar();
			
			listaDeCategorias.stream().forEach(lc -> {
				System.out.println(lc.getNome());
				
				try {
					for(Produto produto : new ProdutoDAO(con).buscar(lc)) {
						System.out.println(lc.getNome() + " - " + produto.getNome());
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				});
		}
	}
}
