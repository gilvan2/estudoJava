package br.com.estudo.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.estudo.jdbc.modelo.Produto;

public class TestaInsercaoComproduto {

	public static void main(String[] args) throws SQLException {
		
		Produto comoda = new Produto("Cômoda","Cômoda Vertical");
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		try(Connection con = connectionFactory.recuperarConexao()){
			
			String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?,?)";
			
			try(PreparedStatement pstm = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)){
				pstm.setString(1, comoda.getNome());
				pstm.setString(2, comoda.getDescricao());
				
				pstm.execute();
				
				try(ResultSet rst = pstm.getGeneratedKeys()){
					while(rst.next()) {
						comoda.setId(rst.getInt(1));
					}
				}
			}
			
			System.out.println(comoda);
		}
	}
}
