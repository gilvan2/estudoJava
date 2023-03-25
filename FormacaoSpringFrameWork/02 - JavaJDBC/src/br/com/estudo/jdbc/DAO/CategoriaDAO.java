package br.com.estudo.jdbc.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.estudo.jdbc.modelo.Categoria;
import br.com.estudo.jdbc.modelo.Produto;

public class CategoriaDAO {
	
	private Connection connection;
	
	public CategoriaDAO(Connection connection) {
		this.connection = connection;
	
	}
	
	public List<Categoria> listar() throws SQLException{
		
		List<Categoria> categorias = new ArrayList<Categoria>();
		
		System.out.println("EXECUTANDO A QUERY DE BUSCAR CATEGORIA");
		String sql = "SELECT ID, NOME FROM CATEGORIA";
		
		try(PreparedStatement pstm = connection.prepareStatement(sql)){
			
			pstm.execute();
			
			try(ResultSet rst = pstm.getResultSet()){
				while(rst.next()) {
					Categoria categoria = new Categoria(rst.getInt(1), rst.getString(2));
					categorias.add(categoria);
				}
			}
		}
		return categorias;
	}
}
