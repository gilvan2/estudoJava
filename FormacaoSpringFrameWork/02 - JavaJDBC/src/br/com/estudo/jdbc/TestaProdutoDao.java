package br.com.estudo.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.estudo.jdbc.DAO.ProdutoDAO;
import br.com.estudo.jdbc.modelo.Produto;

public class TestaProdutoDao {

	public static void main(String[] args) throws SQLException {
		Produto comoda = new Produto("Cômoda","Cômoda Vertical");
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		try(Connection con = connectionFactory.recuperarConexao()){
			
			ProdutoDAO produtoDAO = new ProdutoDAO(con);
			//new PersistenciaProduto(con).salvarProduto(comoda);
			produtoDAO.salvar(comoda);
			//Chamoou a uma lista de produtos 
			List<Produto> listaDeProdutos =  produtoDAO.listar();
			//Lambia para listar de acordo com o toString que foi sobreescrito em |ProdutoDAO
			listaDeProdutos.stream().forEach(lp -> System.out.println(lp));
		}

	}

}
