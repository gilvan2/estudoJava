package br.com.estudo.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.estudo.jdbc.DAO.ProdutoDAO;
import br.com.estudo.jdbc.modelo.Produto;

public class TestaInsercaoComProduto {

	public static void main(String[] args) throws SQLException {
		
		Produto comoda = new Produto("Cômoda","Cômoda Vertical");
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		try(Connection con = connectionFactory.recuperarConexao()){
			
			ProdutoDAO produtoDAO = new ProdutoDAO(con);
			//new PersistenciaProduto(con).salvarProduto(comoda);
			produtoDAO.salvar(comoda);
			//persistenciaProduto.listar();
			
			System.out.println(comoda);
		}
	}
}
